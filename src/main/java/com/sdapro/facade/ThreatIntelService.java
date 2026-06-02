package com.sdapro.facade;

// PATTERN: Facade Subsystem / Target Interface for Adapter and Proxy
/**
 * Common interface for threat intelligence operations.
 * Serves as the target interface for both the Adapter (integrating external services)
 * and the Proxy (adding caching and access control), and forms part of the Facade's subsystems.
 */
public interface ThreatIntelService {
    /**
     * Scan an IP address to determine its threat intelligence report.
     *
     * @param ipAddress The IP address to scan.
     * @return A string summary of the threat classification and details.
     */
    String scanIp(String ipAddress);
}
