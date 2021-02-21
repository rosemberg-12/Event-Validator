package co.rosemberg.validator;

import co.rosemberg.domain.Event;
import lombok.AllArgsConstructor;

import java.util.List;

/**
 * Validate if all the events are valid ( start must be before than end ).
 */
@AllArgsConstructor
public class EventDatesValidation implements EventValidation {

    private final List<Event> eventList;

    @Override
    public boolean valid() {
        return eventList.stream().allMatch(event -> event.getStart().isBefore(event.getEnd()));
    }

    @Override
    public String message() {
        return "One or more event hasn't correct date";
    }
}
