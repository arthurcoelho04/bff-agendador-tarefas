package com.arthur.bff_gendador_tarefas.business.servise;

import com.arthur.bff_gendador_tarefas.business.dto.TarefasDTO;
import com.arthur.bff_gendador_tarefas.business.enums.StatusNotificacaoEnum;
import com.arthur.bff_gendador_tarefas.infrastructure.client.TarefasClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TarefasService {

    private final TarefasClient tarefasClient;


    public TarefasDTO gravarTarefas(String token, TarefasDTO dto) {
        return tarefasClient.gravarTarefas(dto, token);
    }

    public List<TarefasDTO> buscarTarefasAgendadasPorPeriodo(LocalDateTime dataInicial,
                                                             LocalDateTime dataFinal,
                                                             String token) {
        return tarefasClient.buscaListaDeTarefasPorPeriodo(dataInicial, dataFinal, token);
    }

    public List<TarefasDTO> buscarTarefasPorEmailUsuario(String token) {
        return tarefasClient.buscarTarefasPorEmailUsuario(token);
    }

    public void deletaTarefaPorId(String idTarefa, String token) {
        tarefasClient.deletarTarefasPorId(idTarefa, token);
    }

    public TarefasDTO alterarStatus(StatusNotificacaoEnum status, String id, String token) {
        return tarefasClient.alteraStatusNotificacao(status, id, token);
    }

    public TarefasDTO updateTarefas(TarefasDTO dto, String id, String token) {
        return tarefasClient.updateTarefas(dto, id,  token);
    }
}
