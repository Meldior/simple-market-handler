package com.makuch.simplemarkethandler.prices.domain;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class PriceRepositoryConfiguration {
    @Bean
    PriceRepository priceRepository(JpaPriceRepository jpaPriceRepository) {
        return new PriceRepositoryImpl(jpaPriceRepository);
    }


    @Bean
    PriceService priceService(PriceRepository priceRepository){
        return new PriceService(priceRepository);
    }
}
