package com._42talents.spring_boot_karate_example.service;

import com._42talents.spring_boot_karate_example.entity.Sales;
import com._42talents.spring_boot_karate_example.repo.SalesRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class SalesService extends RootService {
    public SalesService(SalesRepository salesRepository) {
        super(salesRepository);
    }

    @Override
    public void getSales() {
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
