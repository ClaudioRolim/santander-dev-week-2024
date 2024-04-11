package com.devjag.sdw24.domain.ports;

import com.devjag.sdw24.domain.model.Champ;
import java.util.List;
import java.util.Optional;

public interface ChampRepository {

    List<Champ> findAll();
    Optional<Champ> findById(Long id);
}
