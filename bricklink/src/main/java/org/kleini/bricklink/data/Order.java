/*
 * GPL v3
 */

package org.kleini.bricklink.data;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * {@link Order}
 *
 * @author <a href="mailto:himself@kleini.org">Marcus Klein</a>
 */
public class Order {

    /**
     * Unique identifier for this order for internal use
     */
    private int id;

    /**
     * The time the order was created
     */
    private Date ordered;

    /**
     * The username of the seller in BL
     */
    private String seller;

    /**
     * The store name displayed on BL store pages
     */
    private String store;

    /**
     * The username of the buyer in BL
     */
    private String buyer;

    /**
     * E-mail address of the buyer
     */
    private String email;

    /**
     * Indicates whether the buyer requests insurance for this order
     */
    private boolean insuranceRequested;

    /**
     * The status of an order
     */
    private Status status;

    /**
     * Indicates whether the order invoiced
     */
    private boolean invoiced;

    /**
     * User remarks for this order
     */
    private String remarks;

    /**
     * The total number of items included in this order
     */
    private int total;

    /**
     * The unique number of items included in this order
     */
    private int unique;

    /**
     * Information related to the payment of this order
     */
    private Payment payment;

    /**
     * Information related to the shipping
     */
    private Shipping shipping;

    /**
     * Cost information for this order
     */
    private Cost cost;

    public Order() {
        super();
    }

    @JsonProperty("order_id")
    public int getId() {
        return id;
    }

    @JsonProperty("order_id")
    public void setId(int id) {
        this.id = id;
    }

    @JsonProperty("date_ordered")
    public Date getOrdered() {
        return ordered;
    }

    @JsonProperty("date_ordered")
    public void setOrdered(Date ordered) {
        this.ordered = ordered;
    }

    @JsonProperty("seller_name")
    public String getSeller() {
        return seller;
    }

    @JsonProperty("seller_name")
    public void setSeller(String seller) {
        this.seller = seller;
    }

    @JsonProperty("store_name")
    public String getStore() {
        return store;
    }

    @JsonProperty("store_name")
    public void setStore(String store) {
        this.store = store;
    }

    @JsonProperty("buyer_name")
    public String getBuyer() {
        return buyer;
    }

    @JsonProperty("buyer_name")
    public void setBuyer(String buyer) {
        this.buyer = buyer;
    }

    @JsonProperty("buyer_email")
    public String getEmail() {
        return email;
    }

    @JsonProperty("buyer_email")
    public void setEmail(String email) {
        this.email = email;
    }

    @JsonProperty("require_insurance")
    public boolean isInsuranceRequested() {
        return insuranceRequested;
    }

    @JsonProperty("require_insurance")
    public void setInsuranceRequested(boolean insuranceRequested) {
        this.insuranceRequested = insuranceRequested;
    }

    @JsonProperty("status")
    public Status getStatus() {
        return status;
    }

    @JsonProperty("status")
    public void setStatus(Status status) {
        this.status = status;
    }

    @JsonProperty("is_invoiced")
    public boolean isInvoiced() {
        return invoiced;
    }

    @JsonProperty("is_invoiced")
    public void setInvoiced(boolean invoiced) {
        this.invoiced = invoiced;
    }

    @JsonProperty("remarks")
    public String getRemarks() {
        return remarks;
    }

    @JsonProperty("remarks")
    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    @JsonProperty("total_count")
    public int getTotal() {
        return total;
    }

    @JsonProperty("total_count")
    public void setTotal(int total) {
        this.total = total;
    }

    @JsonProperty("unique_count")
    public int getUnique() {
        return unique;
    }

    @JsonProperty("unique_count")
    public void setUnique(int unique) {
        this.unique = unique;
    }

    @JsonProperty("payment")
    public Payment getPayment() {
        return payment;
    }

    @JsonProperty("payment")
    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    @JsonProperty("shipping")
    public Shipping getShipping() {
        return shipping;
    }

    @JsonProperty("shipping")
    public void setShipping(Shipping shipping) {
        this.shipping = shipping;
    }

    @JsonProperty("cost")
    public Cost getCost() {
        return cost;
    }

    @JsonProperty("cost")
    public void setCost(Cost cost) {
        this.cost = cost;
    }
}