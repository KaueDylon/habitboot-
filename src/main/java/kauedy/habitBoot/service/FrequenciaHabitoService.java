package kauedy.habitBoot.service;


import kauedy.habitBoot.DTO.FrequenciaHabitoDTO;
import kauedy.habitBoot.DTO.HabitoDTO;
import kauedy.habitBoot.database.entity.FrequenciaHabitoEntity;
import kauedy.habitBoot.database.entity.HabitoEntity;
import kauedy.habitBoot.database.repository.FrequenciaHabitoRepository;
import kauedy.habitBoot.database.repository.HabitoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class FrequenciaHabitoService {

    private final FrequenciaHabitoRepository frequenciaHabitoRepository;

    public FrequenciaHabitoEntity criarFrequencia(FrequenciaHabitoDTO frequenciaHabitoDTO, HabitoEntity habito) {


        FrequenciaHabitoEntity frequencia = FrequenciaHabitoEntity.builder()
                .tipo(frequenciaHabitoDTO.getTipo())
                .diasSemana(frequenciaHabitoDTO.getDiasSemana())
                .habito(habito)
                .build();


        habito.setFrequencia(frequencia);

        return frequenciaHabitoRepository.save(frequencia);

    }
}