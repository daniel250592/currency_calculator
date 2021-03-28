package pl.javaready.currency_alculator.services;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.javaready.currency_alculator.models.dtos.CurrencyDto;
import pl.javaready.currency_alculator.models.filters.CollectionFilter;
import pl.javaready.currency_alculator.models.responseModel.responseModelAB.ResponseModelAB;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CurrencyServiceTest {

    @Mock
    private CollectionFilter collectionFilter;

    @InjectMocks
    private CurrencyService currencyService;

    @Test
    void should_return_5() {

        CurrencyDto currencyDto = CurrencyDto.builder()
                .currency("USD")
                .amount(5)
                .currencyTarget("EUR")
                .build();

        when(collectionFilter.findGivenCurrency("USD")).thenReturn(ResponseModelAB.builder()
                .code("USD")
                .mid("5")
                .build());

        when(collectionFilter.findGivenCurrency("EUR")).thenReturn(ResponseModelAB.builder()
                .code("EUR")
                .mid("1")
                .build());

        BigDecimal result = currencyService.convert(currencyDto);

        assertThat(result.doubleValue()).isEqualTo(5.0);
    }

}