package pl.javaready.currency_alculator.models.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CurrencyDto {

    private long amount;
    private String currency;
    private String currencyTarget;
}
