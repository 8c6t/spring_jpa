package com.hachicore.demospringdata;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.scheduling.annotation.Async;
import org.springframework.util.concurrent.ListenableFuture;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    @Async
    // Future<List<Comment>> findByCommentContainsIgnoreCase(String keyword, Pageable pageable);
    ListenableFuture<List<Comment>> findByCommentContainsIgnoreCase(String keyword, Pageable pageable);

}
