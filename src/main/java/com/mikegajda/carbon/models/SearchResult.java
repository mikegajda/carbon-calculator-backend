
package com.mikegajda.carbon.models;

import com.fasterxml.jackson.annotation.*;
import lombok.ToString;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "Items",
    "SearchURL",
    "TotalResultCount"
})
@ToString
public class SearchResult {

    @JsonProperty("Items")
    private List<Item> items = null;
    @JsonProperty("SearchURL")
    private String searchURL;
    @JsonProperty("TotalResultCount")
    private Integer totalResultCount;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("Items")
    public List<Item> getItems() {
        return items;
    }

    @JsonProperty("Items")
    public void setItems(List<Item> items) {
        this.items = items;
    }

    @JsonProperty("SearchURL")
    public String getSearchURL() {
        return searchURL;
    }

    @JsonProperty("SearchURL")
    public void setSearchURL(String searchURL) {
        this.searchURL = searchURL;
    }

    @JsonProperty("TotalResultCount")
    public Integer getTotalResultCount() {
        return totalResultCount;
    }

    @JsonProperty("TotalResultCount")
    public void setTotalResultCount(Integer totalResultCount) {
        this.totalResultCount = totalResultCount;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public String toString() {
        return "SearchResult{" +
                "items=" + items +
                ", searchURL='" + searchURL + '\'' +
                ", totalResultCount=" + totalResultCount +
                ", additionalProperties=" + additionalProperties +
                '}';
    }
}
