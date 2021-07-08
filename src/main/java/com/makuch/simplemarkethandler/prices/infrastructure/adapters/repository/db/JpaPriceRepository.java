package com.makuch.simplemarkethandler.prices.infrastructure.adapters.repository.db;

import org.springframework.data.jpa.repository.JpaRepository;

interface JpaPriceRepository extends JpaRepository<JpaPrice, Long> {
}
