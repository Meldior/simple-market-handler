package com.makuch.simplemarkethandler.prices.infrastructure.web;

import com.makuch.simplemarkethandler.prices.core.domain.CommissionedPrice;
import com.makuch.simplemarkethandler.prices.core.outbound.PriceDataProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

// This is where the REST endpoint would be located.
@RequiredArgsConstructor
@Component
public class PriceController {
    private final PriceDataProvider priceService;

    Optional<CommissionedPrice> getCommissionedPrice(long id){
        return priceService.getCommissionedPrice(id);
    }
}

