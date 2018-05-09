package com.jvirriel.ui.service;

import com.vaadin.ui.UI;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

public class UserService {

    public static Map<Long, String> getUserNames(Long[] id) {

        ResponseEntity<Map<String, Object>> responseEntity;
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.set("appcod", UI.getCurrent().getSession().getAttribute("appCode").toString());
            headers.set("userToken", UI.getCurrent().getSession().getAttribute("userToken").toString());
            headers.set("appcodOrigin", UI.getCurrent().getSession().getAttribute("appCode").toString());

            HttpEntity<?> httpEntity = new HttpEntity<>(id, headers);

            RestTemplate restTemplate = new RestTemplate();
            responseEntity = restTemplate.exchange(
                    UI.getCurrent().getSession().getAttribute("baseUrlBackend").toString() + "/user/usernames",
                    HttpMethod.POST, httpEntity,
                    new ParameterizedTypeReference<Map<String, Object>>() {
                    });

            return parseMap(responseEntity.getBody());
        } catch (final HttpClientErrorException | NullPointerException e) {
            e.printStackTrace();
        }

        return null;
    }

    private static Map<Long, String> parseMap(Map<String, Object> map) {
        Map<Long, String> result = new HashMap<>();

        for (Map.Entry<String, Object> entry : map.entrySet())
            result.put(Long.valueOf(entry.getKey()), (String) entry.getValue());

        return result;
    }

}
