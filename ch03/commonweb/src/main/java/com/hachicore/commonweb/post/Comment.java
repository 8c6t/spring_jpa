package com.hachicore.commonweb.post;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

// @NamedEntityGraph(name = "Comment.post", attributeNodes = @NamedAttributeNode("post"))
@Entity
@EntityListeners(AuditingEntityListener.class)
@Getter @Setter
public class Comment {

    @Id @GeneratedValue
    private Long id;

    private String comment;

    private int up;

    private int down;

    private boolean best;

    @CreatedDate
    private Date created;

    @LastModifiedDate
    private Date updated;

    @CreatedBy
    @ManyToOne
    private Account createdBy;

    @LastModifiedBy
    @ManyToOne
    private Account updatedBy;

    @ManyToOne(fetch = FetchType.LAZY)
    private Post post;

    @PrePersist
    public void prePersist() {
        System.out.println("Pre Persist is called");
        // this.created = new Date();
    }

}
