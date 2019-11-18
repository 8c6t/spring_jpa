package com.hachicore.demospringdata;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CommentRepositoryTest {

    @Autowired
    CommentRepository commentRepository;

    @Test
    public void crud() throws Exception {
//      Optional<Comment> byId = commentRepository.findById(100L);
//      assertThat(byId).isEmpty();
//      Comment comment = byId.orElseThrow(IllegalArgumentException::new);

//      List<Comment> comments = commentRepository.findAll();
//      assertThat(comments).isEmpty();

        commentRepository.save(null);
    }

}