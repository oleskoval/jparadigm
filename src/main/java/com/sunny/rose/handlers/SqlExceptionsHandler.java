package com.sunny.rose.handlers;

import org.springframework.webflow.engine.FlowExecutionExceptionHandler;
import org.springframework.webflow.engine.RequestControlContext;
import org.springframework.webflow.engine.Transition;
import org.springframework.webflow.engine.support.DefaultTargetStateResolver;
import org.springframework.webflow.execution.FlowExecutionException;


public class SqlExceptionsHandler implements FlowExecutionExceptionHandler
{
    public boolean canHandle(FlowExecutionException exception)
    {
        return true;
//        return (exception.getCause() instanceof java.sql.BatchUpdateException
//        || exception.getCause() instanceof org.hibernate.exception.ConstraintViolationException
//        || exception.getCause() instanceof org.springframework.webflow.execution.ActionExecutionException);
    }

    public void handle(FlowExecutionException exception, RequestControlContext context)
    {
        System.out.println("!!!!!!!!!!!!!!  handle");
        context.execute(new Transition(new DefaultTargetStateResolver("failsCredentials")));

    }
}
