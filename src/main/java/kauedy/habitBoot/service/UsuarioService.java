package kauedy.habitBoot.service;

import kauedy.habitBoot.DTO.UsuarioDTO;
import kauedy.habitBoot.database.entity.UsuarioEntity;
import kauedy.habitBoot.database.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public void criarUsuario(UsuarioDTO usuarioDTO){

        UsuarioEntity usuario = usuarioRepository.findByEmail(usuarioDTO.getEmail())
                .orElse(null);

        if(usuario != null){

        }

        usuarioRepository.save(
                UsuarioEntity.builder()
                        .email(usuarioDTO.getEmail())
                        .senha((usuarioDTO.getSenha()))
                        .build()
        );

    }

}
