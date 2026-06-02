package com.sdapro.adapter;

// PATTERN: Adapter (Adaptee)
/**
 * Simulated external threat intelligence client (Adaptee).
 * Represents a proprietary class from a third-party SDK (like VirusTotal)
 * with a legacy or custom method signature that does not match our interface.
 */
public class ThirdPartyVirusTotalApi {

    /**
     * Checks reputation score of an IP address.
     *
     * @param ip The IP address.
     * @return Reputation score as an integer from 0 (perfectly clean) to 100 (confirmed malware/malicious).
     */
    public int getIpReputationScore(String ip) {
        if (ip == null || ip.isEmpty()) {
            return 0;
        }

        // Benign IPs
        if (ip.startsWith("192.168.") || ip.startsWith("10.") || ip.equals("127.0.0.1")) {
            return 5;
        }

        // Suspicious IP (e.g., 185.x.x.x)
        if (ip.startsWith("185.")) {
            return 55;
        }

        // Malicious IP (e.g., 198.51.100.x)
        if (ip.startsWith("198.51.") || ip.startsWith("203.0.")) {
            return 92;
        }

        return Math.abs(ip.hashCode() % 100);
    }
}
