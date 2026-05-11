package com.arthur.bff_gendador_tarefas.controller;


import com.arthur.bff_gendador_tarefas.business.dto.TarefasDTO;
import com.arthur.bff_gendador_tarefas.business.enums.StatusNotificacaoEnum;
import com.arthur.bff_gendador_tarefas.business.servise.TarefasService;
import com.arthur.bff_gendador_tarefas.infrastructure.security.SecurityConfig;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/tarefas")
@RequiredArgsConstructor
@Tag(name = "tarefas", description = "cadastra tarefas de usuarios")
@SecurityRequirement(name = SecurityConfig.SECURITY_SCHEME)
public class TarefasController {

    private final TarefasService tarefasService;

    @PostMapping
    @Operation(summary = "Salvar Tarefas", description = "cria uma nova tarefa")
    @ApiResponse(responseCode = "200", description = "Tarefas salva com sucesso")
    @ApiResponse(responseCode = "500", description = "Erro de servidor")
    public ResponseEntity<TarefasDTO> gravarTarefas(@RequestBody TarefasDTO dto,
                                                    @RequestHeader(value = "authorization",
                                                            required = false) String token) {
        return ResponseEntity.ok(tarefasService.gravarTarefas(token, dto));
    }

    @GetMapping("/eventos")
    @Operation(summary = "Busca Tarefas por periodo", description = "busca tarefa cadastrada por periodo")
    @ApiResponse(responseCode = "200", description = "Tarefas sencontradas")
    @ApiResponse(responseCode = "500", description = "Erro de servidor")
    public ResponseEntity<List<TarefasDTO>> buscaListaDeTarefasPorPeriodo(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dataInicial,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dataFinal,
            @RequestHeader(name = "authorization", required = false) String token) {

        return ResponseEntity.ok(tarefasService.buscarTarefasAgendadasPorPeriodo(dataInicial, dataFinal, token));
    }

    @GetMapping
    @Operation(summary = "Busca lista de tarefas por email de usuario",
            description = "Busca tarefas cadastradas por usuarios")
    @ApiResponse(responseCode = "200", description = "Tarefas encontradas")
    @ApiResponse(responseCode = "500", description = "Erro de servidor")
    public ResponseEntity<List<TarefasDTO>> buscarTarefasPorEmailUsuario(@RequestHeader(name = "authorization",
                                                                            required = false) String token) {
        List<TarefasDTO> tarefas = tarefasService.buscarTarefasPorEmailUsuario(token);
        return ResponseEntity.ok(tarefas);
    }

    @DeleteMapping
    @Operation(summary = "Deleta tarefas por ID", description = "deleta tarefas cadastradas por ID")
    @ApiResponse(responseCode = "200", description = "Tarefas deletadascom sucesso")
    @ApiResponse(responseCode = "500", description = "Erro de servidor")
    public ResponseEntity<Void> deletarTarefasPorId(@RequestParam("id") String id,
                                                    @RequestHeader(name = "authorization", required = false) String token) {
        tarefasService.deletaTarefaPorId(id, token);
        return ResponseEntity.ok().build();
    }

    @PatchMapping
    @Operation(summary = "altera status da Tarefas", description = "altera status das tarefas cadastradas")
    @ApiResponse(responseCode = "200", description = "Status da tarefa alterado com sucesso")
    @ApiResponse(responseCode = "500", description = "Erro de servidor")
    public ResponseEntity<TarefasDTO> alteraStatusNotificacao(@RequestParam("status") StatusNotificacaoEnum status,
                                                              @RequestParam("id") String id,
                                                              @RequestHeader(name = "authorization", required = false) String token) {
        return ResponseEntity.ok(tarefasService.alterarStatus(status, id, token));
    }

    @PutMapping
    @Operation(summary = "Altera dados de Tarefas", description = "Altera dados das tarefas cadastradas")
    @ApiResponse(responseCode = "200", description = "Tarefa alterada com sucesso")
    @ApiResponse(responseCode = "500", description = "Erro de servidor")
    public ResponseEntity<TarefasDTO> updateTarefas(@RequestBody TarefasDTO dto,
                                                    @RequestParam("id") String id,
                                                    @RequestHeader(name = "authorization", required = false) String token) {
        return ResponseEntity.ok(tarefasService.updateTarefas(dto, id, token));
    }

}
