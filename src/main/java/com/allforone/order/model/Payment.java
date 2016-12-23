
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
    "status",
    "method",
    "paymentResponse",
    "paidAmount",
    "currency"
})
public class Payment {

    @JsonProperty("status")
    private String status;
    @JsonProperty("method")
    private String method;
    @JsonProperty("paymentResponse")
    private String paymentResponse;
    @JsonProperty("paidAmount")
    private Double paidAmount;
    @JsonProperty("currency")
    private String currency;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("status")
    public String getStatus() {
        return status;
    }

    @JsonProperty("status")
    public void setStatus(String status) {
        this.status = status;
    }

    @JsonProperty("method")
    public String getMethod() {
        return method;
    }

    @JsonProperty("method")
    public void setMethod(String method) {
        this.method = method;
    }

    @JsonProperty("paymentResponse")
    public String getPaymentResponse() {
        return paymentResponse;
    }

    @JsonProperty("paymentResponse")
    public void setPaymentResponse(String paymentResponse) {
        this.paymentResponse = paymentResponse;
    }

    @JsonProperty("paidAmount")
    public Double getPaidAmount() {
        return paidAmount;
    }

    @JsonProperty("paidAmount")
    public void setPaidAmount(Double paidAmount) {
        this.paidAmount = paidAmount;
    }

    @JsonProperty("currency")
    public String getCurrency() {
        return currency;
    }

    @JsonProperty("currency")
    public void setCurrency(String currency) {
        this.currency = currency;
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
