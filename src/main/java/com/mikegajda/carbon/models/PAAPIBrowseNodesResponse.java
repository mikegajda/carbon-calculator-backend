package com.mikegajda.carbon.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.ToString;

@JsonInclude(JsonInclude.Include.NON_NULL)
@ToString
public class PAAPIBrowseNodesResponse {
    @JsonProperty("BrowseNodesResult")
    private BrowseNodesResult browseNodesResult;
}
