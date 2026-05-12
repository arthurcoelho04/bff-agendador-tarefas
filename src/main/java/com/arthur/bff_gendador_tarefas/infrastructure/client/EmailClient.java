package com.arthur.bff_gendador_tarefas.infrastructure.client;


import com.arthur.bff_gendador_tarefas.business.dto.out.TarefasDTOResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "notificao", url = "${notificacao}")
public interface EmailClient {
    Void enviarEmail(@RequestBody TarefasDTOResponse dto);

    }


