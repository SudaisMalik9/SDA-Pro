package sda_pro_java.incident;

import sda_pro_java.domain.IncidentStatus;

// PATTERN: State
public interface IncidentState {

    IncidentStatus getStatus();

    IncidentState next();
}