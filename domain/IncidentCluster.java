package sda_pro_java.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

// PATTERN: Composite
public class IncidentCluster implements AlertComponent {

    private final String id = UUID.randomUUID().toString();
    private final String clusterName;
    private final List<AlertComponent> children = new ArrayList<>();

    public IncidentCluster(String clusterName) {
        this.clusterName = clusterName;
    }

    @Override
    public String getId() {
        return id;
    }

    public String getClusterName() {
        return clusterName;
    }

    @Override
    public Severity getSeverity() {
        Severity highest = Severity.LOW;

        for (AlertComponent child : children) {
            if (child.getSeverity().ordinal() > highest.ordinal()) {
                highest = child.getSeverity();
            }
        }

        return highest;
    }

    @Override
    public String getMessage() {
        return "Incident Cluster: " + clusterName;
    }

    @Override
    public void add(AlertComponent component) {
        children.add(component);
    }

    @Override
    public List<AlertComponent> getChildren() {
        return children;
    }
}