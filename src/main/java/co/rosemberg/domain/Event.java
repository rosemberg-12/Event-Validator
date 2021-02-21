package co.rosemberg.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

/**
 * Event represent the events model.
 */
@Data
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Builder
public class Event {
    private String id;
    private LocalDateTime start;
    private LocalDateTime end;
}
