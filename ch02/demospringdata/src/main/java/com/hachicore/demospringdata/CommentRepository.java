package com.hachicore.demospringdata;

import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.stream.Stream;

public interface CommentRepository extends MyRepository<Comment, Long> {

    List<Comment> findByCommentContainsIgnoreCaseAndLikeCountGreaterThan(String keyword, int likeCount);
    List<Comment> findByCommentContainsIgnoreCaseOrderByLikeCountDesc(String keyword);
    // Page<Comment> findByCommentContainsIgnoreCase(String keyword, Pageable pageRequest);
    Stream<Comment> findByCommentContainsIgnoreCase(String keyword, Pageable pageRequest);

}
