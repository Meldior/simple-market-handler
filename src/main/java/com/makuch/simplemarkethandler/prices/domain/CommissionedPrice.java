package com.makuch.simplemarkethandler.prices.domain;

import lombok.Builder;
import lombok.RequiredArgsConstructor;

@Builder
@RequiredArgsConstructor
public class CommissionedPrice {
    private final Long id;
    private final String instrumentName;
    private final Double bid;
    private final Double ask;
}
