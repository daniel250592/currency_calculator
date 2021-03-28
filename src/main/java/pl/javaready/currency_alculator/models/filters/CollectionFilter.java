package pl.javaready.currency_alculator.models.filters;

import org.springframework.stereotype.Component;
import pl.javaready.currency_alculator.models.responseModel.HttpGetExecutionFasada;
import pl.javaready.currency_alculator.models.responseModel.ResponseModel;

import java.util.List;
import java.util.NoSuchElementException;

@Component
public class CollectionFilter {

    private final HttpGetExecutionFasada httpGetExecutionFasada;

    public CollectionFilter(HttpGetExecutionFasada httpGetExecutionFasada) {
        this.httpGetExecutionFasada = httpGetExecutionFasada;
    }

    public ResponseModel findGivenCurrency(String currency) {
        try {
            List<? extends ResponseModel> responseModels = httpGetExecutionFasada.getCurrency("A");
            ResponseModel responseModel = responseModels.stream().filter(model -> model
                    .getCode()
                    .equals(currency))
                    .findFirst()
                    .orElseThrow(NoSuchElementException::new);
            return responseModel;
        } catch (
                NoSuchElementException e) {
            try {
                List<? extends ResponseModel> responseModels = httpGetExecutionFasada.getCurrency("B");
                ResponseModel responseModel = responseModels.stream().filter(model -> model
                        .getCode()
                        .equals(currency))
                        .findFirst()
                        .orElseThrow(NoSuchElementException::new);
                return responseModel;
            } catch (NoSuchElementException f) {
                try {
                    List<? extends ResponseModel> responseModels = httpGetExecutionFasada.getCurrency("C");
                    ResponseModel responseModel = responseModels.stream().filter(model -> model
                            .getCode()
                            .equals(currency))
                            .findFirst()
                            .orElseThrow(NoSuchElementException::new);
                    return responseModel;
                } catch (NoSuchElementException g) {
                    throw new NoSuchElementException("Brak podanej waluty");
                }
            }
        }
    }
}
