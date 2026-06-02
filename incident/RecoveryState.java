package sda_pro_java.incident;

import sda_pro_java.domain.IncidentStatus;

public class RecoveryState implements IncidentState {

    @Override
    public IncidentStatus getStatus() {
        return IncidentStatus.RECOVERY;
    }

    @Override
    public IncidentState next() {
        return new PostIncidentReviewState();
    }
}