package com.example.demo;

import java.lang.reflect.ParameterizedType;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogController {

	@Autowired
	private RestTemplate restTemplate;

	@GetMapping("/{userId}")
	public List<CatalogItem> getCatalog(@PathVariable("userId") String userId) {

		// get all rated movie id
		UserRating ratings = restTemplate.getForObject("http://RATING-SERVICE/rating/users/" + userId,
				UserRating.class);

		return ratings.getUserRating().stream().map(rating -> {
			Movie movie = restTemplate.getForObject("http://MOVIE-INFO-SERVICE/movies/" + rating.getMovieId(), Movie.class);
			
			return new CatalogItem(movie.getMovieName(), rating.getRating());
		}).collect(Collectors.toList());

		/*
		 * return Collections.singletonList( new CatalogItem("ABCD","6") );
		 */

	}
}
