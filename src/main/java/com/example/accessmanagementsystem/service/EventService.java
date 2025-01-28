package com.example.accessmanagementsystem.service;

import com.example.accessmanagementsystem.service.contract.EventServiceContract;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;

@Service
public class EventService implements EventServiceContract {

    private final Sinks.Many<String> sink = Sinks.many().multicast().onBackpressureBuffer();

    @Override
    public Flux<String> getEventStream() {
        return sink.asFlux();
    }

    @Override
    public void emitEvent(String eventMessage) {
        sink.tryEmitNext(eventMessage);
    }
}
