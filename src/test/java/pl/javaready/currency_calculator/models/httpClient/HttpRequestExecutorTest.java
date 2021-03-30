package pl.javaready.currency_calculator.models.httpClient;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class HttpRequestExecutorTest {

    @Autowired
    private HttpRequestExecutor httpRequestExecutor;

    @Test
    void should_end_with_table() {
        String table = "A";

        String result = httpRequestExecutor.executeGet(table);

        assertThat(result).endsWith(table);
    }
}