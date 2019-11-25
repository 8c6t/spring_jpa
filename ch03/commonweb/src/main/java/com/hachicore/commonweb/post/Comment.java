package com.hachicore.commonweb.post;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

// @NamedEntityGraph(name = "Comment.post", attributeNodes = @NamedAttributeNode("post"))
@Entity
@Getter @Setter
public class Comment {

    @Id @GeneratedValue
    private Long id;

    private String comment;

    private int up;

    private int down;

    private boolean best;

    @ManyToOne(fetch = FetchType.LAZY)
    private Post post;

}
