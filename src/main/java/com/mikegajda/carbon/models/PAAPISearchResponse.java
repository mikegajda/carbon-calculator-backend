
package com.mikegajda.carbon.models;

import com.fasterxml.jackson.annotation.*;
import lombok.ToString;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "SearchResult"
})
@ToString
public class PAAPISearchResponse {

    @JsonProperty("SearchResult")
    private SearchResult searchResult;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("SearchResult")
    public SearchResult getSearchResult() {
        return searchResult;
    }

    @JsonProperty("SearchResult")
    public void setSearchResult(SearchResult searchResult) {
        this.searchResult = searchResult;
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
        return "PAAPISearchResponse{" +
                "searchResult=" + searchResult +
                ", additionalProperties=" + additionalProperties +
                '}';
    }
}
