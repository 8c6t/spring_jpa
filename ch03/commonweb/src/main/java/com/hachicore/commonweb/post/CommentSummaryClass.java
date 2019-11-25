package com.hachicore.commonweb.post;

import lombok.Value;

@Value
public class CommentSummaryClass {

    private String comment;
    private int up;
    private int down;

    public String getVotes() {
        return getUp() + " " + getDown();
    }

}
