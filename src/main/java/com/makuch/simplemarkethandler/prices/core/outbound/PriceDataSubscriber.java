package com.makuch.simplemarkethandler.prices.core.outbound;

import java.util.Map;

public interface PriceDataSubscriber {
    void onMessage(String message);
}
