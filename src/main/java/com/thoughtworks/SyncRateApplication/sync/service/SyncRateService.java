package com.thoughtworks.SyncRateApplication.sync.service;

import com.thoughtworks.SyncRateApplication.domain.Rate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class SyncRateService {
    @Autowired
    private RestTemplate restTemplate;

    //web service resources endpoints
    private final String GET_RATE_BY_HOTEL = "http://localhost:8090/get_rates/";


    public List<Rate> findRates(String hotel_code) {
       return Arrays.asList(restTemplate.getForObject(GET_RATE_BY_HOTEL + "/" + hotel_code, Rate[].class));
    }

}
