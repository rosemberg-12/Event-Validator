package co.rosemberg.service;

import co.rosemberg.domain.Event;

import java.util.List;

public interface EventService {

    List<Event> getOverlappedEvents(List<Event>eventList);

}
