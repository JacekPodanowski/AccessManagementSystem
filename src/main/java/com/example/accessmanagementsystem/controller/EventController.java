package com.example.accessmanagementsystem.controller;

import com.example.accessmanagementsystem.service.contract.EventServiceContract;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.MediaType;
import reactor.core.publisher.Flux;

@RestController
public class EventController {

    private final EventServiceContract eventService;

    public EventController(EventServiceContract eventService) {
        this.eventService = eventService;
    }

    @GetMapping(path = "/api/events", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<String> streamEvents() {
        return eventService.getEventStream();
    }
}
