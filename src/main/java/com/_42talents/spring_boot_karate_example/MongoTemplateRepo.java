package com._42talents.spring_boot_karate_example;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;


@Component
public class MongoTemplateRepo {

    @Autowired
    MongoTemplate mongoTemplate;

    @Autowired
    RestaurantRepository restaurantRepository;
    @Autowired
    SalesRepository salesRepository;

    public void find() {
        Query query = new Query(Criteria.where("name").is("Morris Park Bake Shop"));
        List<Document> result = mongoTemplate.find(query, Document.class, "restaurants");
        System.out.println("result: " + result.get(0).get("cuisine"));
    }

    public void findByPagination() {
        Pageable pageRequest = PageRequest.of(0, 10);
        Page<Restaurant> restaurantPage;
        do {
            restaurantPage = restaurantRepository.findRestaurantByName("Hotdogs", pageRequest);
            System.out.println("--------------------------Page Number: " + restaurantPage.getNumber() + " total : " + restaurantPage.getTotalElements());
            restaurantPage.stream().forEach(restaurant -> System.out.println(restaurant.getName()));
            pageRequest = pageRequest.next();
        } while (!restaurantPage.isLast());
        System.out.println("--------------------------Finish: ");
    }

    public void findInArray() {
        Criteria criteria1 = Criteria.where("grades.grade").is("B").andOperator(Criteria.where("grades.score").is(27));

        Criteria criteria2 = Criteria.where("grades.grade").is("C").andOperator(Criteria.where("grades.score").is(10));

        Query query = new Query(new Criteria().andOperator(criteria1, criteria2));

        List<Document> result = mongoTemplate.find(query, Document.class, "restaurants");
        System.out.println("result size: " + result.size());
        result.forEach(r -> System.out.println(r.get("name")));
    }

    public void findSales() {
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
