package kauedy.habitBoot.database.entity;

import kauedy.habitBoot.enums.TipoFrequencia;
import lombok.*;

import javax.persistence.*;

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

    @Column(name = "frequencia_dia_semana")
    private Integer diaSemana;

    @Column(name = "frequencia_intervalo")
    private Integer intervalo;

    @OneToOne
    @JoinColumn(name = "habito_id", nullable = false, unique = true)
    private HabitoEntity habito;

}
