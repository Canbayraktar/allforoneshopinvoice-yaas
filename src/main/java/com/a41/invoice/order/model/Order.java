
package com.a41.invoice.order.model;

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
    "entries",
    "discounts",
    "customer",
    "siteCode",
    "billingAddress",
    "shippingAddress",
    "payments",
    "shipping",
    "tax",
    "subTotalPrice",
    "totalPrice",
    "currency",
    "metadata",
    "mixins",
    "channel",
    "created",
    "shipments",
    "id",
    "status"
})
public class Order {

    @JsonProperty("entries")
    private List<Entry> entries = null;
    @JsonProperty("discounts")
    private List<Object> discounts = null;
    @JsonProperty("customer")
    private Customer customer;
    @JsonProperty("siteCode")
    private String siteCode;
    @JsonProperty("billingAddress")
    private BillingAddress billingAddress;
    @JsonProperty("shippingAddress")
    private ShippingAddress shippingAddress;
    @JsonProperty("payments")
    private List<Payment> payments = null;
    @JsonProperty("shipping")
    private Shipping shipping;
    @JsonProperty("tax")
    private Tax_ tax;
    @JsonProperty("subTotalPrice")
    private Double subTotalPrice;
    @JsonProperty("totalPrice")
    private Double totalPrice;
    @JsonProperty("currency")
    private String currency;
    @JsonProperty("metadata")
    private Metadata_ metadata;
    @JsonProperty("mixins")
    private Mixins___ mixins;
    @JsonProperty("channel")
    private Channel channel;
    @JsonProperty("created")
    private String created;
    @JsonProperty("shipments")
    private List<Shipment> shipments = null;
    @JsonProperty("id")
    private String id;
    @JsonProperty("status")
    private String status;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("entries")
    public List<Entry> getEntries() {
        return entries;
    }

    @JsonProperty("entries")
    public void setEntries(List<Entry> entries) {
        this.entries = entries;
    }

    @JsonProperty("discounts")
    public List<Object> getDiscounts() {
        return discounts;
    }

    @JsonProperty("discounts")
    public void setDiscounts(List<Object> discounts) {
        this.discounts = discounts;
    }

    @JsonProperty("customer")
    public Customer getCustomer() {
        return customer;
    }

    @JsonProperty("customer")
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @JsonProperty("siteCode")
    public String getSiteCode() {
        return siteCode;
    }

    @JsonProperty("siteCode")
    public void setSiteCode(String siteCode) {
        this.siteCode = siteCode;
    }

    @JsonProperty("billingAddress")
    public BillingAddress getBillingAddress() {
        return billingAddress;
    }

    @JsonProperty("billingAddress")
    public void setBillingAddress(BillingAddress billingAddress) {
        this.billingAddress = billingAddress;
    }

    @JsonProperty("shippingAddress")
    public ShippingAddress getShippingAddress() {
        return shippingAddress;
    }

    @JsonProperty("shippingAddress")
    public void setShippingAddress(ShippingAddress shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    @JsonProperty("payments")
    public List<Payment> getPayments() {
        return payments;
    }

    @JsonProperty("payments")
    public void setPayments(List<Payment> payments) {
        this.payments = payments;
    }

    @JsonProperty("shipping")
    public Shipping getShipping() {
        return shipping;
    }

    @JsonProperty("shipping")
    public void setShipping(Shipping shipping) {
        this.shipping = shipping;
    }

    @JsonProperty("tax")
    public Tax_ getTax() {
        return tax;
    }

    @JsonProperty("tax")
    public void setTax(Tax_ tax) {
        this.tax = tax;
    }

    @JsonProperty("subTotalPrice")
    public Double getSubTotalPrice() {
        return subTotalPrice;
    }

    @JsonProperty("subTotalPrice")
    public void setSubTotalPrice(Double subTotalPrice) {
        this.subTotalPrice = subTotalPrice;
    }

    @JsonProperty("totalPrice")
    public Double getTotalPrice() {
        return totalPrice;
    }

    @JsonProperty("totalPrice")
    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    @JsonProperty("currency")
    public String getCurrency() {
        return currency;
    }

    @JsonProperty("currency")
    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @JsonProperty("metadata")
    public Metadata_ getMetadata() {
        return metadata;
    }

    @JsonProperty("metadata")
    public void setMetadata(Metadata_ metadata) {
        this.metadata = metadata;
    }

    @JsonProperty("mixins")
    public Mixins___ getMixins() {
        return mixins;
    }

    @JsonProperty("mixins")
    public void setMixins(Mixins___ mixins) {
        this.mixins = mixins;
    }

    @JsonProperty("channel")
    public Channel getChannel() {
        return channel;
    }

    @JsonProperty("channel")
    public void setChannel(Channel channel) {
        this.channel = channel;
    }

    @JsonProperty("created")
    public String getCreated() {
        return created;
    }

    @JsonProperty("created")
    public void setCreated(String created) {
        this.created = created;
    }

    @JsonProperty("shipments")
    public List<Shipment> getShipments() {
        return shipments;
    }

    @JsonProperty("shipments")
    public void setShipments(List<Shipment> shipments) {
        this.shipments = shipments;
    }

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("status")
    public String getStatus() {
        return status;
    }

    @JsonProperty("status")
    public void setStatus(String status) {
        this.status = status;
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
