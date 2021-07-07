package com.makuch.simplemarkethandler.prices.service;

import com.makuch.simplemarkethandler.prices.domain.InMemoryPriceRepository;
import com.makuch.simplemarkethandler.prices.domain.Price;
import com.makuch.simplemarkethandler.prices.domain.PriceRepository;
import com.makuch.simplemarkethandler.prices.domain.PriceService;
import com.makuch.simplemarkethandler.prices.subscriber.PriceData;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


public class TestPriceService {
    PriceRepository priceRepository = new InMemoryPriceRepository();
    PriceService priceService = new PriceService(priceRepository);


    @Test
    void test_UpdatePricesCalledWithNewData_NewPricesCanBeRetrievedFromRepo(){
        //given
        List<PriceData> newData = new ArrayList<>();
        newData.add(new PriceData(106L, "EUR/USD", 1.1000,1.2000, LocalDateTime.now()));
        newData.add(new PriceData(107L, "EUR/JPY", 119.6,119.9, LocalDateTime.now()));

        //when
        priceService.updatePrices(newData);

        //then
        assert priceRepository.findById(106L) != null;
        assert priceRepository.findById(107L) != null;
    }

    @Test
    void test_UpdatePricesCalledWithPricesInRepo_NewPricesUpdatePricesInRepo(){
        //given
        priceRepository.saveAll(
                Lists.newArrayList(
                        new Price(106L, "EUR/USD", 1.1000,1.2000, LocalDateTime.now()),
                        new Price(107L, "EUR/JPY", 119.6,119.9, LocalDateTime.now())
                )
        );
        List<PriceData> newData = new ArrayList<>();
        newData.add(new PriceData(106L, "EUR/USD", 1.3,1.4, LocalDateTime.now()));
        newData.add(new PriceData(107L, "EUR/JPY", 121.5,123.2, LocalDateTime.now()));

        //when
        priceService.updatePrices(newData);

        //then
        assert priceRepository.findById(106L).getAsk() == 1.4;
        assert priceRepository.findById(106L).getBid() == 1.3;
        assert priceRepository.findById(107L).getBid() == 121.5;
        assert priceRepository.findById(107L).getAsk() == 123.2;
    }

}
