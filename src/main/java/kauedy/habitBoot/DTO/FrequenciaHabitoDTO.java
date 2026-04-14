package kauedy.habitBoot.DTO;

import kauedy.habitBoot.database.entity.HabitoEntity;
import kauedy.habitBoot.enums.TipoFrequencia;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class FrequenciaHabitoDTO {

    private TipoFrequencia.TipoFreq tipo;
    private List<Integer> diasSemana;
    private Integer intervalo;

}
