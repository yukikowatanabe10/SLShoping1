package com.slshop.common.entity.order;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.slshop.common.entity.Address;
import com.slshop.common.entity.Customer;

public class Order {

    private Long id;

    private LocalDateTime orderTime;

    private int total;

    private int deliverDays;

    private LocalDate deliverDate;

    private PaymentMethod paymentMethod;

    private OrderStatus status;

    private Customer customer;
    
    private Address address;

    private Set<OrderDetail> orderDetails = new HashSet<>();

    private List<OrderTrack> orderTracks = new ArrayList<>();

    public Order() {
    }

    public Order(LocalDateTime orderTime, int total) {
        this.orderTime = orderTime;
        this.total = total;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(LocalDateTime orderTime) {
        this.orderTime = orderTime;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getDeliverDays() {
        return deliverDays;
    }
    
    public Address getAddress() {
    	return this.address;
    }

    public void setDeliverDays(int deliverDays) {
        this.deliverDays = deliverDays;
    }

    public LocalDate getDeliverDate() {
        return deliverDate;
    }

    public void setDeliverDate(LocalDate deliverDate) {
        this.deliverDate = deliverDate;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Set<OrderDetail> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(Set<OrderDetail> orderDetails) {
        this.orderDetails = orderDetails;
    }

    public List<OrderTrack> getOrderTracks() {
        return orderTracks;
    }

    public void setOrderTracks(List<OrderTrack> orderTracks) {
        this.orderTracks = orderTracks;
    }
    
    public void setAddress(Address address) {
    	this.address = address;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Order other = (Order) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Order [id=" + id + ", total=" + total + ", deliverDays=" + deliverDays + ", deliverDate=" + deliverDate
                + ", paymentMethod=" + paymentMethod + ", status=" + status + ", customer=" + customer
                + ", orderDetails=" + orderDetails + ", orderTracks=" + orderTracks + "]";
    }

}
