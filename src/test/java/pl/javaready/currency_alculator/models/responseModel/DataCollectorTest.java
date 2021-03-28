package pl.javaready.currency_alculator.models.responseModel;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class DataCollectorTest {

    @Autowired
    private DataCollector dataCollector;

    @Test
    void should_size_3(){
        String response = "[{\"table\":\"A\",\"no\":\"059/A/NBP/2021\",\"effectiveDate\":\"2021-03-26\",\"rates\":[{\"currency\":\"bat (Tajlandia)\",\"code\":\"THB\",\"mid\":0.1265},{\"currency\":\"dolar amerykański\",\"code\":\"USD\",\"mid\":3.9307},{\"currency\":\"dolar australijski\",\"code\":\"AUD\",\"mid\":2.9947}]}]A";

        List<? extends ResponseModel> result = dataCollector.getResponseList(response);

        assertThat(result.size()).isEqualTo(3);
    }
}