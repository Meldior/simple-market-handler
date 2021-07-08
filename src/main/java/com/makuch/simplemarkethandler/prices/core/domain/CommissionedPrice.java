package com.makuch.simplemarkethandler.prices.core.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Builder
@Getter
@RequiredArgsConstructor
public class CommissionedPrice {
    private final Long id;
    private final String instrumentName;
    private final Double bid;
    private final Double ask;
}
