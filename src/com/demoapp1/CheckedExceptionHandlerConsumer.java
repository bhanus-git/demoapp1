package com.demoapp1;

public interface CheckedExceptionHandlerConsumer <Target, ExObj extends Exception> {

    public void accept(Target t) throws ExObj;
}
