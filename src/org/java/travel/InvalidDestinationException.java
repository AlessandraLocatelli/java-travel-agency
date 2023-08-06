package org.java.travel;

//estendiamo classi exception
//la classe farà tutto quello che fa una classe exception es. runtimeexception

public class InvalidDestinationException extends RuntimeException {

    public InvalidDestinationException(String message)
    {

        super(message);
    }

}
