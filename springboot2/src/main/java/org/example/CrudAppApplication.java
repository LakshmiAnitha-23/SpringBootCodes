package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.print.DocFlavor;

@SpringBootApplication
public class CrudAppApplication
{
    public static void main(String[] args)
    {
        SpringApplication.run(CrudAppApplication.class,args);
    }
}