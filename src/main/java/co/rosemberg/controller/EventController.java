package co.rosemberg.controller;

import co.rosemberg.dto.EventRequest;
import co.rosemberg.dto.EventResponse;
import co.rosemberg.mapper.EventMapper;
import co.rosemberg.service.EventService;
import co.rosemberg.service.EventServiceImp;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Collectors;

@RestController
@RequestMapping("/event")
@AllArgsConstructor
public class EventController {

    private final EventService service;
    private final EventMapper mapper;

    @PostMapping(name = "GetOverlappedEvents", path = "/overlapped")
    public EventResponse getOverlappedEvents(@RequestBody EventRequest request){
        return new EventResponse(service.getOverlappedEvents(request.getEventList().stream()
                .map(mapper::convertToDomain).collect(Collectors.toList())).stream()
                .map(mapper::convertToDTO).collect(Collectors.toList()));
    }

}
