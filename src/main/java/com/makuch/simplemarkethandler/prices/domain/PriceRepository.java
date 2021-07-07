package com.makuch.simplemarkethandler.prices.domain;

import java.util.List;

public interface PriceRepository {
    Price findById(Long id);
    void saveAll(List<Price> prices);
}
