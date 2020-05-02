package com.mikegajda.carbon.models;

import com.fasterxml.jackson.annotation.*;
import lombok.Data;
import lombok.ToString;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "ASIN",
    "DetailPageURL",
    "Images",
    "ItemInfo",
    "Offers"
})
@ToString
@Data
public class Item {

  @JsonProperty("ASIN")
  private String aSIN;
  @JsonProperty("DetailPageURL")
  private String detailPageURL;
  @JsonProperty("Images")
  private Images images;
  @JsonProperty("ItemInfo")
  private ItemInfo itemInfo;
  @JsonProperty("Offers")
  private Offers offers;
  @JsonProperty("BrowseNodeInfo")
  public BrowseNodeInfo browseNodeInfo;

  @JsonIgnore
  private Map<String, Object> additionalProperties = new HashMap<String, Object>();

  @JsonProperty("ASIN")
  public String getASIN() {
    return aSIN;
  }

  @JsonProperty("ASIN")
  public void setASIN(String aSIN) {
    this.aSIN = aSIN;
  }

  @JsonProperty("DetailPageURL")
  public String getDetailPageURL() {
    return detailPageURL;
  }

  @JsonProperty("DetailPageURL")
  public void setDetailPageURL(String detailPageURL) {
    this.detailPageURL = detailPageURL;
  }

  @JsonProperty("Images")
  public Images getImages() {
    return images;
  }

  @JsonProperty("Images")
  public void setImages(Images images) {
    this.images = images;
  }

  @JsonProperty("ItemInfo")
  public ItemInfo getItemInfo() {
    return itemInfo;
  }

  @JsonProperty("ItemInfo")
  public void setItemInfo(ItemInfo itemInfo) {
    this.itemInfo = itemInfo;
  }

  @JsonProperty("Offers")
  public Offers getOffers() {
    return offers;
  }

  @JsonProperty("Offers")
  public void setOffers(Offers offers) {
    this.offers = offers;
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
