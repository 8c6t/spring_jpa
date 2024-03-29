package com.hachicore.commonweb.post;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {

    List<Post> findByTitleStartsWith(String title);

    @Query(value = "SELECT p from #{#entityName} p WHERE p.title = :title")
    // @Query(value = "SELECT p, p.title AS pTitle from Post p WHERE p.title = ?1")
    List<Post> findByTitle(@Param("title") String keyword, Sort sort);

    @Modifying(clearAutomatically = true)
    @Query("UPDATE Post p SET p.title = ?1 WHERE p.id = ?2")
    int updateTitle(String title, Long id);
}
