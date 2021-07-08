package com.makuch.simplemarkethandler.prices.core.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@Getter
@RequiredArgsConstructor
@Builder
public class Price {
    private final Long id;
    private final String instrumentName;
    private final Double bid;
    private final Double ask;
    private final LocalDateTime reportedAt;
}
