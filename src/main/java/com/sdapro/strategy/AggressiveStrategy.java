package com.sdapro.strategy;

// PATTERN: Strategy (Concrete Strategy)
/**
 * An aggressive response strategy that isolates threat sources immediately.
 * Used for high-severity or confirmed malicious incidents.
 */
public class AggressiveStrategy implements ResponseStrategy {
    
    @Override
    public void execute(String incidentId, String ipAddress) {
        System.out.println("\n[STRATEGY: Aggressive] Action executed for incident " + incidentId);
        System.out.println("  -> Action: Blocking IP address " + ipAddress + " immediately at the edge firewall.");
        System.out.println("  -> Action: Terminating all active network sessions originating from " + ipAddress + ".");
        System.out.println("  -> Action: Flagging IP " + ipAddress + " as CRITICAL threat source in global blocklist.");
    }
}
