package com.sdapro.adapter;

import com.sdapro.facade.ThreatIntelService;

// PATTERN: Adapter (Adapter Class)
/**
 * Adapter that integrates ThirdPartyVirusTotalApi into the ThreatIntelService interface.
 * Implements the target interface and translates calls to the adaptee's methods.
 */
public class VirusTotalAdapter implements ThreatIntelService {
    private final ThirdPartyVirusTotalApi virusTotalApi;

    /**
     * Constructor initializing the adaptee instance.
     *
     * @param virusTotalApi The external VirusTotal API client instance.
     */
    public VirusTotalAdapter(ThirdPartyVirusTotalApi virusTotalApi) {
        this.virusTotalApi = virusTotalApi;
    }

    @Override
    public String scanIp(String ipAddress) {
        System.out.println("[ADAPTER] Adapting ThreatIntelService.scanIp() to ThirdPartyVirusTotalApi...");
        
        // Fetch raw score from third-party api
        int score = virusTotalApi.getIpReputationScore(ipAddress);
        
        // Translate the Adaptee's representation (integer score) into our target representation (String classification report)
        String rating;
        if (score >= 80) {
            rating = "CRITICAL_MALICIOUS";
        } else if (score >= 50) {
            rating = "SUSPICIOUS";
        } else if (score >= 15) {
            rating = "LOW_RISK";
        } else {
            rating = "CLEAN";
        }

        return String.format("VirusTotal Report - IP: %s | Threat Score: %d/100 | Class: %s", ipAddress, score, rating);
    }
}
