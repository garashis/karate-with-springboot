package com._42talents.spring_boot_karate_example.service;

import com._42talents.spring_boot_karate_example.entity.Sales;
import com._42talents.spring_boot_karate_example.repo.SalesRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.Date;

public abstract class RootService {

    final SalesRepository salesRepository;

    RootService(SalesRepository salesRepository) {
        this.salesRepository = salesRepository;
    }

    public abstract void getSales();

    public void getDefaultSales() {
        Pageable pageRequest = PageRequest.of(0, 10);
        Page<Sales> salesPage;
        Date from = new Date(114, 11, 7);
        Date to = new Date(115, 0, 8);
        do {
            salesPage = salesRepository.findSalesByDate("New York", from.toInstant(), to.toInstant(), pageRequest);
            System.out.println("--------------------------Page Number: " + salesPage.getNumber() + " total : " + salesPage.getTotalElements());
            salesPage.stream().forEach(restaurant -> System.out.println(restaurant.getStoreLocation()));
            pageRequest = pageRequest.next();
        } while (!salesPage.isLast());
    }
}
