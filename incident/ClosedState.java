package sda_pro_java.incident;

import sda_pro_java.domain.IncidentStatus;

public class ClosedState implements IncidentState {

    @Override
    public IncidentStatus getStatus() {
        return IncidentStatus.CLOSED;
    }

    @Override
    public IncidentState next() {
        return this;
    }
}