package sda_pro_java.controller;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.*;

import sda_pro_java.domain.IncidentNote;
import sda_pro_java.service.SdaProService;

@RestController
@RequestMapping("/api/analyst")
@CrossOrigin("*")
public class AnalystController {

    private final SdaProService service;

    public AnalystController(SdaProService service) {
        this.service = service;
    }

    @PostMapping("/incidents/{id}/notes")
    public IncidentNote addNote(
            @PathVariable String id,
            @RequestBody Map<String, String> body) {

        return service.addNote(
                id,
                body.get("analystName"),
                body.get("note")
        );
    }

    @GetMapping("/incidents/{id}/notes")
    public List<IncidentNote> getNotes(@PathVariable String id) {
        return service.getNotes(id);
    }

    @PostMapping("/incidents/{id}/manual-action")
    public String manualAction(
            @PathVariable String id,
            @RequestBody Map<String, String> body) {

        return service.executeManualAction(
                id,
                body.get("action")
        );
    }
}