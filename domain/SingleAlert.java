package sda_pro_java.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

// PATTERN: Composite (Leaf)
public class SingleAlert implements AlertComponent {

    private final String id = UUID.randomUUID().toString();

    private String source;
    private Severity severity;
    private String ip;
    private String message;

    public SingleAlert(String source,
                       Severity severity,
                       String ip,
                       String message) {

        this.source = source;
        this.severity = severity;
        this.ip = ip;
        this.message = message;
    }

    public String getSource() {
        return source;
    }

    public String getIp() {
        return ip;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public Severity getSeverity() {
        return severity;
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public void add(AlertComponent component) {
        throw new UnsupportedOperationException(
                "Leaf cannot contain children");
    }

    @Override
    public List<AlertComponent> getChildren() {
        return new ArrayList<>();
    }
}