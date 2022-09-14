package restapi;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONObject;
import restapi.objects.UserInfo;

import java.io.IOException;
import java.util.HashMap;

public class ReadData extends Datas {

    private static HashMap<String, UserInfo> dataMap;
    private static JSONObject testData;

    public static void readTestData() {

        try {
            objectMapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            dataMap = new HashMap<>();
            String jsonTemp = objectMapper.readTree(readJsonData()).get("newUserInformation").toString();
            dataMap = objectMapper.readValue(jsonTemp, new TypeReference<HashMap<String, UserInfo>>() {
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static JSONObject  getTestData(String filter) {

        if (dataMap == null)
            readTestData();
        testData = new JSONObject(dataMap.get(filter));
        return testData;
    }

    public static JSONObject getTestData() {
        return testData;
    }

    public static void setTestData(JSONObject testData) {
        ReadData.testData = testData;
    }
}
