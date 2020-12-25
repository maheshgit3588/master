package com.learn.movie.catalog.service.resources;

import com.learn.movie.catalog.service.model.CatalogItem;
import com.learn.movie.catalog.service.model.Movie;
import com.learn.movie.catalog.service.model.Rating;
import com.learn.movie.catalog.service.model.UserRatings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping(path = "/{userId}")
    public List<CatalogItem> getCatalog(@PathVariable("userId") String userId) {

        List<Rating> ratingList =restTemplate.getForObject("http://localhost:8082/rating/user/"+userId, UserRatings.class).getRatings();

        return ratingList.stream().map(r->{
            Movie m=restTemplate.getForObject("http://localhost:8081/info/"+r.getMovieId(),Movie.class);
            return  new CatalogItem(m.getMovieName(), "Descr "+m.getMovieId(), r.getRating());
        }).collect(Collectors.toList());

    }
}
