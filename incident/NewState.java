package sda_pro_java.incident;

import sda_pro_java.domain.IncidentStatus;

public class NewState implements IncidentState {

    @Override
    public IncidentStatus getStatus() {
        return IncidentStatus.NEW;
    }

    @Override
    public IncidentState next() {
        return new UnderTriageState();
    }
}