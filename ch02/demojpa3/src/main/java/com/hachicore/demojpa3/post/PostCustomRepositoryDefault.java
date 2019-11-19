package com.hachicore.demojpa3.post;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@Transactional
@RequiredArgsConstructor
public class PostCustomRepositoryDefault implements PostCustomRepository<Post> {

    private final EntityManager em;

    @Override
    public List<Post> findMyPost() {
        System.out.println("custom findMyPost");
        return em.createQuery("SELECT p FROM Post p", Post.class)
                .getResultList();
    }

    @Override
    public void delete(Post entity) {
        System.out.println("custom delete");
        em.remove(entity);
    }
}
