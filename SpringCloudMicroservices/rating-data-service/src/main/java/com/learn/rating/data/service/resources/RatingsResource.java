package com.learn.rating.data.service.resources;

import com.learn.rating.data.service.model.Rating;
import com.learn.rating.data.service.model.UserRatings;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@RestController
@RequestMapping("/rating")
public class RatingsResource {

    @RequestMapping(path = "/{movieId}")
    public Rating rating(@PathVariable("movieId") String movieId){
        return new Rating(movieId,4);
    }

    @RequestMapping(path = "/user/{userId}")
    public UserRatings getUserRatings(@PathVariable("userId") String userId){
        return new UserRatings(userId, Arrays.asList(
                new Rating( "4",5),
                new Rating( "21",4)
        ));

    }


}
