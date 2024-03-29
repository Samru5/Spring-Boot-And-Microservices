package com.capgemini.moviecatalogservice.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.capgemini.moviecatalogservice.entity.Movie;
import com.capgemini.moviecatalogservice.entity.MovieCatalog;
import com.capgemini.moviecatalogservice.entity.Rating;
import com.capgemini.moviecatalogservice.entity.UserRating;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogController {
	
	@Autowired
	private RestTemplate restTemplate;

	@GetMapping("/{userId}")
	public ResponseEntity<List<MovieCatalog>> getMovieCatalog(@PathVariable String userId){
		
		//Get the movie ratings for user
		UserRating userRatings=restTemplate.getForEntity("http://MOVIE-RATINGS-SERVICE/ratings/"+ userId,UserRating.class).getBody();
		
		List<Rating> movieRatings=userRatings.getUserratings();
		List<MovieCatalog> movieCatalog=new ArrayList<MovieCatalog>();
		
		//Get movie information and creating catalog

		for(Rating rating:movieRatings) {
			Movie movie=restTemplate.getForEntity("http://MOVIE-INFO-SERVICE/movies/" +rating.getMovieId(),Movie.class).getBody();
			
			movieCatalog.add(new MovieCatalog(movie.getMovieTitle(),movie.getMovieDescription(),rating.getRating()));
			
		}
		
		
		//Return MovieCatalog to user
		
		
		return new ResponseEntity<List<MovieCatalog>>(movieCatalog,HttpStatus.OK);
		
	}
}
