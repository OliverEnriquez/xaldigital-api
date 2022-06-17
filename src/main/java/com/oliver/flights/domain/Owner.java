package com.oliver.flights.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Owner {

    @JsonProperty("reputation")
    private Integer reputation;
    @JsonProperty("user_id")
    private Integer userId;
    @JsonProperty("user_type")
    private String userType;
    @JsonProperty("accept_rate")
    private Integer acceptRate;
    @JsonProperty("profile_image")
    private String profileImage;
    @JsonProperty("display_name")
    private String displayName;
    @JsonProperty("link")
    private String link;
}
