
package com.mikegajda.carbon.models;

import com.fasterxml.jackson.annotation.*;
import lombok.ToString;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "Listings"
})
@ToString
public class Offers {

    @JsonProperty("Listings")
    private List<Listing> listings = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("Listings")
    public List<Listing> getListings() {
        return listings;
    }

    @JsonProperty("Listings")
    public void setListings(List<Listing> listings) {
        this.listings = listings;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
