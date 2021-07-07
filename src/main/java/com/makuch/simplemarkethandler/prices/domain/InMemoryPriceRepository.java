package com.makuch.simplemarkethandler.prices.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryPriceRepository implements PriceRepository{
    Map<Long, Price> priceMap = new HashMap<Long, Price>();

    @Override
    public Price findById(Long id) {
        return priceMap.get(id);
    }

    @Override
    public void saveAll(List<Price> prices) {
        prices.forEach(price -> priceMap.put(price.getId(), price));
    }
}
