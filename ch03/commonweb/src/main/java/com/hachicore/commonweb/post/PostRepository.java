package com.hachicore.commonweb.post;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {

    List<Post> findByTitleStartsWith(String title);

    @Query(value = "SELECT p from #{#entityName} p WHERE p.title = :title")
    // @Query(value = "SELECT p, p.title AS pTitle from Post p WHERE p.title = ?1")
    List<Post> findByTitle(@Param("title") String keyword, Sort sort);

}
