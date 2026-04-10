package kauedy.habitBoot.DTO;

import kauedy.habitBoot.database.entity.HabitoEntity;
import kauedy.habitBoot.enums.TipoFrequencia;
import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class FrequenciaHabitoDTO {

    private TipoFrequencia.TipoFreq tipo;
    private Integer diaSemana;
    private Integer intervalo;

}
