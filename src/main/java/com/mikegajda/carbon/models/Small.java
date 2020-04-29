
package com.mikegajda.carbon.models;

import com.fasterxml.jackson.annotation.*;
import lombok.ToString;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "Height",
    "URL",
    "Width"
})
@ToString
public class Small {

    @JsonProperty("Height")
    private Integer height;
    @JsonProperty("URL")
    private String uRL;
    @JsonProperty("Width")
    private Integer width;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("Height")
    public Integer getHeight() {
        return height;
    }

    @JsonProperty("Height")
    public void setHeight(Integer height) {
        this.height = height;
    }

    @JsonProperty("URL")
    public String getURL() {
        return uRL;
    }

    @JsonProperty("URL")
    public void setURL(String uRL) {
        this.uRL = uRL;
    }

    @JsonProperty("Width")
    public Integer getWidth() {
        return width;
    }

    @JsonProperty("Width")
    public void setWidth(Integer width) {
        this.width = width;
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
