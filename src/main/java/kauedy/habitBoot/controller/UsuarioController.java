package kauedy.habitBoot.controller;

import kauedy.habitBoot.DTO.UsuarioDTO;
import kauedy.habitBoot.DTO.UsuarioListarDTO;
import kauedy.habitBoot.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<UsuarioListarDTO> listarUsuario(){
        return usuarioService.listarUsuario();
    }

    @DeleteMapping("/{usuarioId}/deletar")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void  deletarUsuario(@Validated @PathVariable Integer usuarioId) throws BadRequestException {
        usuarioService.deletarUsuario(usuarioId);
    }

    @PatchMapping("/{usuarioId}/restaurar")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void restaurarUsuario(@Validated @PathVariable Integer usuarioId) throws BadRequestException {
        usuarioService.restaurarUsuario(usuarioId);
    }

}
