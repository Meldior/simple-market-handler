package com.makuch.simplemarkethandler.prices.infrastructure.adapters.repository.db;

import com.makuch.simplemarkethandler.prices.core.domain.Price;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Builder
@RequiredArgsConstructor
@NoArgsConstructor(force = true)
@Entity
@Table(name = "prices")
class JpaPrice {
    @Id
    private final Long id;

    @Column(nullable = false)
    private final String instrumentName;

    @Column(nullable = false)
    private final Double bid;

    @Column(nullable = false)
    private final Double ask;

    @Column(nullable = false)
    private final LocalDateTime reportedAt;

    public static JpaPrice fromDomain(Price price){
        return new JpaPrice(
                price.getId(),
                price.getInstrumentName(),
                price.getBid(),
                price.getAsk(),
                price.getReportedAt()
        );
    }
}
