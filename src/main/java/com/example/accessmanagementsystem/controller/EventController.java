package com.example.accessmanagementsystem.controller;

import com.example.accessmanagementsystem.service.contract.EventServiceContract;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.MediaType;
import reactor.core.publisher.Flux;

@RestController
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class EventController {

    private final EventServiceContract eventService;

    @GetMapping(path = "/api/events", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<String> streamEvents() {
        return eventService.getEventStream();
    }
}
