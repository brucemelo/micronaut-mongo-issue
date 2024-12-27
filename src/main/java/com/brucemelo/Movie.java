package com.brucemelo;

import io.micronaut.core.annotation.Nullable;
import io.micronaut.data.annotation.GeneratedValue;
import io.micronaut.data.annotation.Id;
import io.micronaut.data.annotation.MappedEntity;
import io.micronaut.data.annotation.Relation;
import io.micronaut.serde.annotation.Serdeable;
import org.bson.types.ObjectId;

import java.util.Set;

@Serdeable
@MappedEntity(value = "movies")
public record Movie(
        @Id
        @GeneratedValue
        ObjectId id,
        @Nullable
        String title,
        @Nullable
        @Relation(value = Relation.Kind.ONE_TO_MANY) //tried with mappedBy = "movies"
        Set<Movie> next
) {

}

