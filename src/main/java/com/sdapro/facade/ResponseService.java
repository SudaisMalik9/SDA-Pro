package com.sdapro.facade;

import com.sdapro.strategy.ResponseStrategy;

// PATTERN: Facade Subsystem / Strategy Context
/**
 * Context class in the Strategy Pattern, also acting as a subsystem in the Facade.
 * It manages the active incident response strategy and delegates execution commands.
 */
public class ResponseService {
    private ResponseStrategy strategy;

    /**
     * Set or change the mitigation strategy at runtime.
     *
     * @param strategy The selected concrete ResponseStrategy.
     */
    public void setStrategy(ResponseStrategy strategy) {
        this.strategy = strategy;
    }

    /**
     * Executes the mitigation response using the currently selected strategy.
     *
     * @param incidentId Unique ID of the security incident.
     * @param ipAddress  The source IP address associated with the incident.
     */
    public void executeResponse(String incidentId, String ipAddress) {
        if (strategy == null) {
            System.out.println("[RESPONSE SERVICE] No response strategy selected! Aborting mitigation.");
            return;
        }
        System.out.println("[RESPONSE SERVICE] Triggering selected mitigation strategy...");
        strategy.execute(incidentId, ipAddress);
    }
}
