package com._42talents.spring_boot_karate_example.repo;

import com._42talents.spring_boot_karate_example.entity.Sales;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.time.Instant;

public interface SalesRepository extends MongoRepository<Sales, String> {
    //    @Query("{saleDate: { $gte: ISODate('2014-12-07'), $lte: ISODate('2014-12-08') }} ")
    @Query("{storeLocation: ?0 ,saleDate: {$gte: {'$date': '?1'} , $lte: {'$date': '?2'}}}")
    Page<Sales> findSalesByDate(String storeLocation, Instant fromDate, Instant toDate, Pageable pageable);
}
