package com.jvirriel.demo.backend.configuration.security.lobby;

import com.pt.util.property.PropertyUtil;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/menu")
public class LobbyController {
    @GetMapping("/lobby")
    public String lobby(@RequestHeader(value="userToken") String userToken,
                        @RequestHeader(value="level") String level,
                        @RequestHeader(value="appcod") String appcod,
                        @RequestHeader(value="type") String type,
                        @RequestHeader(value="appcodOrigin") String appcodOrigin){
        return getMenu(userToken,level,appcod,type, PropertyUtil.getProperty("baseUrlSecurity")+"security/api/v1/tree/lobby");
    }

    @GetMapping("/main")
    public String mainMenu(@RequestHeader(value="userToken") String userToken,
                           @RequestHeader(value="level") String level,
                           @RequestHeader(value="appcod") String appcod,
                           @RequestHeader(value="type") String type,
                           @RequestHeader(value="appcodOrigin") String appcodOrigin){
        return getMenu(userToken,level,appcod,type, PropertyUtil.getProperty("baseUrlSecurity")+"security/api/v1/tree/menu/main");
    }

    @GetMapping("/toolbar")
    public String toolbar(@RequestHeader(value="userToken") String userToken,
                          @RequestHeader(value="level") String level,
                          @RequestHeader(value="appcod") String appcod,
                          @RequestHeader(value="type") String type,
                          @RequestHeader(value="appcodOrigin") String appcodOrigin){

        return getMenu(userToken,level,appcod,type, PropertyUtil.getProperty("baseUrlSecurity")+"security/api/v1/tree/menu/action");
    }

    @GetMapping("/header")
    public String menuHeader(@RequestHeader(value="userToken") String userToken,
                             @RequestHeader(value="level") String level,
                             @RequestHeader(value="appcod") String appcod,
                             @RequestHeader(value="type") String type,
                             @RequestHeader(value="appcodOrigin") String appcodOrigin){

        return getMenu(userToken,level,appcod,type, PropertyUtil.getProperty("baseUrlSecurity")+"security/api/v1/tree/menu/header");
    }

    private String getMenu(String userToken, String level, String appcod, String type, String url){
        ResponseEntity<String> responseEntity = null;

        try {
            HttpHeaders headersRequest = new HttpHeaders();
            headersRequest.set("userToken", userToken);
            headersRequest.set("level", level);
            headersRequest.set("appcod", appcod);
            headersRequest.set("type", type);
            headersRequest.set("appToken", PropertyUtil.getProperty("appToken"));

            HttpEntity<?> httpEntity = new HttpEntity<>(headersRequest);

            RestTemplate restTemplate = new RestTemplate();
            responseEntity = restTemplate.exchange(
                    url, HttpMethod.GET, httpEntity, String.class);
        }
        catch (final HttpClientErrorException e) {
            e.getStackTrace();
        }

        return responseEntity.getBody();
    }
}