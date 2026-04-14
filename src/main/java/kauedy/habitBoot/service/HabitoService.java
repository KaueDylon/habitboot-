package kauedy.habitBoot.service;


import kauedy.habitBoot.DTO.CriarHabitoDTO;
import kauedy.habitBoot.database.entity.FrequenciaHabitoEntity;
import kauedy.habitBoot.database.entity.HabitoEntity;
import kauedy.habitBoot.database.entity.UsuarioEntity;
import kauedy.habitBoot.database.repository.FrequenciaHabitoRepository;
import kauedy.habitBoot.database.repository.HabitoRepository;
import kauedy.habitBoot.database.repository.UsuarioRepository;
import kauedy.habitBoot.exception.DateTimeParseException;
import kauedy.habitBoot.exception.IllegalArgumentException;
import kauedy.habitBoot.exception.IllegalStateException;
import kauedy.habitBoot.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class HabitoService {

    private final HabitoRepository habitoRepository;

    private final FrequenciaHabitoRepository frequenciaHabitoRepository;

    private final FrequenciaHabitoService frequenciaHabitoService;

    private final ProgressoHabitoService progressoHabitoService;

    private final UsuarioRepository usuarioRepository;

    public void criarHabito(CriarHabitoDTO criarHabitoDTO){


        boolean habitoJaExiste = habitoRepository
                .findByNomeAndUsuarioId(criarHabitoDTO.getNome(), Math.toIntExact(criarHabitoDTO.getUsuarioId()))
                .isPresent();

        if(habitoJaExiste){
            throw new IllegalStateException("Já existe um mesmo hábito para o usuário.");
        }

        if(criarHabitoDTO.getNome().isEmpty()){
            throw new IllegalArgumentException("O nome do hábito não pode ser vazio.");

        }

        UsuarioEntity usuario = usuarioRepository.findById(Math.toIntExact(criarHabitoDTO.getUsuarioId()))
                .orElseThrow(() -> new NotFoundException("Usuário não encontrado"));

        LocalDate dataHoje = LocalDate.now();

        if(criarHabitoDTO.getDataIni().isBefore(dataHoje)
                || criarHabitoDTO.getDataIni().isAfter(criarHabitoDTO.getDataFim())){

            throw new DateTimeParseException("Insira datas válidas para cadastro.");
        }

        HabitoEntity habito = HabitoEntity.builder()
                        .nome(criarHabitoDTO.getNome())
                        .desc(criarHabitoDTO.getDesc())
                        .dataInicio(criarHabitoDTO.getDataIni())
                        .dataFim(criarHabitoDTO.getDataFim())
                        .status(true)
                        .usuario(usuario)
                        .build();

        habitoRepository.save(habito);

        FrequenciaHabitoEntity freq =
                frequenciaHabitoService.criarFrequencia(criarHabitoDTO.getFrequencia(), habito);


        progressoHabitoService.criarDias(habito, freq.getDiasSemana());

    }

}
