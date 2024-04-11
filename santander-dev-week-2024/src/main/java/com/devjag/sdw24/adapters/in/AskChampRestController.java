package com.devjag.sdw24.adapters.in;

import com.devjag.sdw24.application.AskChampUseCase;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Campeões", description = "Endpoints do domínio de Campeões do LOL.")
@RestController
@RequestMapping("/champions")
public record AskChampRestController(AskChampUseCase useCase) {

    @PostMapping("/{championId}/ask")
    public AskChampResponse askChampion(@PathVariable Long championId, @RequestBody AskChampRequest request) {
        String answer = useCase.askChampion(championId, request.question());
        return new AskChampResponse(answer);
    }
    public record AskChampRequest(String question) { }
    public record AskChampResponse(String answer) { }
}
