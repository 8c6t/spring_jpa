package com.hachicore.demospringdata;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CommentRepositoryTest {

    @Autowired
    CommentRepository commentRepository;

    @Test
    public void crud() throws Exception {
      // given
      Comment comment = new Comment();
      comment.setComment("Hello Comment");
      commentRepository.save(comment);

      // when
      List<Comment> all = commentRepository.findAll();

      // then
      assertThat(all.size()).isEqualTo(1);

      // when
      Long count = commentRepository.count();

      // then
      assertThat(count).isEqualTo(1);
    }

}