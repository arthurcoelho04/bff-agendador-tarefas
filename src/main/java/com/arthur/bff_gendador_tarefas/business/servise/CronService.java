package com.arthur.bff_gendador_tarefas.business.servise;

import com.arthur.bff_gendador_tarefas.business.dto.in.LoginDTORequest;
import com.arthur.bff_gendador_tarefas.business.dto.out.TarefasDTOResponse;
import com.arthur.bff_gendador_tarefas.business.enums.StatusNotificacaoEnum;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor

public class CronService {

    private final TarefasService tarefasService;
    private final EmailService emailService;
    private final UsuarioService usuarioService;

    @Value("${usuario.email}")
    private String email;

    @Value("${usuario.senha}")
    private String senha;

    @Scheduled(cron = "${cron.horario}")

    public void buscaTarefasProximaHora() {
        String token = login(converterParaRequestDTO());
        LocalDateTime horaAtual = LocalDateTime.now().plusHours(1);
        LocalDateTime horaFutura = LocalDateTime.now().plusHours(1).plusMinutes(5);

        List<TarefasDTOResponse> listaTarefas =
                tarefasService.buscarTarefasAgendadasPorPeriodo(horaAtual, horaFutura, token);

        listaTarefas.forEach(tarefas -> {
            emailService.enviarEmail(tarefas);
            tarefasService.alterarStatus(StatusNotificacaoEnum.NOTIFICADO, tarefas.getId(), token);
        });
    }


    public String login(LoginDTORequest dto) {
        return usuarioService.loginUsuario(dto);
    }

    public LoginDTORequest converterParaRequestDTO() {
        return LoginDTORequest.builder()
                .email(email)
                .senha(senha)
                .build();
    }
}
