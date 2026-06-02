package sda_pro_java.controller;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import sda_pro_java.dto.IncidentResponse;
import sda_pro_java.dto.RawAlertRequest;
import sda_pro_java.service.SdaProService;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class SdaProController {

    private final SdaProService service;

    private final List<SseEmitter> emitters =
            new CopyOnWriteArrayList<>();

    public SdaProController(SdaProService service) {
        this.service = service;
    }

    @GetMapping("/health")
    public String health() {
        return "SDA-Pro Java is running";
    }

    @PostMapping("/alerts/ingest")
    public IncidentResponse ingest(@RequestBody RawAlertRequest request) {
        IncidentResponse response = service.ingestAlert(request);
        sendRealtimeUpdate("New incident created");
        return response;
    }

    @GetMapping("/incidents")
    public List<IncidentResponse> getIncidents() {
        return service.getIncidents();
    }

    @PostMapping("/incidents/{id}/next-state")
    public IncidentResponse nextState(@PathVariable String id) {
        IncidentResponse response = service.moveIncidentNextState(id);
        sendRealtimeUpdate("Incident state changed");
        return response;
    }

    @GetMapping(
            value = "/stream",
            produces = MediaType.TEXT_EVENT_STREAM_VALUE
    )
    public SseEmitter stream() {
        SseEmitter emitter = new SseEmitter(Long.MAX_VALUE);

        emitters.add(emitter);

        emitter.onCompletion(() -> emitters.remove(emitter));
        emitter.onTimeout(() -> emitters.remove(emitter));
        emitter.onError((e) -> emitters.remove(emitter));

        try {
            emitter.send(
                    SseEmitter.event()
                            .name("connected")
                            .data("SSE connected")
            );
        } catch (IOException e) {
            emitters.remove(emitter);
        }

        return emitter;
    }

    private void sendRealtimeUpdate(String message) {
        for (SseEmitter emitter : emitters) {
            try {
                emitter.send(
                        SseEmitter.event()
                                .name("incident-update")
                                .data(message)
                );
            } catch (IOException e) {
                emitters.remove(emitter);
            }
        }
    }
}