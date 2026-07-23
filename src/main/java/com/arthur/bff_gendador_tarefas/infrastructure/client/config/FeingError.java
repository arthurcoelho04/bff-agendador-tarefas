package com.arthur.bff_gendador_tarefas.infrastructure.client.config;

import com.arthur.bff_gendador_tarefas.infrastructure.exceptions.BusinessException;
import com.arthur.bff_gendador_tarefas.infrastructure.exceptions.ConflictException;
import com.arthur.bff_gendador_tarefas.infrastructure.exceptions.ResourceNotFoundException;
import com.arthur.bff_gendador_tarefas.infrastructure.exceptions.UnauthorizedException;
import feign.Response;
import feign.codec.ErrorDecoder;

public class FeingError implements ErrorDecoder {


    @Override
    public Exception decode(String methodKey, Response response) {

        switch (response.status()) {
            case 409:
                return new ConflictException("Erro Atributo ja existente");
            case 403:
                return new ResourceNotFoundException("Erro atributo nao encontrado");
            case 401:
                return new UnauthorizedException("Erro usuario nao autorizado");
            default:
                return new BusinessException("Erro no feign");
        }
    }
}
