package com.hachicore.demospringdata;

import org.hibernate.Session;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Component
@Transactional
public class JpaRunner implements ApplicationRunner {

    @PersistenceContext
    EntityManager em;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        // persistence();
        // cascadeInsert();
        Session session = em.unwrap(Session.class);
        Post post = session.get(Post.class, 1L);
        session.delete(post);
    }

    private void cascadeInsert() {
        Post post = new Post();
        post.setTitle("Spring Data JPA");

        Comment comment = new Comment();
        comment.setComment("comment");
        post.addComment(comment);

        Comment comment1 = new Comment();
        comment1.setComment("comment1");
        post.addComment(comment1);

        Session session = em.unwrap(Session.class);
        session.save(post);
    }

    private void persistence() {
        Account account = new Account();
        account.setUsername("rokuthread");
        account.setPassword("hibernate");

        Study study = new Study();
        study.setName("Spring Data JPA");

//        account.getStudies().add(study);
//        study.setOwner(account);

        account.addStudy(study);

        Session session = em.unwrap(Session.class);
        session.save(account);
        session.save(study);

        Account rokuthread = session.load(Account.class, account.getId());
        rokuthread.setUsername("hachicore");
        rokuthread.setUsername("rokuthread2");
        rokuthread.setUsername("rokuthread");
        System.out.println("======================");
        System.out.println(rokuthread.getUsername());
    }

}
