package com.jersson.arrivasplata.swtvap.api.campaing.expose.controllers;

import com.jersson.arrivasplata.swtvap.api.campaing.business.service.AnalyticService;
import com.jersson.arrivasplata.swtvap.api.campaing.mapper.AnalyticMapper;
import com.jersson.arrivasplata.swtvap.api.campaing.model.Analytic;
import com.jersson.arrivasplata.swtvap.api.campaing.model.AnalyticResponse;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class AnalyticControllerImplTest {

    @Mock
    private AnalyticService analyticService;

    @Mock
    private AnalyticMapper analyticMapper;

    @InjectMocks
    private AnalyticControllerImpl analyticController;

    // Crear una lista de objetos Analytic
    private List<Analytic> analytics = new ArrayList<>();

    // Crear una lista de objetos AnalyticResponse
    private List<AnalyticResponse> analyticsResponse = new ArrayList<>();

    @BeforeEach
    public void setup() {
        // Crear una lista de objetos Analytic
        analytics = Arrays.asList(
                new Analytic() {{
                    setAnalyticId(38L);
                    setVisitedPage("/cart");
                    setVisitedDate(LocalDate.parse("2024-03-16"));
                    setDeletedAt(null);
                }},
                new Analytic() {{
                    setAnalyticId(39L);
                    setVisitedPage("/");
                    setVisitedDate(LocalDate.parse("2024-03-16"));
                    setDeletedAt(null);
                }}
        );

        // Crear una lista de objetos AnalyticResponse
        analyticsResponse = Arrays.asList(
                new AnalyticResponse() {{
                    setAnalyticId(38L);
                    setVisitedPage("/cart");
                    setVisitedDate(LocalDate.parse("2024-03-16"));
                    setDeletedAt(null);
                }},
                new AnalyticResponse() {{
                    setAnalyticId(39L);
                    setVisitedPage("/");
                    setVisitedDate(LocalDate.parse("2024-03-16"));
                    setDeletedAt(null);
                }}
        );
    }

    @Test
    public void testGetAllAnalytics() {

        // Simular el comportamiento del servicio
        when(analyticService.getAllAnalytics()).thenReturn(Flux.fromIterable(analytics));

        // Simular el comportamiento del mapeador
        when(analyticMapper.analyticToAnalyticResponse(analytics.get(0)))
                .thenReturn(analyticsResponse.get(0));
        when(analyticMapper.analyticToAnalyticResponse(analytics.get(1)))
                .thenReturn(analyticsResponse.get(1));

        // Llamar al método que se está probando
        Flux<AnalyticResponse> response = analyticController.getAllAnalytics();

        // Verificar que el resultado es el esperado
        StepVerifier.create(response)
                .expectNext(analyticsResponse.get(0))
                .expectNext(analyticsResponse.get(1))
                .verifyComplete();
    }

    // Pruebas similares para otros métodos...
}
