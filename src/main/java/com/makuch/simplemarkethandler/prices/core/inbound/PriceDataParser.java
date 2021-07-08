package com.makuch.simplemarkethandler.prices.core.inbound;

import com.makuch.simplemarkethandler.prices.core.domain.Price;

import java.util.List;

public interface PriceDataParser {
    List<Price> parseMessage(String message);
}
