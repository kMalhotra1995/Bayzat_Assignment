package com.bayzat.bayztracker.repository;

import com.bayzat.bayztracker.entity.Currency;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CurrencyRepository extends JpaRepository<Currency, Long> {
}
