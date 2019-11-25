package com.hachicore.commonweb.post;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CommentRepositoryTest {

    @Autowired
    CommentRepository commentRepository;

    @Autowired
    PostRepository postRepository;

    @Test
    public void getComment() throws Exception {
        Post post = new Post();
        post.setTitle("jpa");
        Post savedPost = postRepository.save(post);

        Comment comment = new Comment();
        comment.setComment("spring data jpa projection");
        comment.setUp(10);
        comment.setDown(1);
        comment.setPost(savedPost);
        commentRepository.save(comment);

        commentRepository.findByPost_Id(savedPost.getId(), CommentOnly.class).forEach(c-> {
            System.out.println("============");
            // System.out.println(c.getVotes());
            System.out.println(c.getComment());
        });
    }

    @Test
    public void specs() throws Exception {
        // commentRepository.findAll(CommentSpecs.isBest().and(CommentSpecs.isBest()));
        Page<Comment> page = commentRepository.findAll(CommentSpecs.isBest(), PageRequest.of(0, 10));
    }

    @Test
    public void qbe() throws Exception {
        Comment prove = new Comment();
        prove.setBest(true);

        ExampleMatcher exampleMatcher = ExampleMatcher.matchingAny()
                .withIgnorePaths("up", "down");
        Example<Comment> example = Example.of(prove, exampleMatcher);

        commentRepository.findAll(example);
    }

}
