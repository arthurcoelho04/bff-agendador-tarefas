package com.arthur.bff_gendador_tarefas.business.servise;

import com.arthur.bff_gendador_tarefas.business.dto.out.TarefasDTOResponse;
import com.arthur.bff_gendador_tarefas.infrastructure.client.EmailClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailService {

    private final EmailClient emailClient;


    public void enviarEmail(TarefasDTOResponse dto) {
        emailClient.enviarEmail(dto);
    }
}
