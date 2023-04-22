package com._42talents.spring_boot_karate_example;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class MongoTemplateRepo {

    @Autowired
    MongoTemplate mongoTemplate;

    @Autowired
    RestaurantRepository restaurantRepository;

    public void find() {
        Query query = new Query(Criteria.where("name").is(
                "Morris Park Bake Shop"));
        List<Document> result = mongoTemplate.find(query, Document.class, "restaurants");
        System.out.println("result: " + result.get(0).get("cuisine"));
    }

    public List<Restaurant> findByName() {
        PageRequest pageRequest = PageRequest.of(0, 5);
        Page<Restaurant> restaurant = restaurantRepository.findRestaurantByName("Bakery", pageRequest);
        System.out.println("restaurant.getCuisine(): >>>>>>>> " + restaurant.getContent().size());
        return restaurant.getContent();
    }

    public void findInArray() {
        Criteria criteria1 = Criteria.where("grades.grade").is("B")
                .andOperator(Criteria.where("grades.score").is(27));

        Criteria criteria2 = Criteria.where("grades.grade").is("C")
                .andOperator(Criteria.where("grades.score").is(10));

        Query query = new Query(new Criteria().andOperator(criteria1, criteria2));

        List<Document> result = mongoTemplate.find(query, Document.class, "restaurants");
        System.out.println("result size: " + result.size());
        result.forEach(r -> System.out.println(r.get("name")));
    }
}
