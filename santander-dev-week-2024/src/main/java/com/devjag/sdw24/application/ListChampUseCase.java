package com.devjag.sdw24.application;

import com.devjag.sdw24.domain.model.Champ;
import com.devjag.sdw24.domain.ports.ChampRepository;
import java.util.List;

public record ListChampUseCase(ChampRepository repository) {

    public List<Champ> findAll() {
        return repository.findAll();
    }

}
