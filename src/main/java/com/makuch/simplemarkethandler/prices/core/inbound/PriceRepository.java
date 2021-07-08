package com.makuch.simplemarkethandler.prices.core.inbound;

import com.makuch.simplemarkethandler.prices.core.domain.Price;

import java.util.List;

public interface PriceRepository {
    Price findById(Long id);
    void saveAll(List<Price> prices);
}
