package com.sunny.rose.exceptions;

/**
 * @author: Oles Slezka
 * 28.01.12  23:33
 */

public class RepositoryDataException extends ApplicationException
{
    public RepositoryDataException(String issueDescription,Class entity)
    {
        super(issueDescription + ". Entity name " + entity);
    }
   public RepositoryDataException(String issueDescription,Class entity,Exception e)
    {
        super(issueDescription + ". Entity name " + entity, e);
    }
}
