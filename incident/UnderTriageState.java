package sda_pro_java.incident;

import sda_pro_java.domain.IncidentStatus;

public class UnderTriageState implements IncidentState {

    @Override
    public IncidentStatus getStatus() {
        return IncidentStatus.UNDER_TRIAGE;
    }

    @Override
    public IncidentState next() {
        return new ContainmentState();
    }
}