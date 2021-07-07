package com.makuch.simplemarkethandler.prices.domain;

import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
class PriceRepositoryImpl implements PriceRepository{
    private final JpaPriceRepository jpaPriceRepository;

    @Override
    public Price findById(Long id) {
        return Price.fromJpaPrice(jpaPriceRepository.findById(id).get());
    }

    @Override
    public void saveAll(List<Price> prices) {
        List<JpaPrice> jpaPrices = prices.stream()
                .map(JpaPrice::fromDomain)
                .collect(Collectors.toList());
        jpaPriceRepository.saveAll(jpaPrices);
    }
}
