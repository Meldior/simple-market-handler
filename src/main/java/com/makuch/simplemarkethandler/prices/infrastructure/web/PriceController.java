package com.makuch.simplemarkethandler.prices.infrastructure.web;

import com.makuch.simplemarkethandler.prices.core.domain.CommissionedPrice;
import com.makuch.simplemarkethandler.prices.core.outbound.PriceDataProvider;
import lombok.RequiredArgsConstructor;

// This is where the REST endpoint would be located.
@RequiredArgsConstructor
public class PriceController {
    private final PriceDataProvider priceService;

    CommissionedPrice getCommissionedPrice(long id){
        return priceService.getCommissionedPrice(id);
    }
}
