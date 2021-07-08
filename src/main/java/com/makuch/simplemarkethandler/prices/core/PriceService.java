package com.makuch.simplemarkethandler.prices.core;

import com.makuch.simplemarkethandler.prices.core.domain.CommissionedPrice;
import com.makuch.simplemarkethandler.prices.core.domain.Price;
import com.makuch.simplemarkethandler.prices.core.inbound.PriceDataParser;
import com.makuch.simplemarkethandler.prices.core.inbound.PriceRepository;
import com.makuch.simplemarkethandler.prices.core.outbound.PriceDataProvider;
import com.makuch.simplemarkethandler.prices.core.outbound.PriceDataSubscriber;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class PriceService implements PriceDataSubscriber, PriceDataProvider {
    private final PriceRepository priceRepository;
    private final PriceDataParser priceDataParser;
    private final double commission = 0.001;


    @Override
    public void onMessage(String message) {
        List<Price> newPrices = priceDataParser.parseMessage(message);
        updatePrices(newPrices);
    }

    @Override
    public CommissionedPrice getCommissionedPrice(long id){
        Price price = priceRepository.findById(id);
        final double newAsk = price.getAsk() + price.getAsk() * commission;
        final double newBid = price.getBid() - price.getBid() * commission;
        return CommissionedPrice
                .builder()
                .id(price.getId())
                .ask(newAsk)
                .bid(newBid)
                .instrumentName(price.getInstrumentName())
                .build();
    }

    private void updatePrices(List<Price> newData){
        priceRepository.saveAll(newData);
    }
}
