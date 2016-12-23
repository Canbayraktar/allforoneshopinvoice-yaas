
package com.allforone.order.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "lines",
    "total"
})
public class Tax_ {

    @JsonProperty("lines")
    private List<Line_> lines = null;
    @JsonProperty("total")
    private Total__ total;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("lines")
    public List<Line_> getLines() {
        return lines;
    }

    @JsonProperty("lines")
    public void setLines(List<Line_> lines) {
        this.lines = lines;
    }

    @JsonProperty("total")
    public Total__ getTotal() {
        return total;
    }

    @JsonProperty("total")
    public void setTotal(Total__ total) {
        this.total = total;
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
