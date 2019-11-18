package com.hachicore.demospringdata;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

import java.io.Serializable;
import java.util.List;

@NoRepositoryBean
public interface MyRepository<T, Id extends Serializable> extends Repository<T, Id> {

    <E extends T> E save(@NonNull T comment);

    List<T> findAll();

    Long count();

    // <E extends T> Optional<T> findById(Id id);

    @Nullable
    <E extends T> E findById(Id id);

}
