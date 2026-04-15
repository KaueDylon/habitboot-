package kauedy.habitBoot.service;


import kauedy.habitBoot.DTO.FrequenciaHabitoDTO;
import kauedy.habitBoot.DTO.FrequenciaHabitoListarDTO;
import kauedy.habitBoot.DTO.HabitoDTO;
import kauedy.habitBoot.DTO.UsuarioListarDTO;
import kauedy.habitBoot.database.entity.FrequenciaHabitoEntity;
import kauedy.habitBoot.database.entity.HabitoEntity;
import kauedy.habitBoot.database.repository.FrequenciaHabitoRepository;
import kauedy.habitBoot.database.repository.HabitoRepository;
import kauedy.habitBoot.database.repository.ProgressoHabitoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FrequenciaHabitoService {

    private final FrequenciaHabitoRepository frequenciaHabitoRepository;
    private final HabitoRepository habitoRepository;
    private final ProgressoHabitoRepository progressoHabitoRepository;

    public FrequenciaHabitoEntity criarFrequencia(FrequenciaHabitoDTO frequenciaHabitoDTO, HabitoEntity habito) {


        FrequenciaHabitoEntity frequencia = FrequenciaHabitoEntity.builder()
                .tipo(frequenciaHabitoDTO.getTipo())
                .diasSemana(frequenciaHabitoDTO.getDiasSemana())
                .habito(habito)
                .build();


        habito.setFrequencia(frequencia);

        return frequenciaHabitoRepository.save(frequencia);

    }

    @Transactional
    public List<FrequenciaHabitoListarDTO> listarFrequenciaPorHabitoUsuario() {

        return frequenciaHabitoRepository.findAll()
                .stream()
                .map(freq -> FrequenciaHabitoListarDTO.builder()
                        .usuarioId(freq.getHabito().getUsuario().getId())
                        .habitoId(freq.getHabito().getId())
                        .tipo(freq.getTipo())
                        .diasSemana(freq.getDiasSemana())
                        .build()
                )
                .collect(Collectors.toList());
    }
}