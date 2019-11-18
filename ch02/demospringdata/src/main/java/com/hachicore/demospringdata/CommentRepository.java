package com.hachicore.demospringdata;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

// @RepositoryDefinition(domainClass = Comment.class, idClass = Long.class)
public interface CommentRepository extends MyRepository<Comment, Long> {

    // @Query(value = "SELECT c FROM Comment c", nativeQuery = true)
    List<Comment> findByCommentContains(String keyword);

    Page<Comment> findByLikeCountGreaterThanAndPost(int likeCount, Post post, Pageable pageable);

}
