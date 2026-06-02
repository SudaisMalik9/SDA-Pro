package sda_pro_java.audit;

import java.time.LocalDateTime;

public class AuditEntry {

    private final LocalDateTime timestamp;
    private final String event;

    public AuditEntry(String event) {
        this.timestamp = LocalDateTime.now();
        this.event = event;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public String getEvent() {
        return event;
    }
}