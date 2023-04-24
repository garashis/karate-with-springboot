package com._42talents.spring_boot_karate_example.service;

import com._42talents.spring_boot_karate_example.entity.Sales;
import com._42talents.spring_boot_karate_example.repo.SalesRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.time.Instant;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class SalesServiceTest {
    @Mock
    private SalesRepository salesRepository;

    // Abstract class Mocking
    private RootService salesService;

    @BeforeEach
    void setup() {
        salesService = new SalesService(salesRepository);
    }

    @Test
    void getSales() {
        Sales sales = new Sales();
        sales.setStoreLocation("Test Location");
        Page<Sales> page = new PageImpl<>(List.of(sales));
        when(salesRepository.findSalesByDate(anyString(), any(Instant.class), any(Instant.class), any(Pageable.class)))
                .thenReturn(page);
        salesService.getSales();
    }
}