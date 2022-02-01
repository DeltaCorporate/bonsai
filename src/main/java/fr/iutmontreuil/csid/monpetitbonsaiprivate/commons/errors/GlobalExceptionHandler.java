package fr.iutmontreuil.csid.monpetitbonsaiprivate.commons.errors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.persistence.EntityNotFoundException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = EntityNotFoundException.class)
    public ResponseEntity<ErrorDTO> catchEntityNotFoundException(EntityNotFoundException entityNotFoundException) {
        ErrorDTO error = new ErrorDTO("ENTITY_NOT_FOUND", entityNotFoundException.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

}
