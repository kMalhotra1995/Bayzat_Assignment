package com.curr.Currencytracker.repository;

import com.curr.Currencytracker.entity.Currency;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CurrencyRepository extends JpaRepository<Currency, Long> {
}
