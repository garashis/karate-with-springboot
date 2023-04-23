package com._42talents.spring_boot_karate_example;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.time.Instant;

public interface SalesRepository extends MongoRepository<Sales, String> {
    //    @Query("{saleDate: { $gte: ISODate('2014-12-07'), $lte: ISODate('2014-12-08') }} ")
    @Query("{saleDate: {$gte: {'$date': '?0'} , $lte: {'$date': '?1'}}}")
    Page<Sales> findSalesByDate(Instant fromDate, Instant toDate, Pageable pageable);
}
