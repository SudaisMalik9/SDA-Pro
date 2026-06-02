package com.sdapro;

import com.sdapro.facade.IncidentResponseFacade;
import com.sdapro.facade.ResponseService;
import com.sdapro.facade.ThreatIntelService;
import com.sdapro.adapter.ThirdPartyVirusTotalApi;
import com.sdapro.adapter.VirusTotalAdapter;
import com.sdapro.proxy.ThreatIntelProxy;
import com.sdapro.notification.EmailNotifier;

/**
 * Driver class to compile, run, and demonstrate the integrated design patterns:
 * Facade, Strategy, Adapter, Proxy, and Simple Notification.
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("========================================================================");
        System.out.println("            SDA-PRO THREAT INTELLIGENCE PROXY DEMONSTRATION");
        System.out.println("            Student B: feature/B-threat-intel-proxy");
        System.out.println("========================================================================\n");

        // 1. Initialize Subsystem Components
        System.out.println("[DEMO] Initializing subsystem components...");
        
        // Adaptee (Third-party SDK)
        ThirdPartyVirusTotalApi externalApi = new ThirdPartyVirusTotalApi();
        
        // Adapter (Adapting externalApi to ThreatIntelService interface)
        // PATTERN: Adapter
        ThreatIntelService adaptedService = new VirusTotalAdapter(externalApi);
        
        // Proxy (Wrapping adapted service to add logging and cache)
        // PATTERN: Proxy
        ThreatIntelProxy proxyService = new ThreatIntelProxy(adaptedService);
        
        // Strategy Context
        // PATTERN: Strategy Context
        ResponseService responseService = new ResponseService();
        
        // Notification Service
        // PATTERN: Notification Service
        EmailNotifier emailNotifier = new EmailNotifier();

        // Facade (Simplifying workflow orchestration)
        // PATTERN: Facade
        IncidentResponseFacade securityFacade = new IncidentResponseFacade(
                proxyService,
                responseService,
                emailNotifier
        );

        System.out.println("[DEMO] System components initialized successfully.\n");

        // --- TEST SCENARIO 1: Handle Low-Threat / Benign IP ---
        // Expected outcome: Cache Miss, Conservative Strategy selected, Email notified.
        System.out.println("------------------------------------------------------------------------");
        System.out.println("TEST SCENARIO 1: Processing Local/Benign IP (192.168.1.100)");
        System.out.println("------------------------------------------------------------------------");
        securityFacade.handleIncident("INC-2026-001", "192.168.1.100");


        // --- TEST SCENARIO 2: Handle Malicious IP ---
        // Expected outcome: Cache Miss, Aggressive Strategy selected, Email notified.
        System.out.println("------------------------------------------------------------------------");
        System.out.println("TEST SCENARIO 2: Processing Confirmed Malicious IP (198.51.100.42)");
        System.out.println("------------------------------------------------------------------------");
        securityFacade.handleIncident("INC-2026-002", "198.51.100.42");


        // --- TEST SCENARIO 3: Demonstrate Proxy Caching (Cache Hit) ---
        // Expected outcome: Cache Hit, Aggressive Strategy selected, Email notified.
        // The Proxy should intercept and return the result without querying the real service.
        System.out.println("------------------------------------------------------------------------");
        System.out.println("TEST SCENARIO 3: Re-processing Malicious IP (198.51.100.42) - Caching Demo");
        System.out.println("------------------------------------------------------------------------");
        System.out.println("[DEMO] Sending incident request for same IP again to trigger Proxy Cache hit.");
        securityFacade.handleIncident("INC-2026-003", "198.51.100.42");


        // --- TEST SCENARIO 4: Verify Caching directly on Proxy ---
        System.out.println("------------------------------------------------------------------------");
        System.out.println("TEST SCENARIO 4: Direct Caching Inspection via Proxy");
        System.out.println("------------------------------------------------------------------------");
        
        System.out.println("[DEMO] Querying proxy directly for an IP (185.190.140.1)...");
        String report1 = proxyService.scanIp("185.190.140.1");
        System.out.println("[DEMO] Result 1: " + report1);

        System.out.println("\n[DEMO] Querying proxy directly for same IP (185.190.140.1) again...");
        String report2 = proxyService.scanIp("185.190.140.1");
        System.out.println("[DEMO] Result 2 (should be cached): " + report2);

        System.out.println("\n[DEMO] Clearing Proxy Cache...");
        proxyService.clearCache();

        System.out.println("\n[DEMO] Querying proxy directly after cache clear...");
        String report3 = proxyService.scanIp("185.190.140.1");
        System.out.println("[DEMO] Result 3 (should be Cache Miss): " + report3);

        System.out.println("\n========================================================================");
        System.out.println("            DEMONSTRATION RUN COMPLETE");
        System.out.println("========================================================================");
    }
}
