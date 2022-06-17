package com.oliver.flights.service;

import com.oliver.flights.domain.Item;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface ItemService {
    Map<String, Integer> countAnswered();

    Integer highestReputation();

    Integer lessViews();

    Map<String, Date> getRecentAndOldDates();

}
