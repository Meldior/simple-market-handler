package com.makuch.simplemarkethandler.prices.subscriber;

import java.util.Map;

public interface PriceDataSubscriber {
    public void onMessage(String message);
}
