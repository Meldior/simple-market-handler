package com.makuch.simplemarkethandler.prices.domain;

import com.makuch.simplemarkethandler.prices.subscriber.PriceData;
import lombok.Getter;
import lombok.RequiredArgsConstructor;


import java.time.LocalDateTime;

@Getter
@RequiredArgsConstructor
public class Price {

    private final Long id;
    private final String instrumentName;
    private final Double bid;
    private final Double ask;
    private final LocalDateTime reportedAt;

    public static Price fromJpaPrice(JpaPrice jpaPrice){
        return new Price(
                jpaPrice.getId(),
                jpaPrice.getInstrumentName(),
                jpaPrice.getBid(),
                jpaPrice.getAsk(),
                jpaPrice.getReportedAt()
        );
    }
    public static Price fromPriceData(PriceData priceData){
        return new Price(
                priceData.getId(),
                priceData.getInstrumentName(),
                priceData.getBid(),
                priceData.getAsk(),
                priceData.getReportedAt()
        );
    }
}
