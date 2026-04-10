package kauedy.habitBoot.service;


import kauedy.habitBoot.DTO.FrequenciaHabitoDTO;
import kauedy.habitBoot.DTO.HabitoDTO;
import kauedy.habitBoot.database.entity.HabitoEntity;
import kauedy.habitBoot.database.entity.UsuarioEntity;
import kauedy.habitBoot.database.repository.HabitoRepository;
import kauedy.habitBoot.database.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.Column;
import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class HabitoService {

    private final HabitoRepository habitoRepository;

    private final FrequenciaHabitoService frequenciaHabitoService;

//    private final ProgressoHabitoService progressoHabitoService;

    public void criarHabito(HabitoDTO habitoDTO, FrequenciaHabitoDTO frequenciaHabitoDTO){


        boolean existe = habitoRepository
                .findByNomeAndUsuarioId(habitoDTO.getNome(), habitoDTO.getUsuario().getId())
                .isPresent();

        if(existe){
            throw new RuntimeException("Já existe um mesmo hábito para o usuário.");
        }

        LocalDate dataIni = LocalDate.now();


        HabitoEntity habito = HabitoEntity.builder()
                        .nome(habitoDTO.getNome())
                        .desc(habitoDTO.getDesc())
                        .dataInicio(dataIni)
                        .dataFim(habitoDTO.getDataFim())
                        .status(true)
                        .build();


        habitoRepository.save(habito);

        frequenciaHabitoService.criarFrequencia(frequenciaHabitoDTO, habito);
//        progressoHabitoService.criarDias(habito);

    }

}
