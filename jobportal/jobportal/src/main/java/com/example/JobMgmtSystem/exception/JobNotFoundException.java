package com.example.JobMgmtSystem.exception;

public class JobNotFoundException  extends RuntimeException

{
    public JobNotFoundException(String message)
    {
        super(message);
    }
}
