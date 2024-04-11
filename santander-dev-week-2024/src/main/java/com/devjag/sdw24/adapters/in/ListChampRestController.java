package com.devjag.sdw24.adapters.in;

import com.devjag.sdw24.application.ListChampUseCase;
import com.devjag.sdw24.domain.model.Champ;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@Tag(name = "Campeões", description = "Endpoints do domínio de Campeões do LOL.")
@RestController
@RequestMapping("/champions")
public record ListChampRestController(ListChampUseCase useCase) {

    @GetMapping
    public List<Champ> findAllChamp() {
        return useCase.findAll();
    }
}
