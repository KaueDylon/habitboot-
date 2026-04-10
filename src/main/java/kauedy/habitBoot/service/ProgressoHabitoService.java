//package kauedy.habitBoot.service;
//
//import kauedy.habitBoot.database.entity.HabitoEntity;
//import kauedy.habitBoot.database.entity.ProgressoHabitoEntity;
//import kauedy.habitBoot.database.repository.FrequenciaHabitoRepository;
//import kauedy.habitBoot.database.repository.ProgressoHabitoRepository;
//import kauedy.habitBoot.enums.TipoFrequencia;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Service;
//
//import java.time.LocalDate;
//import java.time.temporal.ChronoUnit;
//import java.util.List;
//
//@Service
//@RequiredArgsConstructor
//public class ProgressoHabitoService {
//
//    private final ProgressoHabitoRepository progressoHabitoRepository;
//    private final FrequenciaHabitoRepository frequenciaHabitoRepository;
//
//    public void criarDias(HabitoEntity habito){
//
//        habito.getDataFim();
//        habito.getFrequencia();
//
//        if(habito.getFrequencia().getTipo() == TipoFrequencia.TipoFreq.DIARIA){
//            cadastrarDiaria(datas);
//        }
//
//        if(habito.getFrequencia().getTipo() == TipoFrequencia.TipoFreq.SEMANAL){
//
//        }
//
//        if(habito.getFrequencia().getTipo() == TipoFrequencia.TipoFreq.PERSONALIZADO){
//
//        }
//
//    }
//
//    public void cadastrarDiaria(List<Lo>)
//
//}
