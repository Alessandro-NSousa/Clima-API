package com.clima.api.clima_api.repository;

import com.clima.api.clima_api.domain.Clima;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ClimaRepository extends JpaRepository<Clima, Long> {

    List<Clima> findByCityIgnoreCase(String city);
}
