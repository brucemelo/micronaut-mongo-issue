package com.brucemelo;


import io.micronaut.context.annotation.Context;
import jakarta.annotation.PostConstruct;
import jakarta.inject.Inject;

import java.util.Set;

@Context
public class DataLoader {

    @Inject
    MovieRepository movieRepository;

    @PostConstruct
    void init() {
        System.out.println("Example 1");
        var movie1 = new Movie(null, "Movie 1", null);
        var movie2 = new Movie(null, "Movie 2", Set.of(movie1));
        var saved1 = movieRepository.save(movie1);
        var saved2 = movieRepository.save(movie2);
        var list = movieRepository.list();
        var findall1 = movieRepository.findAll();
        System.out.println("next is empty - not saving/loading");

        System.out.println("Example 2");
        var movie3 = new Movie(null, "Movie 3", null);
        var movie4 = new Movie(null, "Movie 4", null);
        var saved3 = movieRepository.save(movie3);
        var saved4 = movieRepository.save(movie4);
        var newMovie3 = new Movie(saved3.id(), "New Movie 3", Set.of(movie4));
        var update = movieRepository.update(newMovie3);
        var list2 = movieRepository.list();
        var findall2 = movieRepository.findAll();
        System.out.println("next is empty - not saving/loading");

        System.out.println("Example 3");
        var movie5 = new Movie(null, "Movie 5", null);
        var movie6 = new Movie(null, "Movie 6", null);
        var saved5 = movieRepository.save(movie5);
        var saved6 = movieRepository.save(movie6);
        movieRepository.saveNextMovies1(saved5.id().toString(), Set.of(saved6));
        var list3 = movieRepository.list();
        var findall3 = movieRepository.findAll();
        System.out.println("next is empty - not saving/loading");
    }

}
