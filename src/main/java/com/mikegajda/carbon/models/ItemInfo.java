
package com.mikegajda.carbon.models;

import com.fasterxml.jackson.annotation.*;
import lombok.ToString;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "Title"
})
@ToString
public class ItemInfo {

    @JsonProperty("Title")
    private Title title;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("Title")
    public Title getTitle() {
        return title;
    }

    @JsonProperty("Title")
    public void setTitle(Title title) {
        this.title = title;
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
