package com.arthur.bff_gendador_tarefas.infrastructure.exceptions;

public class ResourceNotFoundException extends RuntimeException{

    public ResourceNotFoundException(String mensage){
        super(mensage);
    }

    public ResourceNotFoundException(String mensage,Throwable throwable){
        super(mensage,throwable);

    }
}
