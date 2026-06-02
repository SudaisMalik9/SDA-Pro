package sda_pro_java.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

// PATTERN: Composite (Composite)
public class AlertCampaign implements AlertComponent {

    private final String id = UUID.randomUUID().toString();

    private String campaignName;

    private List<AlertComponent> children =
            new ArrayList<>();

    public AlertCampaign(String campaignName) {
        this.campaignName = campaignName;
    }

    @Override
    public String getId() {
        return id;
    }

    public String getCampaignName() {
        return campaignName;
    }

    @Override
    public Severity getSeverity() {

        Severity highest = Severity.LOW;

        for (AlertComponent child : children) {

            if (child.getSeverity().ordinal()
                    > highest.ordinal()) {

                highest = child.getSeverity();
            }
        }

        return highest;
    }

    @Override
    public String getMessage() {
        return "Campaign: " + campaignName;
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