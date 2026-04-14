package kauedy.habitBoot.database.repository;

import kauedy.habitBoot.database.entity.HabitoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface HabitoRepository extends JpaRepository<HabitoEntity, Integer> {

    Optional<HabitoEntity> findById(Long id);

    Optional<HabitoEntity> findByNome(String nome);

    Optional<HabitoEntity> findByNomeAndUsuarioId(String nome, Integer usuarioId);


}
