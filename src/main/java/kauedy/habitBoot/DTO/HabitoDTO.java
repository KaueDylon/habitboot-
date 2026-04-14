package kauedy.habitBoot.DTO;


import kauedy.habitBoot.database.entity.FrequenciaHabitoEntity;
import kauedy.habitBoot.database.entity.ProgressoHabitoEntity;
import kauedy.habitBoot.database.entity.UsuarioEntity;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class HabitoDTO {

    private String nome;

    private String desc;

    private LocalDate dataInicio;

    private LocalDate dataFim;

    private Boolean status;

//    private Integer usuarioId;

//    private FrequenciaHabitoDTO frequencia;

//    private List<ProgressoHabitoEntity> progresso = new ArrayList<>();


}
