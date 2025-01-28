package com.example.accessmanagementsystem.service.contract;

import reactor.core.publisher.Flux;

public interface EventServiceContract {

    Flux<String> getEventStream();

    void emitEvent(String eventMessage);
}
