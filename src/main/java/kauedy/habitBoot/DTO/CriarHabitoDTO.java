package kauedy.habitBoot.DTO;

import lombok.*;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class CriarHabitoDTO {


    private String nome;
    private String desc;
    private LocalDate dataIni;
    private LocalDate dataFim;
    private Long usuarioId;

    private FrequenciaHabitoDTO frequencia;

}
