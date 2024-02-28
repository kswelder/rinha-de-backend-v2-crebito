package crebito.kswelder.com.github.crebito.execoes;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.NoSuchElementException;

@RestControllerAdvice
public class ApplicationHandleException {
    @ExceptionHandler(value = HttpMessageNotReadableException.class)
    public ResponseEntity<Void> exceptionNoReadableBody(HttpMessageNotReadableException error) {
        //MensagemDeExcecao message = new MensagemDeExcecao(HttpStatus.BAD_REQUEST, "Insira um valor valido", LocalDateTime.now());
        return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(value = NoSuchElementException.class)
    public ResponseEntity<Void> exceptionNoValueElementSearcheble(NoSuchElementException error) {
        //MensagemDeExcecao message = new MensagemDeExcecao(HttpStatus.NOT_FOUND, error.getMessage(), LocalDateTime.now());
        return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(value = DataIntegrityViolationException.class)
    public ResponseEntity<Void> exceptionArgumentAllReadyExist(DataIntegrityViolationException error) {
        //MensagemDeExcecao message = new MensagemDeExcecao(HttpStatus.BAD_REQUEST, "Argumento invalido", LocalDateTime.now());
        return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(value = ExceptionHandlerException.class)
    public ResponseEntity<Void> exceptionHandler(ExceptionHandlerException error) {
        return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
    }
}
