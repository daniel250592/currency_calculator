package pl.javaready.currency_alculator.models.responseModel.responseModelC;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.javaready.currency_alculator.models.responseModel.ResponseModel;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResponseModelC extends ResponseModel {

    private String currency;
    private String code;
    private String bid;
    private String ask;

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
        return String.valueOf(Integer.parseInt(bid) + Integer.parseInt(ask));
    }
}
