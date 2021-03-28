package pl.javaready.currency_alculator.models.dtos;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class CurrencyDto {

    private long amount;
    private String currency;
    private String currencyTarget;
}
