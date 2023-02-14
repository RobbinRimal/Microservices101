package com.example.MovieCateloservice.resources;

import com.example.MovieCateloservice.model.CatelogItem;
import com.example.MovieCateloservice.model.Movie;
import com.example.MovieCateloservice.model.Rating;
import com.example.MovieCateloservice.model.UserRating;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/catalog")
@JsonDeserialize
public class MovieCatelogResources {
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private WebClient.Builder builder;
    @RequestMapping("/{userId}")
    public List<CatelogItem> getCatelog(@PathVariable("userId") String userId){
        UserRating userRating=restTemplate.getForObject("http://microservice3/ratingdata/user/helloram",UserRating.class);
                List<Rating> ratingList=Arrays.asList(
                new Rating("aavatar",4),
                new Rating("aletta",3)
        );
//        UserRating userRating=builder.build().get().uri("http://microservice3/ratingdata/user/"+userId).retrieve().bodyToMono(UserRating.class).block();

        return userRating.getUserRating().
                stream().
                map(rating ->{
                    Movie movie = restTemplate.getForObject("http://microservice1/movies/" + rating.getMovieId(), Movie.class);
//                    Movie movie= builder.build()
//                            .get()
//                            .uri("http://microservice1/movies/"+userId)
//                            .retrieve()
//                            .bodyToMono(Movie.class)
//                            .block();
                    return new CatelogItem(movie.getName(),"this is the movie about the fighting for resources between two civilization",5);
                    }).collect(Collectors.toList());





    }
}
