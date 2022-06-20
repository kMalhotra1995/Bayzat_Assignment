package com.bayzat.bayztracker.repository;

import com.bayzat.bayztracker.entity.CurrencyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CurrencyEntityRepo extends JpaRepository<CurrencyEntity, Integer> {
}
