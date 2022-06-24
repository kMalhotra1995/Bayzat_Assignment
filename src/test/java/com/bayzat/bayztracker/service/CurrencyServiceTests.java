package com.bayzat.bayztracker.service;

import com.bayzat.bayztracker.entity.Currency;
import com.bayzat.bayztracker.repository.AdminRepository;
import com.bayzat.bayztracker.repository.BaseUserRepository;
import com.bayzat.bayztracker.repository.CurrencyRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CurrencyServiceTests {

    @Mock
    CurrencyRepository currencyRepository;

    @Mock
    BaseUserRepository baseUserRepository;

    @Mock
    AdminRepository adminRepository;

    @InjectMocks
    private CurrencyServiceImpl currencyService;

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testSaveCurrency(){
        Currency c1 = new Currency();
        c1.setId(1L);
        c1.setName("Dollar");
        c1.setSymbol("DLR");
        c1.setEnabled(true);
        c1.setCurrentPrice(1.00);

        when(currencyRepository.save(c1)).thenReturn(c1);

        Currency c2 = currencyService.saveCurrency(c1);
        assertThat(c2.getName()).isEqualToIgnoringCase("Dollar");
    }

    @Test
    public void testValidateCurrency(){
        assertThat(currencyService.validateCurrency("ETH")).isFalse();
        assertThat(currencyService.validateCurrency("DLR")).isTrue();
    }

    @Test
    public void testGetCurrency(){
        Currency c1 = new Currency();
        c1.setId(1L);
        c1.setName("Dollar");
        c1.setSymbol("DLR");
        c1.setEnabled(true);
        c1.setCurrentPrice(1.00);

        when(currencyRepository.findById(1L)).thenReturn(Optional.of(c1));
        assertThat(currencyService.getCurrency(1L)).isTrue();
    }


}
