package com._42talents.spring_boot_karate_example.repo;

import com._42talents.spring_boot_karate_example.entity.Restaurant;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface RestaurantMongoRepository extends MongoRepository<Restaurant, String> {
    @Query("{cuisine:'?0'}")
        //@Aggregation("{cuisine: '?0'},{$limit: ?1}")
    Page<Restaurant> findRestaurantByName(String cuisine, Pageable pageable);

    @Query(value = "{category:'?0'}", fields = "{'name' : 1, 'quantity' : 1}")
    List<Restaurant> findAll(String category);

    public long count();
}
