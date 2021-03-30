package pl.javaready.currency_calculator.models.responseModel;

import com.google.gson.Gson;
import org.springframework.stereotype.Component;
import pl.javaready.currency_calculator.models.responseModel.responseModelAB.ResponseModelAB;
import pl.javaready.currency_calculator.models.responseModel.responseModelC.ResponseModelC;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataCollector {

    public List<? extends ResponseModel> getResponseList(String response) {
        Gson gson = new Gson();
        if (response.endsWith("C")) {
            return getResponseModelC(response.substring(0, response.length() - 1), gson);
        } else {
            return getResponseModelAB(response.substring(0, response.length() - 1), gson);
        }
    }

    private List<ResponseModelAB> getResponseModelAB(String response, Gson gson) {
        List<ResponseModelAB> list = new ArrayList<>();
        response = response.substring(2, response.length() - 2);

        String stringPattern = "\\{";

        String[] split = response.split(stringPattern);

        for (int i = 1; i < split.length; i++) {
            split[i] = "{" + split[i].substring(0, split[i].length() - 2) + "}";
            ResponseModelAB responseModel = gson.fromJson(split[i], ResponseModelAB.class);
            list.add(responseModel);
        }
        return list;
    }

    private List<ResponseModelC> getResponseModelC(String response, Gson gson) {
        List<ResponseModelC> list = new ArrayList<>();

        response = response.substring(2, response.length() - 2);

        String stringPattern = "\\{";

        String[] split = response.split(stringPattern);

        for (int i = 1; i < split.length; i++) {
            split[i] = "{" + split[i].substring(0, split[i].length() - 2) + "}";
            ResponseModelC responseModel = gson.fromJson(split[i], ResponseModelC.class);
            list.add(responseModel);
        }
        return list;
    }
}
