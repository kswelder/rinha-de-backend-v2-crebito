package crebito.kswelder.com.github.crebito.execoes;

import org.springframework.dao.DataIntegrityViolationException;

public class ArgumentAllReadyExistException  extends DataIntegrityViolationException {
    public ArgumentAllReadyExistException(String message) {
        super(message);
    }
}
