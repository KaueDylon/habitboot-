package kauedy.habitBoot.DTO;

import kauedy.habitBoot.enums.TipoFrequencia;
import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class FrequenciaHabitoListarDTO {

    private Long habitoId;
    private Integer usuarioId;
    private TipoFrequencia.TipoFreq tipo;
    private List<Integer> diasSemana;

}
