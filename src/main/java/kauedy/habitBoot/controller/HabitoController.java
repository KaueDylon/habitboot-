package kauedy.habitBoot.controller;

import kauedy.habitBoot.DTO.CriarHabitoDTO;
import kauedy.habitBoot.DTO.FrequenciaHabitoDTO;
import kauedy.habitBoot.DTO.HabitoDTO;
import kauedy.habitBoot.database.repository.FrequenciaHabitoRepository;
import kauedy.habitBoot.service.FrequenciaHabitoService;
import kauedy.habitBoot.service.HabitoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/habito")
@RequiredArgsConstructor
@Validated
public class HabitoController {

    private final HabitoService habitoService;
    private final FrequenciaHabitoService frequenciaHabitoService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void criarHabito(@RequestBody CriarHabitoDTO request){
        habitoService.criarHabito(request);
    }
}
