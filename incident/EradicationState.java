package sda_pro_java.incident;

import sda_pro_java.domain.IncidentStatus;

public class EradicationState implements IncidentState {

    @Override
    public IncidentStatus getStatus() {
        return IncidentStatus.ERADICATION;
    }

    @Override
    public IncidentState next() {
        return new RecoveryState();
    }
}