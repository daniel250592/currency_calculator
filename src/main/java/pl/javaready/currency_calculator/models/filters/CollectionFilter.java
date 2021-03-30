package pl.javaready.currency_calculator.models.filters;

import org.springframework.stereotype.Component;
import pl.javaready.currency_calculator.models.responseModel.HttpGetExecutionFasada;
import pl.javaready.currency_calculator.models.responseModel.ResponseModel;

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
            return responseModels.stream().filter(model -> model
                    .getCode()
                    .equals(currency))
                    .findFirst()
                    .orElseThrow(NoSuchElementException::new);

        } catch (
                NoSuchElementException e) {
            try {
                List<? extends ResponseModel> responseModels = httpGetExecutionFasada.getCurrency("B");
                return responseModels.stream().filter(model -> model
                        .getCode()
                        .equals(currency))
                        .findFirst()
                        .orElseThrow(NoSuchElementException::new);
            } catch (NoSuchElementException f) {
                try {
                    List<? extends ResponseModel> responseModels = httpGetExecutionFasada.getCurrency("C");
                    return responseModels.stream().filter(model -> model
                            .getCode()
                            .equals(currency))
                            .findFirst()
                            .orElseThrow(NoSuchElementException::new);

                } catch (NoSuchElementException g) {
                    throw new NoSuchElementException("Brak podanej waluty");
                }
            }
        }
    }
}
