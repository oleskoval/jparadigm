package com.sunny.rose.exceptions;

/**
 *
 * @author: Oles Slezka  28.01.12  23:23
 * */

public class ApplicationException  extends Exception
{
    static final long serialVersionUID = -3387516993124229777L;

    /**
     * Constructs a new exception with null as its detail message.
     */
    public ApplicationException()
    {
        super();
    }

    /**
     * Constructs a new exception with the specified detail message
     * */
    public ApplicationException(String message)
    {
        super(message);
    }

    /**
     * Constructs a new exception with the specified detail message and
     * cause.
     */
    public ApplicationException(String message, Throwable cause)
    {
        super(message, cause);
    }

}
