package co.rosemberg.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Represent the request info which contains a list of events to be processed.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EventRequest {
    private List<EventDTO> eventList;
}
