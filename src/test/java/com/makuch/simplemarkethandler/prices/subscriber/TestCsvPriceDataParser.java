package com.makuch.simplemarkethandler.prices.subscriber;

import org.junit.jupiter.api.Test;

import java.time.Month;
import java.util.*;
import java.util.stream.Collectors;

public class TestCsvPriceDataParser {

    @Test
    void testParseMessageReturnsMapWithProperlyLoadedPriceData(){
        //given
        PriceDataParser priceDataParser = new CsvPriceDataParser();

        //when
        String message = "106, EUR/USD, 1.1000,1.2000,01-06-2020 12:01:01:001\n" +
                "107, EUR/JPY, 119.60,119.90,01-06-2020 12:01:02:002\n" +
                "108, GBP/USD, 1.2500,1.2560,01-06-2020 12:01:02:002\n";
        List<PriceData> priceData = priceDataParser.parseMessage(message);

        //then
        assert priceData.size() == 3;
        Set<Long> expectedIds = new HashSet<>(Arrays.asList(106L, 107L, 108L));
        Set<Long> retrievedIds = priceData.stream().map(pd -> pd.getId()).collect(Collectors.toSet());
        assert retrievedIds.equals(expectedIds);
        PriceData retrievedPriceData = priceData.get(0);
        assert retrievedPriceData.getInstrumentName().equals("EUR/USD");
        assert retrievedPriceData.getBid().equals(1.1);
        assert retrievedPriceData.getAsk().equals(1.2);
        assert retrievedPriceData.getReportedAt().getDayOfMonth() == 1;
        assert retrievedPriceData.getReportedAt().getMonth() == Month.JUNE;
        assert retrievedPriceData.getReportedAt().getYear() == 2020;
        assert retrievedPriceData.getReportedAt().getHour() == 12;
        assert retrievedPriceData.getReportedAt().getMinute() == 1;
        assert retrievedPriceData.getReportedAt().getSecond() == 1;
    }
}
