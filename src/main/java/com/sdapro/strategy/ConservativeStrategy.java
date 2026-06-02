package com.sdapro.strategy;

// PATTERN: Strategy (Concrete Strategy)
/**
 * A conservative response strategy that monitors and audits threat sources.
 * Used for low-to-medium severity or suspicious (unconfirmed) activities.
 */
public class ConservativeStrategy implements ResponseStrategy {

    @Override
    public void execute(String incidentId, String ipAddress) {
        System.out.println("\n[STRATEGY: Conservative] Action executed for incident " + incidentId);
        System.out.println("  -> Action: Flagging IP address " + ipAddress + " for manual security analyst audit.");
        System.out.println("  -> Action: Increasing logging level and telemetry capture on traffic from " + ipAddress + ".");
        System.out.println("  -> Action: Creating warning log entry in the security monitoring dashboard.");
    }
}
