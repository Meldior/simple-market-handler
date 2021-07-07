package com.makuch.simplemarkethandler.prices.subscriber;

import com.makuch.simplemarkethandler.prices.domain.PriceService;

import java.util.List;

public class CsvPriceDataSubscriber implements PriceDataSubscriber{
    PriceDataParser priceDataParser = new CsvPriceDataParser();
    PriceService priceService;

    @Override
    public void onMessage(String message) {
        List<PriceData> newPrices = priceDataParser.parseMessage(message);
        priceService.updatePrices(newPrices);
    }
}
