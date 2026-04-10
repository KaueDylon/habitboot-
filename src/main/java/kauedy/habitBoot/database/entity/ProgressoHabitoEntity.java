package kauedy.habitBoot.database.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "Progresso_Habito")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class ProgressoHabitoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "progresso_habito_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "habito_id", nullable = false)
    private HabitoEntity habito;

    @Column(name = "data", nullable = false)
    private LocalDate data;

    @Column(name = "concluido", nullable = false)
    private Boolean concluido;

}
