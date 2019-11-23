package com.hachicore.commonweb.post;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Getter @Setter
@Entity
public class Post {

    @Id
    private Long id;

    private String title;

    @Temporal(TemporalType.TIMESTAMP)
    private Date created;

}
