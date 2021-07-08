package com.makuch.simplemarkethandler.prices.core.outbound;

import com.makuch.simplemarkethandler.prices.core.domain.CommissionedPrice;

public interface PriceDataProvider {
    CommissionedPrice getCommissionedPrice(long id);
}
