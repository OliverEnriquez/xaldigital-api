package com.oliver.flights.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import java.util.Date;

@Data
public class Item {

    @JsonProperty("tags")
    private String[] tags;
    @JsonProperty("owner")
    private Owner owner;
    @JsonProperty("is_answered")
    private boolean isAnswered;
    @JsonProperty("view_count")
    private Integer viewCount;
    @JsonProperty("accepted_answer_id")
    private Integer acceptAnswerId;
    @JsonProperty("answer_count")
    private Integer answerCount;
    @JsonProperty("score")
    private Integer score;
    @JsonProperty("last_activity_date")
    private Date lastActivityDate;
    @JsonProperty("creation_date")
    private Date creationDate;
    @JsonProperty("last_edit_date")
    private Date lastEditDate;
    @JsonProperty("question_id")
    private Integer questionId;
    @JsonProperty("content_license")
    private String contentLicense;
    @JsonProperty("link")
    private String link;
    @JsonProperty("title")
    private String title;

}
