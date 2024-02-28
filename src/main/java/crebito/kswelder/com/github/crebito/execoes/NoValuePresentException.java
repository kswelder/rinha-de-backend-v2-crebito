package crebito.kswelder.com.github.crebito.execoes;

import java.util.NoSuchElementException;

public class NoValuePresentException  extends NoSuchElementException {
    public NoValuePresentException(String message) {
        super(message);
    }
}
