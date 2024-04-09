package com.spring.mvc.chap05.service;

import com.mysql.cj.xdevapi.JsonString;
import lombok.extern.slf4j.Slf4j;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

@Slf4j
public class WeatherService {






//    if(conn.getResponseCode())


  /*
    // StringBuilder를 String으로 변환
    String jsonString = sb.toString();

    JSONParser parser = new JSONParser();

    // String 객체를 JSON객체로 변경해 줌.
    JSONObject jsonObject = parsor.parse(JsonString);

    // "response"라는 이름의 키에 해당하는 JSON 데이터를 가져옵니다.
    JSONObject response = (JSONObject) jsonObject.get("response");

    // response 안에서 body 키에 해당하는 JSON 데이터를 가져옵니다.
    JSONObject body = (JSONObject) response.get("body");

    // body에서 items를 꺼내세요
    JSONObject items = (JSONObject) body.get("items");

    // item이라는 키를 가진 JSON 데이터를 가져올건데,
    // item 데이터는 여러 값이기 때문에 배열의 문법을 제공하는 객체로 받습니다.
    JSONArray itemArray = (JSONArray) items.get("item");
*/

    // 반복문을 이용해서 객체를 하나씩 취득한 후에 원하는 로직을 작성합니다.
    /*for (Object obj : itemArray) {

        // Object를 JSON객체로 변환
        JSONObject item = (JSONObject) obj;
        // "category" 키에 해당하는 단일 값을 가져옵니다.
        String category = (String) item.get("category");
        // "fcstValue" 키에 해당하는 단일 값을 가져옵니다.
        String fcstValue = (String) item.get("fcstValue");

        if(category.equals("TMX") || category.equals("TMN")) {
            log.info("category: {}, value: {}", category, fcstValue);
        }



    }
*/
}
