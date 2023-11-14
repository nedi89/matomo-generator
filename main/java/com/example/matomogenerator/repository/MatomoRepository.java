package com.example.matomogenerator.repository;

import com.example.matomogenerator.entity.MatomoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MatomoRepository extends JpaRepository<MatomoEntity, Long> {
    Optional<MatomoEntity> findByNameAndNamespace(String name, String namespace);
}
