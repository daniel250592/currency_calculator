package pl.javaready.currency_alculator.models.responseModel.responseModelAB;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.javaready.currency_alculator.models.responseModel.ResponseModel;

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


