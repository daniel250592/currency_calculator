package pl.javaready.currency_calculator.models.httpClient;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class HttpRequestExecutor {

    private final HttpClientProvider httpClientProvider;

    public HttpRequestExecutor(HttpClientProvider httpClientProvider) {
        this.httpClientProvider = httpClientProvider;
    }

    private String getUri(String table) {
        return "http://api.nbp.pl/api/exchangerates/tables/" + table + "/?format=json";
    }

    public String executeGet(String table) {
        CloseableHttpClient httpClient = httpClientProvider.getHttpClient();
        try {
            HttpResponse httpResponse = httpClient.execute(new HttpGet(getUri(table)));
            return EntityUtils.toString(httpResponse.getEntity()) + table;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }
}
