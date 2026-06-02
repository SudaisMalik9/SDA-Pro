package sda_pro_java.incident;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "incidents")
public class Incident {

    @Id
    private String id;

    private String alertMessage;

    private String severity;

    private String status;

    @ElementCollection
    private List<String> history = new ArrayList<>();

    public Incident() {
    }

    public Incident(String alertMessage,
                    String severity,
                    String status) {

        this.id = UUID.randomUUID().toString();
        this.alertMessage = alertMessage;
        this.severity = severity;
        this.status = status;

        history.add(status);
    }

    public String getId() {
        return id;
    }

    public String getAlertMessage() {
        return alertMessage;
    }

    public String getSeverity() {
        return severity;
    }

    public String getStatus() {
        return status;
    }

    public List<String> getHistory() {
        return history;
    }

    public void moveNext(String nextStatus) {
        this.status = nextStatus;
        history.add(nextStatus);
    }
}