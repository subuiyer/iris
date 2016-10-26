package com.flex66.iris.core.payload;


public class ResponsePayload 
{
    
    private String errorMessage;
    
    public ResponsePayload()
    {
        
    }
    
    public void setErrorMessage(String errorMessage)
    {
        this.errorMessage = errorMessage;
    }
    
    public String getErrorMessage()
    {
        return errorMessage;
    }
}
