package com.oliver.flights.service;

import com.oliver.flights.domain.Item;
import com.oliver.flights.domain.Owner;
import com.oliver.flights.domain.Question;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class ItemServiceImpl implements ItemService {
    @Value("${url.api}")
    String URL_BASE;

    HttpComponentsClientHttpRequestFactory clientHttpRequestFactory = new HttpComponentsClientHttpRequestFactory(
            HttpClientBuilder.create().build());
    RestTemplate restTemplate = new RestTemplate(clientHttpRequestFactory);

    @Override
    public Map<String, Integer> countAnswered() {
        List<Item> items = getItems();
        long answered = items.stream().filter(item -> item.isAnswered() == true).count();
        long notAnswered = items.stream().filter(item -> item.isAnswered() == false).count();

        Map<String, Integer> answeredMap = new HashMap<>();
        answeredMap.put("answered", (int) answered);
        answeredMap.put("not-answered", (int) notAnswered);
        System.out.println("Questions answered: " + answered);
        System.out.println("Unanswered questions: " + notAnswered);
        return answeredMap;
    }

    @Override
    public Integer highestReputation() {
        int reputation = 0;
        List<Owner> owners = getItems().stream().map(item -> item.getOwner()).collect(Collectors.toList());
        List<Integer> reputations = owners.stream().map(owner -> owner.getReputation()).collect(Collectors.toList());
        for (Integer r : reputations) {
            if (r != null) {
                reputation = r > reputation ? r : reputation;
            }
        }

        System.out.println("Highest Reputation: " + reputation);

        return reputation;
    }


    @Override
    public Integer lessViews() {
        List<Integer> views = getItems().stream().map(item -> item.getViewCount()).collect(Collectors.toList());
        Integer view = Collections.min(views);
        System.out.println("Video with fewer views: " + view);
        return view;
    }

    @Override
    public Map<String, Date> getRecentAndOldDates() {
        List<Date> dates = getItems().stream().map(item -> item.getCreationDate()).collect(Collectors.toList());
        Map<String, Date> dateMap = new HashMap<>();
        dateMap.put("recentDate", Collections.max(dates));
        dateMap.put("oldDate", Collections.min(dates));

        System.out.println("Most recent question: " + Collections.max(dates));
        System.out.println("Older question: " + Collections.min(dates));

        return dateMap;
    }


    private List<Item> getItems() {
        Question result = restTemplate.getForObject(URL_BASE, Question.class);
        return Arrays.stream(result.getItems())
                .collect(Collectors.toList());
    }
}
