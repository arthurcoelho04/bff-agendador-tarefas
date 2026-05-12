package com.arthur.bff_gendador_tarefas.infrastructure.client;


import com.arthur.bff_gendador_tarefas.business.dto.in.TarefasDTORequest;
import com.arthur.bff_gendador_tarefas.business.dto.out.TarefasDTOResponse;
import com.arthur.bff_gendador_tarefas.business.enums.StatusNotificacaoEnum;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@FeignClient(name = "agendador-tarefas", url = "${agendador-tarefas.url}")
public interface TarefasClient {

    @PostMapping
    TarefasDTOResponse gravarTarefas(@RequestBody TarefasDTORequest dto,
                                     @RequestHeader("authorization") String token);


    @GetMapping("/eventos")
    List<TarefasDTOResponse> buscaListaDeTarefasPorPeriodo(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dataInicial,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dataFinal,
            @RequestHeader("authorization") String token);


    @GetMapping
    List<TarefasDTOResponse> buscarTarefasPorEmailUsuario(@RequestHeader("authorization") String token);


    @DeleteMapping
    void deletarTarefasPorId(@RequestParam("id") String id,
                             @RequestHeader("authorization") String token);


    @PatchMapping
    TarefasDTOResponse alteraStatusNotificacao(@RequestParam("status") StatusNotificacaoEnum status,
                                               @RequestParam("id") String id,
                                               @RequestHeader("authorization") String token);


    @PutMapping
    TarefasDTOResponse updateTarefas(@RequestBody TarefasDTORequest dto,
                                     @RequestParam("id") String id,
                                     @RequestHeader("authorization")String token);

}

