package com.clima.api.clima_api.repository;

import com.clima.api.clima_api.domain.Clima;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ClimaRepository extends JpaRepository<Clima, Long> {

    Page<Clima> findByCityIgnoreCase(String city, Pageable paginacao);

    Page<Clima> findAll(Pageable pageable);
}
