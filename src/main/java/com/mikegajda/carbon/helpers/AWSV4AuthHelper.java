package com.mikegajda.carbon.helpers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mikegajda.carbon.components.AWSV4Auth;
import com.mikegajda.carbon.components.AmazonConfig;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;
import java.util.TreeMap;
import org.springframework.http.HttpHeaders;

@Slf4j
public class AWSV4AuthHelper {
    private static ObjectMapper mapper = new ObjectMapper();
    public static HttpHeaders generateHeaders(AmazonConfig amazonConfig, Object searchRequest, String target) throws JsonProcessingException {
        String searchRequestBody = mapper.writeValueAsString(searchRequest);
        log.info("searchRequestBody={}", searchRequestBody);
        TreeMap<String, String> headers = new TreeMap<>();
        headers.put("host", amazonConfig.amazonHost);
        headers.put("content-type", "application/json; charset=utf-8");
        // x-amz-target is value specific to your version and operation. For version 1's SearchItems it'll be com.amazon.paapi5.v1.ProductAdvertisingAPIv1.SearchItems
        headers.put("x-amz-target", target);
        headers.put("content-encoding", "amz-1.0");

        AWSV4Auth awsv4Auth = new AWSV4Auth.Builder(amazonConfig.amazonAccessKey, amazonConfig.amazonSecretKey)
                .path(amazonConfig.amazonPAAPI5Path)
                .region(amazonConfig.amazonRegion)
                .service("ProductAdvertisingAPI")
                .httpMethodName("POST")
                .headers(headers)
                .payload(searchRequestBody)
                .build();

        Map<String, String> allHeaders = awsv4Auth.getHeaders();
        HttpHeaders httpHeaders = new HttpHeaders();
        for (Map.Entry<String, String> entrySet : allHeaders.entrySet()) {
            httpHeaders.add(entrySet.getKey(), entrySet.getValue());
        }

        return httpHeaders;
    }
}
