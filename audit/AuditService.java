package sda_pro_java.audit;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class AuditService {

    private final List<AuditEntry> logs = new ArrayList<>();

    public void log(String event) {

        AuditEntry entry = new AuditEntry(event);

        logs.add(entry);

        System.out.println(
                "[AUDIT] "
                        + entry.getTimestamp()
                        + " | "
                        + entry.getEvent()
        );
    }

    public List<AuditEntry> getLogs() {
        return logs;
    }
}