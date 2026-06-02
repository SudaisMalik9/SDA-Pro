package com.sdapro.proxy;

import com.sdapro.facade.ThreatIntelService;
import java.util.HashMap;
import java.util.Map;

// PATTERN: Proxy (Caching & Logging Proxy)
/**
 * A proxy wrapper around ThreatIntelService implementations.
 * Adds performance optimization (local caching of results) and security/audit logging
 * without modifying the core threat intel service logic.
 */
public class ThreatIntelProxy implements ThreatIntelService {
    private final ThreatIntelService realService;
    private final Map<String, String> cache;

    /**
     * Constructor initializing the proxy with a target real service implementation.
     *
     * @param realService The actual service implementation to delegate to on cache miss.
     */
    public ThreatIntelProxy(ThreatIntelService realService) {
        this.realService = realService;
        this.cache = new HashMap<>();
    }

    @Override
    public String scanIp(String ipAddress) {
        System.out.println("\n[PROXY] Intercepting request to scan IP: " + ipAddress);
        
        // Logging / Audit trail action
        System.out.println("[PROXY LOG] Audit Log: Scan initiated for IP: " + ipAddress + " at local time.");

        // Caching optimization: check if already scanned
        if (cache.containsKey(ipAddress)) {
            System.out.println("[PROXY] ---> Cache HIT! Returning cached result for " + ipAddress);
            return cache.get(ipAddress);
        }

        // Cache miss: delegate to the real service (or adapter)
        System.out.println("[PROXY] ---> Cache MISS! Forwarding request to the real Threat Intel Service...");
        String result = realService.scanIp(ipAddress);
        
        // Cache the result for subsequent requests
        cache.put(ipAddress, result);
        System.out.println("[PROXY] ---> Cached result stored for " + ipAddress);
        
        return result;
    }

    /**
     * Helper method to inspect cache size or clear cache during testing.
     */
    public void clearCache() {
        this.cache.clear();
        System.out.println("[PROXY] Cache cleared.");
    }
}
