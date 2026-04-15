package kauedy.habitBoot.controller;


import kauedy.habitBoot.DTO.CriarHabitoDTO;
import kauedy.habitBoot.DTO.FrequenciaHabitoListarDTO;
import kauedy.habitBoot.DTO.UsuarioListarDTO;
import kauedy.habitBoot.service.FrequenciaHabitoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/frequencia")
@RequiredArgsConstructor
@Validated
public class FrequenciaHabitoController {

    private final FrequenciaHabitoService frequenciaHabitoService;

    @GetMapping
    @ResponseStatus(HttpStatus.CREATED)
    public List<FrequenciaHabitoListarDTO> listarFrequenciaPorHabitoUsuario(){
        return frequenciaHabitoService.listarFrequenciaPorHabitoUsuario();
    }

}
