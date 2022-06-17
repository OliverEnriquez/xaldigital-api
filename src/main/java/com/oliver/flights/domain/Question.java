package com.oliver.flights.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Question {
    Item[] items;

    @JsonProperty("has_more")
    boolean hasMore;
    @JsonProperty("quota_max")
    Integer quotaMax;
    @JsonProperty("quota_remaining")
    Integer quotaRemaining;

}
