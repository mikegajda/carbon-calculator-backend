
package com.mikegajda.carbon.models;

import com.fasterxml.jackson.annotation.*;
import lombok.ToString;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "Id",
    "Price",
    "ViolatesMAP"
})
@ToString
public class Listing {

    @JsonProperty("Id")
    private String id;
    @JsonProperty("Price")
    private Price price;
    @JsonProperty("ViolatesMAP")
    private Boolean violatesMAP;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("Id")
    public String getId() {
        return id;
    }

    @JsonProperty("Id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("Price")
    public Price getPrice() {
        return price;
    }

    @JsonProperty("Price")
    public void setPrice(Price price) {
        this.price = price;
    }

    @JsonProperty("ViolatesMAP")
    public Boolean getViolatesMAP() {
        return violatesMAP;
    }

    @JsonProperty("ViolatesMAP")
    public void setViolatesMAP(Boolean violatesMAP) {
        this.violatesMAP = violatesMAP;
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
