package kauedy.habitBoot.service;

import kauedy.habitBoot.DTO.UsuarioDTO;
import kauedy.habitBoot.database.entity.UsuarioEntity;
import kauedy.habitBoot.database.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public void criarUsuario(UsuarioDTO usuarioDTO){

        UsuarioEntity usuario = usuarioRepository.findByEmail(usuarioDTO.getEmail())
                .orElse(null);

        usuarioRepository.save(
                UsuarioEntity.builder()
                        .email(usuarioDTO.getEmail())
                        .senha((usuarioDTO.getSenha()))
                        .status(true)
                        .build()
        );

    }

    public List<UsuarioDTO> listarUsuario() {

        List<UsuarioEntity> usuarios = usuarioRepository.findAll();

        return usuarioRepository.findAll()
                .stream()
                .map(usuario -> new UsuarioDTO(
                        usuario.getEmail(),
                        usuario.getStatus()
                ))
                .collect(Collectors.toList());
    }

    public void deletarUsuario(Integer usuarioId) throws BadRequestException {

        UsuarioEntity usuario = usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new BadRequestException("Cliente não encontrado."));

        usuario.setStatus(false);
        usuarioRepository.save(usuario);

    }

    public void restaurarUsuario(Integer clienteId) throws BadRequestException {
        UsuarioEntity usuario = usuarioRepository.findById(clienteId)
                .orElseThrow(() -> new BadRequestException("Cliente não encontrado."));

        usuario.setStatus(true);
        usuarioRepository.save(usuario);
    }



}
