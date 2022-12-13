package ru.x5.demo.kafka.saga.model;

import ru.x5.demo.kafka.saga.enums.RoomStatus;

public class Result {

    private String author = "hotel";
    private Integer ticketId;
    private RoomStatus status;
    private Integer orderId;

    // region g/s

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getTicketId() {
        return ticketId;
    }

    public void setTicketId(Integer ticketId) {
        this.ticketId = ticketId;
    }

    public RoomStatus getStatus() {
        return status;
    }

    public void setStatus(RoomStatus status) {
        this.status = status;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    // endregion

}
