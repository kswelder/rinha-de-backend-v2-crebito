package crebito.kswelder.com.github.crebito.execoes;

import org.springframework.http.converter.HttpMessageNotReadableException;

public class NoReadableMessageException  extends HttpMessageNotReadableException {
    public NoReadableMessageException(String message) {
        super(message);
    }
}
