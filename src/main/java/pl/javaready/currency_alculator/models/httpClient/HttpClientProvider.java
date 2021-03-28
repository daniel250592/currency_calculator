package pl.javaready.currency_alculator.models.httpClient;

import lombok.Getter;
import org.apache.http.config.SocketConfig;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.stereotype.Component;

@Getter
@Component
public class HttpClientProvider {

    private final CloseableHttpClient httpClient;

    public HttpClientProvider() {
        this.httpClient = HttpClientBuilder.create()
                .setDefaultSocketConfig(SocketConfig.custom()
                        .setSoTimeout(1000)
                        .build())
                .build();
    }
}
