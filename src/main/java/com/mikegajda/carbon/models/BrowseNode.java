package com.mikegajda.carbon.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lombok.Data;
import lombok.ToString;

@JsonInclude(JsonInclude.Include.NON_NULL)
@ToString
@Data
public class BrowseNode {

  @JsonProperty("Id")
  private String id;

  @JsonProperty("IsRoot")
  private boolean isRoot;

  @JsonProperty("DisplayName")
  private String displayName;

  @JsonProperty("ContextFreeName")
  private String contextFreeName;

  @JsonProperty("Ancestor")
  private BrowseNode ancestor;

  @JsonProperty("Children")
  private List<BrowseNode> children;

  public BrowseNode getRootNode() {
    BrowseNode currentBrowseNode = this;
    while (currentBrowseNode.ancestor != null) {
      currentBrowseNode = currentBrowseNode.ancestor;
    }
    return currentBrowseNode;
  }

  public String getPath() {
    List<String> path = new ArrayList<>();
    BrowseNode currentBrowseNode = this;
    while (currentBrowseNode != null) {
      path.add(currentBrowseNode.displayName);
      currentBrowseNode = currentBrowseNode.ancestor;
    }
    Collections.reverse(path);
    return String.join(" > ", path);
  }
}
