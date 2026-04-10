package kauedy.habitBoot.database.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Habito")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class HabitoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "habito_id")
    private Long id;

    @Column(name = "habito_nome", nullable = false)
    private String nome;

    @Column(name = "habito_desc")
    private String desc;

    @Column(name = "habito_data_inicio")
    private LocalDate dataInicio;

    @Column(name = "habito_data_fim")
    private LocalDate dataFim;

    @Column(name = "habito_status")
    private Boolean status;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private UsuarioEntity usuario;

    @OneToOne(mappedBy = "habito", cascade = CascadeType.ALL)
    private FrequenciaHabitoEntity frequencia;

    @OneToMany(mappedBy = "habito", cascade = CascadeType.ALL)
    private List<ProgressoHabitoEntity> progresso = new ArrayList<>();

}
