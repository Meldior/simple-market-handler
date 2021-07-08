package com.makuch.simplemarkethandler.prices.infrastructure.web;

import com.makuch.simplemarkethandler.prices.core.domain.CommissionedPrice;
import com.makuch.simplemarkethandler.prices.core.domain.Price;
import com.makuch.simplemarkethandler.prices.core.inbound.PriceRepository;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.Optional;

@SpringBootTest
public class TestPriceController {
    @Autowired
    PriceRepository priceRepository;
    @Autowired
    PriceController priceController;

    @Test
    void test_PriceControllerCalledWithPriceInRepo_ControllerReturnsCommissionedPrice(){
        //given
        Price existingPrice = Price.builder()
                                .id(1L)
                                .instrumentName("EUR/USD")
                                .bid(1.1000)
                                .ask(1.2000)
                                .reportedAt(LocalDateTime.now())
                                .build();
        priceRepository.saveAll(Lists.newArrayList(existingPrice));

        //when
        Optional<CommissionedPrice> commissionedPriceOptional = priceController.getCommissionedPrice(existingPrice.getId());

        //then
        assert commissionedPriceOptional.isPresent();
        CommissionedPrice commissionedPrice = commissionedPriceOptional.get();
        assert commissionedPrice.getBid() == existingPrice.getBid() - existingPrice.getBid() * 0.001;
        assert commissionedPrice.getAsk() == existingPrice.getAsk() + existingPrice.getAsk() * 0.001;
    }
}
