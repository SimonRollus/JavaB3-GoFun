package com.spring.henallux.firstSpringProject.dataAccess.entity;


import javax.persistence.*;


import java.util.Date;

@Entity
@Table(name = "discount")
public class DiscountEntity {
    @Id
    @Column(name = "discount_id")
    private Integer discountID;

    @Column(name = "percentage_discount")
    private Float percentageDiscount;

    @Column(name = "start_date")
    private Date startDate;

    @Column(name = "end_date")
    private Date endDate;
    //endregion


    public DiscountEntity() {
    }

    public Integer getDiscountID() {
        return discountID;
    }

    public void setDiscountID(Integer discountID) {
        this.discountID = discountID;
    }

    public Float getPercentageDiscount() {
        return percentageDiscount;
    }

    public void setPercentageDiscount(Float percentageDiscount) {
        this.percentageDiscount = percentageDiscount;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date start_date) {
        this.startDate = start_date;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date end_date) {
        this.endDate = end_date;
    }
}