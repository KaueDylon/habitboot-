package kauedy.habitBoot.DTO;

import kauedy.habitBoot.database.entity.HabitoEntity;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class UsuarioListarDTO {

    private String email;

    private Boolean status;

    private List<HabitoDTO> habitos = new ArrayList<>();

}
