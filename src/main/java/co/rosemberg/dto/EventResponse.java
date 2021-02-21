package co.rosemberg.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

/**
 * Represent the response info that will be returned via REST API, with a list of events.
 */
@Data
@AllArgsConstructor
public class EventResponse {
    private List<EventDTO> eventList;
}
