package org.example.Service;

import org.example.Models.DataModels.Asset;
import org.example.Models.DataModels.Investment;
import org.example.Repository.InvestmentRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class InvestmentServiceTest {

    @Mock
    private InvestmentRepository investmentRepository;

    @InjectMocks
    private InvestmentService investmentService;

    @Test
    void saveInvestment() {
        Investment investment = new Investment(
                new Asset("Gold", "Resource"),
                "123",
                2,
                Date.from(Instant.now())
        );

        investmentService.saveInvestment(investment);
        verify(investmentRepository, times(1)).save(investment);
    }

    @Test
    void getInvestmentById() {
        Asset asset = new Asset("Ethereum", "digital");
        Investment investment = new Investment(
                asset,
                "123",
                3.5,
                Date.from(Instant.now())
        );
        when(investmentRepository.findById("1")).thenReturn(Optional.of(investment));

        Optional<Investment> result = investmentService.getInvestmentById("1");
        assertTrue(result.isPresent());
        assertEquals(asset, result.get().getInvestmentAsset());
    }

    @Test
    void getAllInvestments() {
        Asset asset = new Asset("Ethereum", "digital");
        Asset asset2 = new Asset("Bitcoin", "digital");
        List<Investment> investments = List.of(
                new Investment(
                        asset,
                        "123",
                        3.5,
                        Date.from(Instant.now())
                ),
                new Investment(
                        asset2,
                        "123",
                        3.5,
                        Date.from(Instant.now())
                )
        );

        when(investmentRepository.findAll()).thenReturn(investments);
        List<Investment> result = investmentService.getAllInvestments();
        assertEquals(2, result.size());
        assertEquals(asset, result.getFirst().getInvestmentAsset());
        assertEquals(asset2, result.get(1).getInvestmentAsset());
    }

    @Test
    void getInvestmentById_shouldReturnEmpty_whenNotExists() {
        when(investmentRepository.findById("99")).thenReturn(Optional.empty());

        Optional<Investment> result = investmentService.getInvestmentById("99");

        assertFalse(result.isPresent());
    }
}