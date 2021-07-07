package com.makuch.simplemarkethandler.prices.web;

import com.makuch.simplemarkethandler.prices.domain.CommissionedPrice;
import com.makuch.simplemarkethandler.prices.domain.PriceService;
import lombok.RequiredArgsConstructor;

// This is where the REST endpoint would be located.
@RequiredArgsConstructor
public class PriceController {
    private final PriceService priceService;

    CommissionedPrice getCommissionedPrice(long id){
        return priceService.getCommissionedPrice(id);
    }
}

