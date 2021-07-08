package com.makuch.simplemarkethandler.prices.core;

import com.makuch.simplemarkethandler.prices.core.domain.CommissionedPrice;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;


@SpringBootTest
public class TestPriceService {
    @Autowired
    PriceService priceService;

    @Test
    void test_OnMessageCalledWithMessage_CommissionedPricesCanBeRetrievedFromService(){
        //given
        String message = "106, EUR/USD, 1.1000,1.2000,01-06-2020 12:01:01:001\n" +
                "107, EUR/JPY, 119.60,119.90,01-06-2020 12:01:02:002\n" +
                "108, GBP/USD, 1.2500,1.2560,01-06-2020 12:01:02:002\n";

        //when
        priceService.onMessage(message);

        //then
        final double commission = 0.001;
        Optional<CommissionedPrice> priceOptional = priceService.getCommissionedPrice(107L);
        assert priceOptional.isPresent();
        CommissionedPrice price = priceOptional.get();
        assert price.getInstrumentName().equals("EUR/JPY");
        assert price.getBid() == 119.60 - 119.60 * commission;
        assert price.getAsk() == 119.90 + 119.90 * commission;
    }
}
