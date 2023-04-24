package com._42talents.spring_boot_karate_example.service;

import com._42talents.spring_boot_karate_example.repo.SalesRepository;

public abstract class RootService {

    protected final SalesRepository salesRepository;

    RootService(SalesRepository salesRepository) {
        this.salesRepository = salesRepository;
    }

    public abstract void getSales();
}
