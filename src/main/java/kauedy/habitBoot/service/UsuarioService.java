package kauedy.habitBoot.service;

import kauedy.habitBoot.DTO.HabitoDTO;
import kauedy.habitBoot.DTO.UsuarioDTO;
import kauedy.habitBoot.DTO.UsuarioListarDTO;
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

        if (usuarioRepository.findByEmail(usuarioDTO.getEmail()).isPresent()) {
            throw new RuntimeException("Email já cadastrado");
        }

        usuarioRepository.save(
                UsuarioEntity.builder()
                        .email(usuarioDTO.getEmail())
                        .senha((usuarioDTO.getSenha()))
                        .status(true)
                        .build()
        );

    }

    public List<UsuarioListarDTO> listarUsuario() {

        return usuarioRepository.findAll()
                .stream()
                .map(usuario -> UsuarioListarDTO.builder()
                        .email(usuario.getEmail())
                        .status(usuario.getStatus())
                        .habitos(
                                usuario.getHabitos().stream()
                                        .map(habito -> HabitoDTO.builder()
                                                .nome(habito.getNome())
                                                .desc(habito.getDesc())
                                                .dataInicio(habito.getDataInicio())
                                                .dataFim(habito.getDataFim())
                                                .status(habito.getStatus())
                                                .build()
                                        )
                                        .collect(Collectors.toList())
                        )
                        .build()
                )
                .collect(Collectors.toList());
    }

    public void deletarUsuario(Integer usuarioId) throws BadRequestException {

        UsuarioEntity usuario = usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new BadRequestException("Usuario não encontrado."));

        usuario.setStatus(false);
        usuarioRepository.save(usuario);

    }

    public void restaurarUsuario(Integer usuarioId) throws BadRequestException {
        UsuarioEntity usuario = usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new BadRequestException("Usuario não encontrado."));

        usuario.setStatus(true);
        usuarioRepository.save(usuario);
    }



}
