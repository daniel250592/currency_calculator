package pl.javaready.currency_calculator.models.responseModel.responseModelAB;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import pl.javaready.currency_calculator.models.responseModel.ResponseModel;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResponseModelAB extends ResponseModel {

    private String currency;
    private String code;
    private String mid;

    @Override
    public String getCurrency() {
        return currency;
    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getMid() {
        return mid;
    }
}


