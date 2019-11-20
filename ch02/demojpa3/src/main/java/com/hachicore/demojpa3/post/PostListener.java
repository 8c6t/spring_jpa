package com.hachicore.demojpa3.post;

import org.springframework.context.event.EventListener;

// public class PostListener implements ApplicationListener<PostPublishedEvent> {
public class PostListener {

    // @Override
    @EventListener
    public void onApplicationEvent(PostPublishedEvent event) {
        System.out.println("--------------------------");
        System.out.println(event.getPost().getTitle() + " is published!!");
        System.out.println("--------------------------");
    }

}
