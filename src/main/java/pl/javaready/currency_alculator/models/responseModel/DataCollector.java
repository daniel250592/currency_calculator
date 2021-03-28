package pl.javaready.currency_alculator.models.responseModel;

import com.google.gson.Gson;
import org.springframework.stereotype.Component;
import pl.javaready.currency_alculator.models.responseModel.responseModelAB.ResponseModelAB;
import pl.javaready.currency_alculator.models.responseModel.responseModelC.ResponseModelC;

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

        String stringPattern = "currency";

        String[] split = response.split(stringPattern);

        for (int i = 1; i < split.length; i++) {
            split[i] = "{\"currency" + split[i].substring(0, split[i].length() - 3);
            ResponseModelAB responseModel = gson.fromJson(split[i], ResponseModelAB.class);
            list.add(responseModel);
        }
        return list;
    }

    private List<ResponseModelC> getResponseModelC(String response, Gson gson) {
        List<ResponseModelC> list = new ArrayList<>();
        String stringPattern = "currency";

        String[] split = response.split(stringPattern);

        for (int i = 1; i < split.length; i++) {
            split[i] = "{\"currency" + split[i].substring(0, split[i].length() - 3);
            ResponseModelC responseModel = gson.fromJson(split[i], ResponseModelC.class);
            list.add(responseModel);
        }
        return list;
    }
}
