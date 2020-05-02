package com.mikegajda.carbon.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.ToString;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@ToString
public class BrowseNodesResult {
    @JsonProperty("BrowseNodes")
    private List<BrowseNode> browseNodes;
}
