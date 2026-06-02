package com.sdapro.facade;

import com.sdapro.strategy.AggressiveStrategy;
import com.sdapro.strategy.ConservativeStrategy;
import com.sdapro.notification.EmailNotifier;

// PATTERN: Facade
/**
 * Facade class that provides a simple unified interface for orchestrating incident responses.
 * Clients interface solely with this facade, decoupling them from the complexities of
 * threat intel scanning, strategy resolution, mitigation execution, and notifications.
 */
public class IncidentResponseFacade {
    private final ThreatIntelService threatIntelService;
    private final ResponseService responseService;
    private final EmailNotifier emailNotifier;

    /**
     * Constructor initializing the Facade with its subsystem dependencies.
     *
     * @param threatIntelService The threat intelligence service (typically a proxy).
     * @param responseService    The strategy context for executing mitigations.
     * @param emailNotifier      The notification service.
     */
    public IncidentResponseFacade(ThreatIntelService threatIntelService,
                                  ResponseService responseService,
                                  EmailNotifier emailNotifier) {
        this.threatIntelService = threatIntelService;
        this.responseService = responseService;
        this.emailNotifier = emailNotifier;
    }

    /**
     * High-level entry point to handle an incident.
     * Orchestrates scanning, decision-making (strategy selection), execution, and notification.
     *
     * @param incidentId Unique identifier for the incident.
     * @param ipAddress  The culprit IP address associated with the incident.
     */
    public void handleIncident(String incidentId, String ipAddress) {
        System.out.println("\n========================================================================");
        System.out.println("[FACADE] Beginning incident orchestration pipeline for " + incidentId);
        System.out.println("========================================================================");

        // Step 1: Scan IP (Uses Proxy, which uses Adapter, which wraps ThirdPartyVirusTotalApi)
        String scanReport = threatIntelService.scanIp(ipAddress);
        System.out.println("[FACADE] Scan Report obtained: " + scanReport);

        // Step 2: Determine appropriate strategy based on threat rating in report
        System.out.println("[FACADE] Analyzing threat rating to select mitigation strategy...");
        if (scanReport.contains("CRITICAL_MALICIOUS")) {
            System.out.println("[FACADE] High severity threat detected. Selecting Aggressive Mitigation.");
            responseService.setStrategy(new AggressiveStrategy());
        } else {
            System.out.println("[FACADE] Low/Medium or clean threat level. Selecting Conservative Mitigation.");
            responseService.setStrategy(new ConservativeStrategy());
        }

        // Step 3: Execute Response
        responseService.executeResponse(incidentId, ipAddress);

        // Step 4: Notify stakeholders
        String subject = "SECURITY ALERT: Incident " + incidentId + " Processed";
        String body = String.format(
                "Incident ID: %s\nTarget IP Source: %s\nScan Results: %s\nMitigation Status: Action successfully completed.",
                incidentId, ipAddress, scanReport
        );
        emailNotifier.sendEmailAlert("soc-team@sdapro.com", subject, body);

        System.out.println("\n[FACADE] Completed incident orchestration pipeline for " + incidentId);
        System.out.println("========================================================================\n");
    }
}
