package com.makuch.simplemarkethandler.prices.core.inbound;

import com.makuch.simplemarkethandler.prices.core.domain.Price;

import java.util.List;
import java.util.Optional;

public interface PriceRepository {
    Optional<Price> findById(Long id);
    void saveAll(List<Price> prices);
}
