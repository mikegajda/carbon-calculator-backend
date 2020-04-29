package com.mikegajda.carbon.models;

import com.fasterxml.jackson.annotation.JsonGetter;
import lombok.ToString;

import java.util.List;

@ToString
public class PAAPISearchRequest {
    private String keywords;
    private String partnerTag;
    private String partnerType;
    private String searchIndex;
    private List<String> resources;

    @JsonGetter("Keywords")
    public String getKeywords() {
        return keywords;
    }

    @JsonGetter("PartnerTag")
    public String getPartnerTag() {
        return partnerTag;
    }

    @JsonGetter("PartnerType")
    public String getPartnerType() {
        return partnerType;
    }

    @JsonGetter("SearchIndex")
    public String getSearchIndex() {
        return searchIndex;
    }

    @JsonGetter("Resources")
    public List<String> getResources() {
        return resources;
    }

    public PAAPISearchRequest(String keywords, String partnerTag, String partnerType, String searchIndex, List<String> resources) {
        this.keywords = keywords;
        this.partnerTag = partnerTag;
        this.partnerType = partnerType;
        this.searchIndex = searchIndex;
        this.resources = resources;
    }

    @Override
    public String toString() {
        return "PAAPISearchRequest{" +
                "keywords='" + keywords + '\'' +
                ", partnerTag='" + partnerTag + '\'' +
                ", partnerType='" + partnerType + '\'' +
                ", searchIndex='" + searchIndex + '\'' +
                ", resources=" + resources +
                '}';
    }
}
