package co.rosemberg.validator;

import co.rosemberg.exception.EventException;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EventValidator {

    public void evaluateSingleValidation(EventValidation validation){
        if(!validation.valid()){
            throw new EventException(validation.message());
        }
    }

    public void evaluateMultipleValidations(List<EventValidation> validations){
        for(EventValidation validation:validations){
            evaluateSingleValidation(validation);
        }
    }
}
