package kauedy.habitBoot.database.repository;

import kauedy.habitBoot.database.entity.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Integer> {

    Optional<UsuarioEntity> findByEmail(String email);

    //Optional<UsuarioEntity> findAll();
}
