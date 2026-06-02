package sda_pro_java.dto;

import java.util.List;

import sda_pro_java.domain.IncidentStatus;
import sda_pro_java.domain.Severity;

public class IncidentResponse {

    private String incidentId;
    private String alertId;
    private Severity severity;
    private IncidentStatus status;
    private String message;
    private List<String> actions;

    public IncidentResponse(String incidentId,
                            String alertId,
                            Severity severity,
                            IncidentStatus status,
                            String message,
                            List<String> actions) {

        this.incidentId = incidentId;
        this.alertId = alertId;
        this.severity = severity;
        this.status = status;
        this.message = message;
        this.actions = actions;
    }

    public String getIncidentId() {
        return incidentId;
    }

    public String getAlertId() {
        return alertId;
    }

    public Severity getSeverity() {
        return severity;
    }

    public IncidentStatus getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public List<String> getActions() {
        return actions;
    }
}