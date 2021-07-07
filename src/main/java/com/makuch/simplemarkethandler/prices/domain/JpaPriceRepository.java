package com.makuch.simplemarkethandler.prices.domain;

import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaPriceRepository extends JpaRepository<JpaPrice, Long> {
}
