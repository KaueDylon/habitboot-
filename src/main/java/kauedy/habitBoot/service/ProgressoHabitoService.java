package kauedy.habitBoot.service;

import kauedy.habitBoot.database.entity.FrequenciaHabitoEntity;
import kauedy.habitBoot.database.entity.HabitoEntity;
import kauedy.habitBoot.database.entity.ProgressoHabitoEntity;
import kauedy.habitBoot.database.repository.FrequenciaHabitoRepository;
import kauedy.habitBoot.database.repository.ProgressoHabitoRepository;
import kauedy.habitBoot.enums.TipoFrequencia;
import lombok.RequiredArgsConstructor;
import net.bytebuddy.asm.Advice;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProgressoHabitoService {

    private final ProgressoHabitoRepository progressoHabitoRepository;
    private final FrequenciaHabitoRepository frequenciaHabitoRepository;

    public void criarDias(HabitoEntity habito, List<Integer> diasSemana) {

        if (habito.getFrequencia().getTipo() == TipoFrequencia.TipoFreq.DIARIA) {
            cadastrarDiaria(habito.getDataInicio(), habito.getDataFim(), habito);
        }

        if (habito.getFrequencia().getTipo() == TipoFrequencia.TipoFreq.SEMANAL) {
            cadastrarSemanal(habito.getDataInicio(), habito.getDataFim(), habito, diasSemana);
        }

        if (habito.getFrequencia().getTipo() == TipoFrequencia.TipoFreq.MENSAL) {
            cadastrarMensal(habito.getDataInicio(), habito.getDataFim(), habito, diasSemana);
        }

    }

    public void cadastrarDiaria(LocalDate dataIni, LocalDate dataFim, HabitoEntity habito) {

        while (dataIni.isBefore(dataFim)) {
            dataIni = dataIni.plusDays(1);

            ProgressoHabitoEntity progHabito = ProgressoHabitoEntity.builder()
                    .habito(habito)
                    .data(dataIni)
                    .concluido(false)
                    .build();

            progressoHabitoRepository.save(progHabito);

        }

    }

    private void cadastrarSemanal(LocalDate dataIni, LocalDate dataFim, HabitoEntity habito, List<Integer> freq) {

        while (dataIni.isBefore(dataFim)){
            int diaSemana = dataIni.getDayOfWeek().getValue();
            if (freq.contains(diaSemana)){
                ProgressoHabitoEntity progHabito = ProgressoHabitoEntity.builder()
                        .habito(habito)
                        .data(dataIni)
                        .concluido(false)
                        .build();

                progressoHabitoRepository.save(progHabito);
            }
            dataIni = dataIni.plusDays(1);
        }

    }

    private void cadastrarMensal(LocalDate dataIni, LocalDate dataFim, HabitoEntity habito, List<Integer> freq) {

        while (dataIni.isBefore(dataFim)){
            int diaSemana = dataIni.getDayOfMonth();
            if (freq.contains(diaSemana)){
                ProgressoHabitoEntity progHabito = ProgressoHabitoEntity.builder()
                        .habito(habito)
                        .data(dataIni)
                        .concluido(false)
                        .build();

                progressoHabitoRepository.save(progHabito);
            }
            dataIni = dataIni.plusDays(1);
        }

    }

}
