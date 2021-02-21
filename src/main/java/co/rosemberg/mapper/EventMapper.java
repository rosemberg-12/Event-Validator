package co.rosemberg.mapper;

import co.rosemberg.domain.Event;
import co.rosemberg.dto.EventDTO;
import org.springframework.stereotype.Component;

@Component
public class EventMapper {
    public Event convertToDomain(EventDTO evt){
        return new Event(evt.getId(),evt.getStart(),evt.getEnd());
    }

    public EventDTO convertToDTO(Event evt){
        return new EventDTO(evt.getId(),evt.getStart(),evt.getEnd());
    }
}
