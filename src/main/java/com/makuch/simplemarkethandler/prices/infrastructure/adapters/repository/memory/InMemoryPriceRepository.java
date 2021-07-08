package com.makuch.simplemarkethandler.prices.infrastructure.adapters.repository.memory;

import com.makuch.simplemarkethandler.prices.core.domain.Price;
import com.makuch.simplemarkethandler.prices.core.inbound.PriceRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class InMemoryPriceRepository implements PriceRepository {
    Map<Long, Price> priceMap = new HashMap<Long, Price>();

    @Override
    public Optional<Price> findById(Long id) {
        return Optional.ofNullable(priceMap.get(id));
    }

    @Override
    public void saveAll(List<Price> prices) {
        prices.forEach(price -> priceMap.put(price.getId(), price));
    }
}
