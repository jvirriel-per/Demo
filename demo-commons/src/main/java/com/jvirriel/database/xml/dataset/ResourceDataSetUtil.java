package com.jvirriel.database.xml.dataset;

import com.jvirriel.cipher.AuthUtility;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public class ResourceDataSetUtil {
    public static DataSetResponse getDataSetResponse(String code, DataSetConfig dataSetConfig) {
        DataSetRequest dataSetRequest = new DataSetRequest();
        dataSetRequest.setCode(code);
        dataSetRequest.setFormat(dataSetConfig.getFormat());

        HttpHeaders headers = getAuthHeader(dataSetConfig);

        HttpEntity<DataSetRequest> httpEntity = new HttpEntity<>(dataSetRequest, headers);

        return new RestTemplate().exchange(dataSetConfig.getEndPoint() + dataSetConfig.getSubscriberKey(),
                HttpMethod.POST, httpEntity, DataSetResponse.class).getBody();
    }

    private static HttpHeaders getAuthHeader(DataSetConfig dataSetConfig) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("auth", AuthUtility.getAuth(dataSetConfig.getSubscriberKey(), dataSetConfig.getAppKey(), dataSetConfig.getDataToken()));
        return headers;
    }

    public static AvailableDataSets getAvailableDataSets(DataSetConfig dataSetConfig) {

        HttpHeaders headers = getAuthHeader(dataSetConfig);

        HttpEntity<DataSetRequest> httpEntity = new HttpEntity<>(headers);

        return new RestTemplate().exchange(dataSetConfig.getEndPoint() + dataSetConfig.getSubscriberKey(),
                HttpMethod.GET, httpEntity, AvailableDataSets.class).getBody();

    }
}
