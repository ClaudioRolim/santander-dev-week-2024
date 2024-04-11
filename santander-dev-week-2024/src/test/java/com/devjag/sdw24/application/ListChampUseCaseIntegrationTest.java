package com.devjag.sdw24.application;

import com.devjag.sdw24.domain.model.Champ;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.List;

@SpringBootTest
public class ListChampUseCaseIntegrationTest {

    @Autowired
    private ListChampUseCase listChampUseCase;

    @Test
    public void testListChampUseCase() {
        List<Champ> champ = listChampUseCase.findAll();

        Assertions.assertEquals(12, champ.size());
    }
}
