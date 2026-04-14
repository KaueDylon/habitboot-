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
public class UsuarioDTO {

    private String email;

    private String senha;

    private Boolean status;

    private List<HabitoEntity> habitos = new ArrayList<>();

    public UsuarioDTO(String email, Boolean status) {
    }
}
