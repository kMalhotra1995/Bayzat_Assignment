package com.curr.Currencytracker.service;

import com.curr.Currencytracker.entity.Alert;
import com.curr.Currencytracker.enums.AlertStatus;
import com.curr.Currencytracker.exception.UnsupportedCurrencyCreationException;
import com.curr.Currencytracker.repository.AlertRepository;
import com.curr.Currencytracker.repository.BaseUserRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.Instant;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AlertServiceTests {

    @Mock
    private BaseUserRepository baseUserRepository;

    @Mock
    private AlertRepository alertRepository;

    @Mock
    private CurrencyService currencyService;

    @InjectMocks
    private AlertServiceImpl alertService;

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testSave() throws UnsupportedCurrencyCreationException {
        Alert a1 = new Alert();
        a1.setId(1L);
        a1.setStatus(AlertStatus.NEW);
        a1.setTargetPrice(10.0);
        a1.setCurrency("Dollar");
        a1.setCreatedAt(Instant.now());

        when(alertRepository.saveAndFlush(a1)).thenReturn(a1);
        when(currencyService.validateCurrency("Dollar")).thenReturn(true);
        Assertions.assertThat(alertService.save(a1)).isEqualTo(a1);
    }

    @Test
    public void testUpdate() throws Exception {
        Alert a1 = new Alert();
        a1.setId(1L);
        a1.setStatus(AlertStatus.NEW);
        a1.setTargetPrice(10.0);
        a1.setCurrency("Dollar");
        a1.setCreatedAt(Instant.now());

        when(alertRepository.saveAndFlush(a1)).thenReturn(a1);
        when(alertRepository.findById(a1.getId())).thenReturn(Optional.of(a1));

        when(currencyService.validateCurrency("Dollar")).thenReturn(true);
        Assertions.assertThat(alertService.update(a1)).isEqualTo(a1);
    }


    @Test
    public void testCancel() throws Exception {
        Alert a1 = new Alert();
        a1.setId(1L);
        a1.setStatus(AlertStatus.NEW);
        a1.setTargetPrice(10.0);
        a1.setCurrency("Dollar");
        a1.setCreatedAt(Instant.now());

        when(alertRepository.saveAndFlush(a1)).thenReturn(a1);
        when(alertRepository.findById(a1.getId())).thenReturn(Optional.of(a1));
        Assertions.assertThat(alertService.cancel(1L)).isEqualTo(a1);
    }
}
