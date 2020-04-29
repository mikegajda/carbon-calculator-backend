package com.mikegajda.carbon.components;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.junit.jupiter.api.Test;

import java.util.Map;
import java.util.TreeMap;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AWSV4AuthTest {

    @Test
    public void testAwsV4Auth() throws Exception {
        String HOST = "webservices.amazon.com";
        String region = "us-east-1";
        String path = "/paapi5/searchitems";

        // Sample SearchItems request. You can also use scratchpad tool (UI) to test a request and then use JSON Payload value here. Scratchpad link: https://webservices.amazon.com/paapi5/scratchpad/index.html
        // Put your Partner tag (Store/Tracking id) in place of Partner tag
        String requestPayload = "{\"Keywords\":\"harry\","
                + "\"PartnerTag\":\"carboncalculator-20\",\"PartnerType\":\"Associates\","
                + "\"SearchIndex\":\"All\","
                +"\"Resources\": [\"Images.Primary.Small\",\"ItemInfo.Title\",\"Offers.Listings.Price\"]}";

        TreeMap<String, String> headers = new TreeMap<String, String>();
        headers.put("host", HOST);
        headers.put("content-type", "application/json; charset=utf-8");
        // x-amz-target is value specific to your version and operation. For version 1's SearchItems it'll be com.amazon.paapi5.v1.ProductAdvertisingAPIv1.SearchItems
        headers.put("x-amz-target", "com.amazon.paapi5.v1.ProductAdvertisingAPIv1.SearchItems");
        headers.put("content-encoding", "amz-1.0");

        // Put your Access Key in place of <ACCESS_KEY> and Secret Key in place of <SECRET_KEY> in double quotes
        AWSV4Auth awsv4Auth = new AWSV4Auth.Builder("AKIAIB2PL2M2BSV65D2A", "1WS2QWRo16PQaFURqnGjINsrGFXKSqgMnc+UYgwj")
            .path(path)
                .region(region)
                .service("ProductAdvertisingAPI")
                .httpMethodName("POST")
                .headers(headers)
                .payload(requestPayload)
                .build();

        HttpClient client = HttpClientBuilder.create().build();
        HttpPost httpPost = new HttpPost("https://" + HOST + path);
        httpPost.setEntity(new StringEntity(requestPayload));
        // Signing
        Map<String, String> header = awsv4Auth.getHeaders();
        for (Map.Entry<String, String> entrySet : header.entrySet()) {
            httpPost.addHeader(entrySet.getKey(), entrySet.getValue());
            // Print headers by un-commenting following line
            //System.out.println("Key: " + entrySet.getKey() + " Value: " + entrySet.getValue());
        }

        HttpResponse response = client.execute(httpPost);
        HttpEntity entity = response.getEntity();
        String jsonResponse = EntityUtils.toString(entity, "UTF-8");
        int statusCode = response.getStatusLine().getStatusCode();
        System.out.println(jsonResponse);
        assertEquals(200, statusCode);
    }


}