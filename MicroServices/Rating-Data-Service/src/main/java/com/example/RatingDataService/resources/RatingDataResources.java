package com.example.RatingDataService.resources;

import com.example.RatingDataService.model.Rating;
import com.example.RatingDataService.model.UserRating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("ratingdata")
public class RatingDataResources {
    @Autowired
    UserRating userRating;
    @RequestMapping("/{movieId}")
    public Rating getRating(@PathVariable("movieId") String movieId){
        return new Rating(movieId,5);
    }
   @RequestMapping("/user/{userId}")
        public UserRating getUserRating(){

        List<Rating> ratingList= Arrays.asList(
                new Rating("1234",5 ),
                new Rating("5674",6)
        );
        userRating.setUserRating(ratingList);
        return userRating ;
        }
}
