package com.mikegajda.carbon.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@ToString
@Data
public class BrowseNodeInfo {
    @JsonProperty("BrowseNodes")
    private List<BrowseNode> browseNodes;
}
