package com.hachicore.demospringdata;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
@RequiredArgsConstructor
public class JpaRunner implements ApplicationRunner {

    private final PostRepository postRepository;
    private final Hachicore hachicore;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Post post = new Post();
        post.setTitle("Spring");

        Comment comment = new Comment();
        comment.setComment("hello");

        postRepository.save(post);
    }

}
