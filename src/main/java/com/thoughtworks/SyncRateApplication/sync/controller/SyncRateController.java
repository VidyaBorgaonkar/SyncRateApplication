package com.thoughtworks.SyncRateApplication.sync.controller;

import com.thoughtworks.SyncRateApplication.domain.Rate;
import com.thoughtworks.SyncRateApplication.sync.service.SyncRateService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SyncRateController {

    private SyncRateService rateService;

    public SyncRateController(SyncRateService rateService) {
        this.rateService = rateService;
    }

    @GetMapping("/sync/rates/{hotel_code}")
    public List<Rate> getRates(@PathVariable String hotel_code) throws InterruptedException {
        //Thread.sleep(300);
        return rateService.findRates(hotel_code);
    }


}
