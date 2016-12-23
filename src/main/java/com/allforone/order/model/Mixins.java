
package com.allforone.order.model;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "taxCodes",
    "inventory"
})
public class Mixins {

    @JsonProperty("taxCodes")
    private String taxCodes;
    @JsonProperty("inventory")
    private String inventory;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("taxCodes")
    public String getTaxCodes() {
        return taxCodes;
    }

    @JsonProperty("taxCodes")
    public void setTaxCodes(String taxCodes) {
        this.taxCodes = taxCodes;
    }

    @JsonProperty("inventory")
    public String getInventory() {
        return inventory;
    }

    @JsonProperty("inventory")
    public void setInventory(String inventory) {
        this.inventory = inventory;
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
