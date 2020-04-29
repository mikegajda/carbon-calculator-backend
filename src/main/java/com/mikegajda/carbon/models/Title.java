
package com.mikegajda.carbon.models;

import com.fasterxml.jackson.annotation.*;
import lombok.ToString;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "DisplayValue",
    "Label",
    "Locale"
})
@ToString
public class Title {

    @JsonProperty("DisplayValue")
    private String displayValue;
    @JsonProperty("Label")
    private String label;
    @JsonProperty("Locale")
    private String locale;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("DisplayValue")
    public String getDisplayValue() {
        return displayValue;
    }

    @JsonProperty("DisplayValue")
    public void setDisplayValue(String displayValue) {
        this.displayValue = displayValue;
    }

    @JsonProperty("Label")
    public String getLabel() {
        return label;
    }

    @JsonProperty("Label")
    public void setLabel(String label) {
        this.label = label;
    }

    @JsonProperty("Locale")
    public String getLocale() {
        return locale;
    }

    @JsonProperty("Locale")
    public void setLocale(String locale) {
        this.locale = locale;
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
