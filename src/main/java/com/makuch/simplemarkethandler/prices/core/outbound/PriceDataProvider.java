package com.makuch.simplemarkethandler.prices.core.outbound;

import com.makuch.simplemarkethandler.prices.core.domain.CommissionedPrice;

import java.util.Optional;

public interface PriceDataProvider {
    Optional<CommissionedPrice> getCommissionedPrice(long id);
}
