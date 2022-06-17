package com.oliver.flights.controller;

import com.oliver.flights.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.Map;

@RestController
public class ItemController {

    @Autowired
    ItemService itemService;

    @GetMapping("/answered")
    public Map<String, Integer> countAnswered() {
         return itemService.countAnswered();
    }

    @GetMapping("/reputation")
    public Integer highestReputation() {
        return itemService.highestReputation();
    }

    @GetMapping("/view")
    public Integer lessView() {
        return itemService.lessViews();
    }

    @GetMapping("/dates")
    public Map<String, Date> getRecentAndOldDates() {
        return itemService.getRecentAndOldDates();
    }
}
