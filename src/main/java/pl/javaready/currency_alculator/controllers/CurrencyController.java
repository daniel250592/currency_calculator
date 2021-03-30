package pl.javaready.currency_alculator.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.javaready.currency_alculator.models.dtos.CurrencyDto;
import pl.javaready.currency_alculator.services.CurrencyService;

import java.math.BigDecimal;

@RestController
@RequestMapping("/check")
public class CurrencyController {

    private final CurrencyService currencyService;

    public CurrencyController(CurrencyService currencyService) {
        this.currencyService = currencyService;
    }

    @PostMapping
    public BigDecimal convertToGivenCurrency(CurrencyDto currencyDto) {
        return currencyService.convert(currencyDto);
    }
}
