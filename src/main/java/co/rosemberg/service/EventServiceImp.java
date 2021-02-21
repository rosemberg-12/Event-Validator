package co.rosemberg.service;

import co.rosemberg.domain.Event;
import co.rosemberg.validator.EventDatesValidation;
import co.rosemberg.validator.EventValidator;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.*;


/**
 * Provides all functionalities related with Event Entity.
 */
@Service
@AllArgsConstructor
public class EventServiceImp implements EventService{
    private final EventValidator validator;

    /**
     * Return a list with overlapped events given an initial event list.
     * @param eventList event list to be analyzed.
     * @return overlapped events.
     */
    public List<Event> getOverlappedEvents(List<Event>eventList){
        final Set<Event> overlappedEvents= Sets.newHashSet();
        validator.evaluateSingleValidation(new EventDatesValidation(eventList));
        if(eventList.size()<2){
            return Lists.newArrayList();
        }
        eventList.sort(Comparator.comparing(Event::getStart));
        Iterator<Event> eventIterator=eventList.iterator();
        Event aux=eventIterator.next();
        do{
            Event current= aux;
            Event next=eventIterator.next();

            if(current.getEnd().isAfter(next.getStart())){
                overlappedEvents.add(current);
                overlappedEvents.add(next);
            }
            aux=next;

        }while(eventIterator.hasNext());

        return new ArrayList<>(overlappedEvents);
    }

}