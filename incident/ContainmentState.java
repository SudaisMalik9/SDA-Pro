package sda_pro_java.incident;

import sda_pro_java.domain.IncidentStatus;

public class ContainmentState implements IncidentState {

    @Override
    public IncidentStatus getStatus() {
        return IncidentStatus.CONTAINMENT;
    }

    @Override
    public IncidentState next() {
        return new EradicationState();
    }
}