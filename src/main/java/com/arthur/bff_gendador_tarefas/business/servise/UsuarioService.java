package com.arthur.bff_gendador_tarefas.business.servise;

import com.arthur.bff_gendador_tarefas.business.dto.EnderecoDTO;
import com.arthur.bff_gendador_tarefas.business.dto.TelefoneDTO;
import com.arthur.bff_gendador_tarefas.business.dto.UsuarioDTO;
import com.arthur.bff_gendador_tarefas.infrastructure.client.UsuarioClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor

public class UsuarioService {

    private final UsuarioClient client;

    public UsuarioDTO salvarUsuario(UsuarioDTO usuarioDTO) {
        return client.salvarUsuario(usuarioDTO);

    }

    public String loginUsuario(UsuarioDTO usuarioDTO) {
        return client.login(usuarioDTO);
    }


    public UsuarioDTO buscarUsuarioPorEmail(String email, String token) {
        return client.buscarUsuarioPorEmail(email, token);
    }

    public void deletaUsuarioPorEmail(String email, String token) {
        client.deletarUsuarioPorEmail(email, token);
    }

    public UsuarioDTO atualizarDadosUsuario(String token, UsuarioDTO usuarioDTO) {
        return client.atualizarDadosUsuario(usuarioDTO, token);
    }

    public EnderecoDTO atualizaEndereco(Long idEndereco, EnderecoDTO enderecoDTO, String token) {
        return client.atualizaEndereco(enderecoDTO, idEndereco, token);
    }

    public TelefoneDTO atualizaTelefone(Long idTelefone, TelefoneDTO telefoneDTO, String token) {
        return client.atualizaTelefone(telefoneDTO, idTelefone, token);
    }

    public EnderecoDTO cadastraEndereco(String token, EnderecoDTO dto) {
        return client.cadastraEndereco(dto, token);

    }

    public TelefoneDTO cadastraTelefone(String token, TelefoneDTO dto) {
        return client.cadastraTelefone(dto, token);
    }


}
