package sda_pro_java.domain;

import java.time.LocalDateTime;
import java.util.UUID;

public class IncidentNote {

    private final String id;
    private final String incidentId;
    private final String analystName;
    private final String note;
    private final LocalDateTime createdAt;

    public IncidentNote(
            String incidentId,
            String analystName,
            String note) {

        this.id = UUID.randomUUID().toString();
        this.incidentId = incidentId;
        this.analystName = analystName;
        this.note = note;
        this.createdAt = LocalDateTime.now();
    }

    public String getId() {
        return id;
    }

    public String getIncidentId() {
        return incidentId;
    }

    public String getAnalystName() {
        return analystName;
    }

    public String getNote() {
        return note;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}