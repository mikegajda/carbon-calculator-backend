package com.mikegajda.carbon.models;

import com.fasterxml.jackson.annotation.JsonGetter;
import lombok.ToString;

import java.util.List;

@ToString
public class PAAPIBrowseNodesRequest  {
    private List<String> browseNodeIds;
    private String partnerTag;
    private String partnerType;
    private List<String> resources;

    @JsonGetter("BrowseNodeIds")
    public List<String> getBrowseNodeIds() {
        return browseNodeIds;
    }

    @JsonGetter("PartnerTag")
    public String getPartnerTag() {
        return partnerTag;
    }

    @JsonGetter("PartnerType")
    public String getPartnerType() {
        return partnerType;
    }


    @JsonGetter("Resources")
    public List<String> getResources() {
        return resources;
    }

    public PAAPIBrowseNodesRequest(List<String> browseNodeIds, String partnerTag, String partnerType, List<String> resources) {
        this.browseNodeIds = browseNodeIds;
        this.partnerTag = partnerTag;
        this.partnerType = partnerType;
        this.resources = resources;
    }

    @Override
    public String toString() {
        return "PAAPISearchRequest{" +
                "browseNodeIds='" + browseNodeIds + '\'' +
                ", partnerTag='" + partnerTag + '\'' +
                ", partnerType='" + partnerType + '\'' +
                ", resources=" + resources +
                '}';
    }
}

