package pl.javaready.currency_calculator.models.responseModel;

import org.springframework.stereotype.Component;
import pl.javaready.currency_calculator.models.httpClient.HttpRequestExecutor;

import java.util.List;

@Component
public class HttpGetExecutionFasada {

    private final HttpRequestExecutor httpRequestExecutor;
    private final DataCollector dataCollector;

    private HttpGetExecutionFasada(HttpRequestExecutor httpRequestExecutor, DataCollector dataCollector) {
        this.httpRequestExecutor = httpRequestExecutor;
        this.dataCollector = dataCollector;
    }

    public List<? extends ResponseModel> getCurrency(String table) {
        String executeGet = httpRequestExecutor.executeGet(table);
        return dataCollector.getResponseList(executeGet);
    }
}
