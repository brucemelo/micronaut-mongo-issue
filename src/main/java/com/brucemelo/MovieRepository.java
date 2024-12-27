package com.brucemelo;

import io.micronaut.data.annotation.Join;
import io.micronaut.data.mongodb.annotation.MongoRepository;
import io.micronaut.data.mongodb.annotation.MongoUpdateQuery;
import io.micronaut.data.repository.CrudRepository;
import org.bson.types.ObjectId;

import java.util.List;
import java.util.Set;

@MongoRepository(databaseName = "default")
public interface MovieRepository extends CrudRepository<Movie, ObjectId> {

    @Join(value = "next")
    List<Movie> list();

    // tried with _id and eq, _id and $regex
    @MongoUpdateQuery(filter = "{id:{$regex: :id}}", update = "{$set:{next: :next}}")
    void saveNextMovies1(String id, Set<Movie> next);

}
