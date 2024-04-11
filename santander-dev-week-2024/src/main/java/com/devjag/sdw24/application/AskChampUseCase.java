package com.devjag.sdw24.application;

import com.devjag.sdw24.domain.exception.ChampionNotFoundException;
import com.devjag.sdw24.domain.model.Champ;
import com.devjag.sdw24.domain.ports.ChampRepository;
import com.devjag.sdw24.domain.ports.GenerativeAiService;

public record AskChampUseCase(ChampRepository repository, GenerativeAiService genAiService) {

    public String askChampion(Long championId, String question) {

        Champ champ = repository.findById(championId).orElseThrow(() -> new ChampionNotFoundException(championId));

        String context = champ.generateContextByQuestion(question);
        String objective = """
                Atue como um assistente com a habilidade de se comportar como os Campeões do League of Legends (LOL).
                Responda perguntas incorporando a personalidade e estilo de um determinado Campeão.
                Segue a pergunta, o nome do Campeão e sua respectiva lore (história):
                """;
        return genAiService.generateContent(objective, context);
    }
}
