package sda_pro_java.enrichment;

import sda_pro_java.domain.Severity;
import sda_pro_java.domain.SingleAlert;

public class EnrichmentContext {

    private SingleAlert alert;
    private boolean duplicate;
    private String geoLocation;
    private int threatScore;
    private Severity finalSeverity;

    public EnrichmentContext(SingleAlert alert) {
        this.alert = alert;
        this.finalSeverity = alert.getSeverity();
    }

    public SingleAlert getAlert() {
        return alert;
    }

    public boolean isDuplicate() {
        return duplicate;
    }

    public void setDuplicate(boolean duplicate) {
        this.duplicate = duplicate;
    }

    public String getGeoLocation() {
        return geoLocation;
    }

    public void setGeoLocation(String geoLocation) {
        this.geoLocation = geoLocation;
    }

    public int getThreatScore() {
        return threatScore;
    }

    public void setThreatScore(int threatScore) {
        this.threatScore = threatScore;
    }

    public Severity getFinalSeverity() {
        return finalSeverity;
    }

    public void setFinalSeverity(Severity finalSeverity) {
        this.finalSeverity = finalSeverity;
    }
}