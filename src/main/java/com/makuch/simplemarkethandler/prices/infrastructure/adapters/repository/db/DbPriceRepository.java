package com.makuch.simplemarkethandler.prices.infrastructure.adapters.repository.db;

import com.makuch.simplemarkethandler.prices.core.domain.Price;
import com.makuch.simplemarkethandler.prices.core.inbound.PriceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Repository
class DbPriceRepository implements PriceRepository {
    private final JpaPriceRepository jpaPriceRepository;

    @Override
    public Optional<Price> findById(Long id) {
        return jpaPriceRepository.findById(id)
                .map(DbPriceRepository::toDomain);
    }

    @Override
    public void saveAll(List<Price> prices) {
        List<JpaPrice> jpaPrices = prices.stream()
                .map(JpaPrice::fromDomain)
                .collect(Collectors.toList());
        jpaPriceRepository.saveAll(jpaPrices);
    }

    private static Price toDomain(JpaPrice jpaPrice){
        return new Price(
                jpaPrice.getId(),
                jpaPrice.getInstrumentName(),
                jpaPrice.getBid(),
                jpaPrice.getAsk(),
                jpaPrice.getReportedAt()
        );
    }
}
