package com.flex66.iris.core.payload;

public class ErrorMessageResponsePayload extends ResponsePayload
{
    public ErrorMessageResponsePayload(String message)
    {
        setErrorMessage(message);
    }
}
