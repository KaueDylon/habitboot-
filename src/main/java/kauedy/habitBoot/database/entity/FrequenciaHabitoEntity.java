package kauedy.habitBoot.database.entity;

import kauedy.habitBoot.enums.TipoFrequencia;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Frequencia_Habito")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class FrequenciaHabitoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "frequencia_id")
    private Long id;

    @Column(name = "frequencia_tipo")
    @Enumerated(EnumType.STRING)
    private TipoFrequencia.TipoFreq tipo;

    @ElementCollection
    @CollectionTable(
            name = "frequencia_dias_semana",
            joinColumns = @JoinColumn(name = "frequencia_id")
    )
    @Column(name = "dia_semana")
    private List<Integer> diasSemana;

    @OneToOne
    @JoinColumn(name = "habito_id", nullable = false, unique = true)
    private HabitoEntity habito;

}
