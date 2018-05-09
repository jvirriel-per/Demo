package com.jvirriel.ui.service;

import com.jvirriel.exception.ResponseErrorHandler;
import com.jvirriel.ui.resttemplate.RequestStandard;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.jvirriel.constants.GeneralConstants.*;

public abstract class AbstractService {
    protected MultiValueMap<String, Object> params;
    protected RequestStandard requestStandard;
    protected RestTemplate restTemplate;

    public AbstractService() {
        requestStandard = new RequestStandard();

        List<HttpMessageConverter<?>> messageConverters = new ArrayList<>();

        this.restTemplate = new RestTemplate();
        this.restTemplate.setErrorHandler(new ResponseErrorHandler());

        messageConverters.add(new MappingJackson2HttpMessageConverter());

        this.restTemplate.setMessageConverters(messageConverters);
    }

    protected Map<String, String> buildHeader(String search, String orderBy, String page, String size) {
        return new HashMap<String, String>() {
            {
                put(SEARCH_PARAM_STRING, search);
                put(ORDER_BY_PARAM_STRING, orderBy);
                put(PAGE_PARAM_STRING, page);
                put(SIZE_PARAM_STRING, size);
            }
        };
    }
}
