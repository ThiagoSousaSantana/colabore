package br.com.colabore.services.exceptions;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@ControllerAdvice
public class ServiceExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<StandardError> validation(MethodArgumentNotValidException exception) {

        var erro = new ValidationError(
                HttpStatus.BAD_REQUEST.value(), "Erro de validação", System.currentTimeMillis());

        exception.getBindingResult().getFieldErrors().forEach(fieldError ->
                erro.addError(fieldError.getField(), fieldError.getDefaultMessage()));

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erro);
    }

    @ExceptionHandler(PerfilInvalidoException.class)
    public ResponseEntity<StandardError> perfilInvalidoException(PerfilInvalidoException exception) {
        var erro = new StandardError(HttpStatus.FORBIDDEN.value(), exception.getMessage(), System.currentTimeMillis());
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(erro);
    }
}
