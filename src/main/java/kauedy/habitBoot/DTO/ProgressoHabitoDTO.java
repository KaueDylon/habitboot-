package kauedy.habitBoot.DTO;


import kauedy.habitBoot.database.entity.HabitoEntity;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class ProgressoHabitoDTO {

    private LocalDate data;

    private Boolean concluido;

}
