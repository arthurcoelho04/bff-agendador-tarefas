package com.arthur.bff_gendador_tarefas.business.servise;

import com.arthur.bff_gendador_tarefas.business.dto.in.LoginDTORequest;
import com.arthur.bff_gendador_tarefas.business.dto.out.TarefasDTOResponse;
import com.arthur.bff_gendador_tarefas.business.enums.StatusNotificacaoEnum;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
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
        log.info("iniciada a busca de tarefas");
        LocalDateTime horaFutura = LocalDateTime.now().plusHours(1);
        LocalDateTime horaFuturaCinco = LocalDateTime.now().plusHours(1).plusMinutes(5);

        List<TarefasDTOResponse> listaTarefas =
                tarefasService.buscarTarefasAgendadasPorPeriodo(horaFutura, horaFuturaCinco, token);
        log.info("listaTarefas: " + listaTarefas);
        listaTarefas.forEach(tarefas -> {
            emailService.enviarEmail(tarefas);
            log.info("email enviado: " + tarefas.getEmailUsuario());
            tarefasService.alterarStatus(StatusNotificacaoEnum.NOTIFICADO, tarefas.getId(), token);
        });
        log.info("finalizada a busca de tarefas");
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
