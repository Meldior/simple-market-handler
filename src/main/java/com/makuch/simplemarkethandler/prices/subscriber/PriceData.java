package com.makuch.simplemarkethandler.prices.subscriber;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@Builder
@Getter
@RequiredArgsConstructor
public class PriceData {
    private final Long id;
    private final String instrumentName;
    private final Double bid;
    private final Double ask;
    private final LocalDateTime reportedAt;
}
