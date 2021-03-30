package pl.javaready.currency_calculator.services;

import org.springframework.stereotype.Service;
import pl.javaready.currency_calculator.models.dtos.CurrencyDto;
import pl.javaready.currency_calculator.models.filters.CollectionFilter;
import pl.javaready.currency_calculator.models.responseModel.ResponseModel;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static java.lang.Double.parseDouble;

@Service
public class CurrencyService {

    private final CollectionFilter collectionFilter;

    public CurrencyService(CollectionFilter collectionFilter) {
        this.collectionFilter = collectionFilter;
    }

    public BigDecimal convert(CurrencyDto currencyDto) {
        ResponseModel givenCurrency = collectionFilter.findGivenCurrency(currencyDto.getCurrency());
        ResponseModel targetCurrency = collectionFilter.findGivenCurrency(currencyDto.getCurrencyTarget());

        BigDecimal givenCurrencyBig = BigDecimal.valueOf(parseDouble(givenCurrency.getMid()));
        BigDecimal targetCurrencyBig = BigDecimal.valueOf(parseDouble(targetCurrency.getMid()));


        return givenCurrencyBig.divide(targetCurrencyBig, 2, RoundingMode.CEILING);
    }
}
