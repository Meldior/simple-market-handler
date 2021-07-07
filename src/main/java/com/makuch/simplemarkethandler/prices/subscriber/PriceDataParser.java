package com.makuch.simplemarkethandler.prices.subscriber;

import java.util.List;

interface PriceDataParser {
    public List<PriceData> parseMessage(String message);
}
