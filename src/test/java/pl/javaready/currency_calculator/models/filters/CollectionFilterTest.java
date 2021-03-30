package pl.javaready.currency_calculator.models.filters;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.javaready.currency_calculator.models.responseModel.ResponseModel;
import pl.javaready.currency_calculator.models.responseModel.responseModelAB.ResponseModelAB;

import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@SpringBootTest
class CollectionFilterTest {

    @Autowired
    private CollectionFilter collectionFilter;

    @Test
    void should_check_if_return_is_USD() {
        String code = "USD";
        ResponseModel responseModel = new ResponseModelAB("dolar amerykański", "USD", "0");

        ResponseModel result = collectionFilter.findGivenCurrency(code);

        assertThat(result.getCode()).isEqualTo(code);
    }

    @Test
    void should_throw_NoSuchElementException_when_invalid_code(){
        String code = "WRONG";

        assertThatThrownBy(()->collectionFilter.findGivenCurrency(code))
                .isExactlyInstanceOf(NoSuchElementException.class)
                .hasMessage("Brak podanej waluty")
                .hasNoCause();
    }
}