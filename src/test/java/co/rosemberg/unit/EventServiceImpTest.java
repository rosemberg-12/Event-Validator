package co.rosemberg.unit;

import co.rosemberg.domain.Event;
import co.rosemberg.service.EventServiceImp;
import co.rosemberg.validator.EventValidator;
import org.assertj.core.util.Lists;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class EventServiceImpTest {

    private EventServiceImp service;

    @Before
    public void init(){
        this.service=new EventServiceImp(new EventValidator());
    }

    @Test
    public void getEmptyOverlappedEvents_Test(){
        Event evt1= Event.builder().id("1").start(LocalDateTime.of(2020,12,1,1,0))
                .end(LocalDateTime.of(2020,12,1,2,0)).build();
        Event evt2= Event.builder().id("2").start(LocalDateTime.of(2020,12,1,2,0))
                .end(LocalDateTime.of(2020,12,1,3,0)).build();
        Event evt3= Event.builder().id("3").start(LocalDateTime.of(2020,12,1,3,0))
                .end(LocalDateTime.of(2020,12,1,4,0)).build();
        List<Event> events= Lists.newArrayList(evt1,evt2,evt3);
        List<Event> overlapped= this.service.getOverlappedEvents(events);
        assertThat(overlapped).isEmpty();
    }

    @Test
    public void getOverlappedEvents_Test(){
        Event evt1= Event.builder().id("1").start(LocalDateTime.of(2020,12,1,1,0))
                .end(LocalDateTime.of(2020,12,1,2,0)).build();
        Event evt2= Event.builder().id("2").start(LocalDateTime.of(2020,12,1,2,0))
                .end(LocalDateTime.of(2020,12,1,5,0)).build();
        Event evt3= Event.builder().id("3").start(LocalDateTime.of(2020,12,1,3,0))
                .end(LocalDateTime.of(2020,12,1,6,0)).build();
        List<Event> events= Lists.newArrayList(evt1,evt2,evt3);
        List<Event> overlapped= this.service.getOverlappedEvents(events);
        assertThat(overlapped.stream().map(Event::getId).collect(Collectors.toList())).contains("2","3");
        assertThat(overlapped).hasSize(2);
    }

    @Test
    public void getAllOverlappedEvents_Test(){
        Event evt1= Event.builder().id("1").start(LocalDateTime.of(2020,12,1,1,0))
                .end(LocalDateTime.of(2020,12,1,3,0)).build();
        Event evt2= Event.builder().id("2").start(LocalDateTime.of(2020,12,1,2,0))
                .end(LocalDateTime.of(2020,12,1,5,0)).build();
        Event evt3= Event.builder().id("3").start(LocalDateTime.of(2020,12,1,3,0))
                .end(LocalDateTime.of(2020,12,1,6,0)).build();
        List<Event> events= Lists.newArrayList(evt1,evt2,evt3);
        List<Event> overlapped= this.service.getOverlappedEvents(events);
        assertThat(overlapped.stream().map(Event::getId).collect(Collectors.toList())).contains("1","2","3");
        assertThat(overlapped).hasSize(3);
    }
}
