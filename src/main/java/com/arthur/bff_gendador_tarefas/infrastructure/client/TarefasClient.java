package com.arthur.bff_gendador_tarefas.infrastructure.client;


import com.arthur.bff_gendador_tarefas.business.dto.TarefasDTO;
import com.arthur.bff_gendador_tarefas.business.enums.StatusNotificacaoEnum;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@FeignClient(name = "agendador-tarefas", url = "${agendador-tarefas.url}")
public interface TarefasClient {

    @PostMapping
    TarefasDTO gravarTarefas(@RequestBody TarefasDTO dto,
                             @RequestHeader("authorization") String token);


    @GetMapping("/eventos")
    List<TarefasDTO> buscaListaDeTarefasPorPeriodo(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dataInicial,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dataFinal,
            @RequestHeader("authorization") String token);


    @GetMapping
    List<TarefasDTO> buscarTarefasPorEmailUsuario(@RequestHeader("authorization") String token);


    @DeleteMapping
    void deletarTarefasPorId(@RequestParam("id") String id,
                             @RequestHeader("authorization") String token);


    @PatchMapping
    TarefasDTO alteraStatusNotificacao(@RequestParam("status") StatusNotificacaoEnum status,
                                       @RequestParam("id") String id,
                                       @RequestHeader("authorization") String token);


    @PutMapping
    TarefasDTO updateTarefas(@RequestBody TarefasDTO dto,
                             @RequestParam("id") String id,
                             @RequestHeader("authorization")String token);

}

