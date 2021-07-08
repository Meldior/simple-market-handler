package com.makuch.simplemarkethandler.prices.infrastructure.config;

import com.makuch.simplemarkethandler.prices.core.PriceService;
import com.makuch.simplemarkethandler.prices.core.inbound.PriceDataParser;
import com.makuch.simplemarkethandler.prices.core.inbound.PriceRepository;
import com.makuch.simplemarkethandler.prices.core.outbound.PriceDataProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class PriceServiceConfig {

    @Bean
    PriceDataProvider priceDataProvider(PriceDataParser dataParser, PriceRepository priceRepository) {
        return new PriceService(priceRepository, dataParser);
    }
}
