package com.arthur.bff_gendador_tarefas.business.servise;

import com.arthur.bff_gendador_tarefas.business.dto.in.TarefasDTORequest;
import com.arthur.bff_gendador_tarefas.business.dto.out.TarefasDTOResponse;
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


    public TarefasDTOResponse gravarTarefas(String token, TarefasDTORequest dto) {
        return tarefasClient.gravarTarefas(dto, token);
    }

    public List<TarefasDTOResponse> buscarTarefasAgendadasPorPeriodo(LocalDateTime dataInicial,
                                                                     LocalDateTime dataFinal,
                                                                     String token) {
        return tarefasClient.buscaListaDeTarefasPorPeriodo(dataInicial, dataFinal, token);
    }

    public List<TarefasDTOResponse> buscarTarefasPorEmailUsuario(String token) {
        return tarefasClient.buscarTarefasPorEmailUsuario(token);
    }

    public void deletaTarefaPorId(String idTarefa, String token) {
        tarefasClient.deletarTarefasPorId(idTarefa, token);
    }

    public TarefasDTOResponse alterarStatus(StatusNotificacaoEnum status, String id, String token) {
        return tarefasClient.alteraStatusNotificacao(status, id, token);
    }

    public TarefasDTOResponse updateTarefas(TarefasDTORequest dto, String id, String token) {
        return tarefasClient.updateTarefas(dto, id,  token);
    }
}
