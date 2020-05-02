package com.mikegajda.carbon.helpers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mikegajda.carbon.components.AWSV4Auth;
import com.mikegajda.carbon.components.AmazonConfig;
import com.mikegajda.carbon.models.BrowseNode;
import com.mikegajda.carbon.models.Item;
import com.mikegajda.carbon.models.PAAPISearchRequest;
import com.mikegajda.carbon.models.PAAPISearchResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@SpringBootTest
@Slf4j
class AWSV4AuthHelperTest {

  @Autowired
  AmazonConfig amazonConfig;

  private ObjectMapper mapper = new ObjectMapper();

  private RestTemplate restTemplate = new RestTemplate();

  @Test
  public void testGenerateHeaders() throws Exception {
    List<String> resources = new ArrayList<>();
    resources.add("ItemInfo.Title");
    resources.add("ItemInfo.ContentInfo");
    resources.add("ItemInfo.ProductInfo");
    resources.add("Offers.Listings.Price");
    resources.add("BrowseNodeInfo.BrowseNodes");
    resources.add("BrowseNodeInfo.BrowseNodes.Ancestor");
    resources.add("BrowseNodeInfo.BrowseNodes.SalesRank");
    resources.add("BrowseNodeInfo.WebsiteSalesRank");
    PAAPISearchRequest searchRequest = new PAAPISearchRequest("harry", "carboncalculator-20",
        "Associates", "All", resources);

    String requestBody = mapper.writeValueAsString(searchRequest);

    HttpHeaders httpHeaders = AWSV4AuthHelper.generateHeaders(amazonConfig, searchRequest,
        "com.amazon.paapi5.v1.ProductAdvertisingAPIv1.SearchItems");

    org.springframework.http.HttpEntity<String> request = new org.springframework.http.HttpEntity<String>(
        requestBody, httpHeaders);

    ResponseEntity<PAAPISearchResponse> responseEntity = restTemplate
        .postForEntity("https://" + amazonConfig.amazonHost + amazonConfig.amazonPAAPI5Path,
            request, PAAPISearchResponse.class);
    log.info("repsonseBody={}", responseEntity.getBody().toString());
    log.info("path={}",
        responseEntity.getBody().getSearchResult().getItems().get(0).getBrowseNodeInfo()
            .getBrowseNodes().get(0).getPath());
    List<Item> items = responseEntity.getBody().getSearchResult().getItems();
    for(Item item: items){
      log.info("item name={}", item.getItemInfo().getTitle().getDisplayValue());
      List<BrowseNode> browseNodes = item.getBrowseNodeInfo().getBrowseNodes();
      for (BrowseNode browseNode: browseNodes){
        log.info("item name={}, path={}", item.getItemInfo().getTitle().getDisplayValue(), browseNode.getPath());
      }
    }
    assertEquals(200, responseEntity.getStatusCode().value());
  }

//    @Test
//    public void testBrowseNodes() throws Exception {
//        List<String> nodeIds = new ArrayList<>();
//        nodeIds.add("283155");
//        nodeIds.add("3040");
//
//        List<String> resources = new ArrayList<>();
//        resources.add("BrowseNodes.Ancestor");
//        resources.add("BrowseNodes.Children");
//        PAAPIBrowseNodesRequest searchRequest = new PAAPIBrowseNodesRequest(nodeIds, "carboncalculator-20", "Associates", resources);
//        HttpClient client = HttpClientBuilder.create().build();
//        HttpPost httpPost = new HttpPost("https://" + amazonConfig.amazonHost + amazonConfig.amazonPAAPI5Path);
//        String requestBody = mapper.writeValueAsString(searchRequest);
//        httpPost.setEntity(new StringEntity(mapper.writeValueAsString(searchRequest)));
//        // Signing
//        Map<String, String> header = AWSV4AuthHelper.generateHeaders(amazonConfig, searchRequest, "com.amazon.paapi5.v1.ProductAdvertisingAPIv1.GetBrowseNodes");
//        for (Map.Entry<String, String> entrySet : header.entrySet()) {
//            httpPost.addHeader(entrySet.getKey(), entrySet.getValue());
//            // Print headers by un-commenting following line
//            //System.out.println("Key: " + entrySet.getKey() + " Value: " + entrySet.getValue());
//        }
//
//        HttpResponse response = client.execute(httpPost);
//        HttpEntity entity = response.getEntity();
//        String jsonResponse = EntityUtils.toString(entity, "UTF-8");
//        int statusCode = response.getStatusLine().getStatusCode();
//        log.info("jsonResponse={}", jsonResponse);
//        assertEquals(200, statusCode);
//
//        RestTemplate restTemplate = new RestTemplate();
//        HttpHeaders httpHeaders = new HttpHeaders();
//        for (Map.Entry<String, String> entrySet : header.entrySet()) {
//            httpHeaders.add(entrySet.getKey(), entrySet.getValue());
//        }
//        org.springframework.http.HttpEntity<String> request = new org.springframework.http.HttpEntity<String>(requestBody, httpHeaders);
//
//        ResponseEntity<PAAPIBrowseNodesResponse> responseEntity = restTemplate.postForEntity("https://" + amazonConfig.amazonHost + amazonConfig.amazonPAAPI5Path, request, PAAPIBrowseNodesResponse.class);
//        log.info("repsonseBody={}", responseEntity.getBody().toString());
//        assertEquals(200, responseEntity.getStatusCode().value());
//    }

  @Test
  private Map<String, String> correctHeaderGenerator() throws Exception {
    String HOST = amazonConfig.amazonHost;
    String region = amazonConfig.amazonRegion;
    String path = amazonConfig.amazonPAAPI5Path;

    // Sample SearchItems request. You can also use scratchpad tool (UI) to test a request and then use JSON Payload value here. Scratchpad link: https://webservices.amazon.com/paapi5/scratchpad/index.html
    // Put your Partner tag (Store/Tracking id) in place of Partner tag
    String requestPayload = "{\"Keywords\":\"harry\","
        + "\"PartnerTag\":\"carboncalculator-20\",\"PartnerType\":\"Associates\","
        + "\"SearchIndex\":\"All\","
        + "\"Resources\": [\"Images.Primary.Small\",\"ItemInfo.Title\",\"Offers.Listings.Price\"]}";

    TreeMap<String, String> headers = new TreeMap<String, String>();
    headers.put("host", HOST);
    headers.put("content-type", "application/json; charset=utf-8");
    // x-amz-target is value specific to your version and operation. For version 1's SearchItems it'll be com.amazon.paapi5.v1.ProductAdvertisingAPIv1.SearchItems
    headers.put("x-amz-target", "com.amazon.paapi5.v1.ProductAdvertisingAPIv1.SearchItems");
    headers.put("content-encoding", "amz-1.0");

    // Put your Access Key in place of <ACCESS_KEY> and Secret Key in place of <SECRET_KEY> in double quotes
    AWSV4Auth awsv4Auth = new AWSV4Auth.Builder(amazonConfig.amazonAccessKey,
        amazonConfig.amazonSecretKey)
        .path(path)
        .region(region)
        .service("ProductAdvertisingAPI")
        .httpMethodName("POST")
        .headers(headers)
        .payload(requestPayload)
        .build();

    return awsv4Auth.getHeaders();
  }

}