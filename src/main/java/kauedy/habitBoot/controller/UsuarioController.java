package kauedy.habitBoot.controller;

import kauedy.habitBoot.DTO.UsuarioDTO;
import kauedy.habitBoot.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuario")
@RequiredArgsConstructor
@Validated
public class UsuarioController {

    private final UsuarioService usuarioService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void criarCliente(@Validated @RequestBody UsuarioDTO usuarioDTO) {
        usuarioService.criarUsuario(usuarioDTO);
    }

}
