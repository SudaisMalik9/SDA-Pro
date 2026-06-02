package sda_pro_java.incident;

import sda_pro_java.domain.IncidentStatus;

public class PostIncidentReviewState implements IncidentState {

    @Override
    public IncidentStatus getStatus() {
        return IncidentStatus.POST_INCIDENT_REVIEW;
    }

    @Override
    public IncidentState next() {
        return new ClosedState();
    }
}