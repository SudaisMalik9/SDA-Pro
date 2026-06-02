package com.sdapro.strategy;

// PATTERN: Strategy (Strategy Interface)
/**
 * Interface defining the incident response mitigation contract.
 * Allows the incident response behavior to be swapped dynamically at runtime.
 */
public interface ResponseStrategy {
    /**
     * Executes the mitigation action for the given incident and IP address.
     *
     * @param incidentId Unique ID of the security incident.
     * @param ipAddress  The source IP address associated with the incident.
     */
    void execute(String incidentId, String ipAddress);
}
