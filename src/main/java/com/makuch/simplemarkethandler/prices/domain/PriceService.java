package com.makuch.simplemarkethandler.prices.domain;
import com.makuch.simplemarkethandler.prices.subscriber.PriceData;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class PriceService {
    private final PriceRepository priceRepository;
    private static final double commission = 0.001;


    public void updatePrices(List<PriceData> newData){
        List<Price> updatedPrices = newData.stream()
                .map(Price::fromPriceData)
                .collect(Collectors.toList());
        priceRepository.saveAll(updatedPrices);
    }

    public CommissionedPrice getCommissionedPrice(long id){
        Price price = priceRepository.findById(id);
        final double newAsk = price.getAsk() + price.getAsk() * commission;
        final double newBid = price.getBid() + price.getBid() * commission;
        return CommissionedPrice
                .builder()
                .id(price.getId())
                .ask(newAsk)
                .bid(newBid)
                .instrumentName(price.getInstrumentName())
                .build();
    }
}
