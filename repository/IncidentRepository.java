package sda_pro_java.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sda_pro_java.incident.Incident;

public interface IncidentRepository
        extends JpaRepository<Incident, String> {
}