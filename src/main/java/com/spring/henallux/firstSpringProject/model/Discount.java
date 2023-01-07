package com.spring.henallux.firstSpringProject.model;

import javax.validation.constraints.*;

import java.util.Date;

public class Discount {

    @NotNull
    @Min(value = 1)
    private Integer discountID;

    @NotNull
    @Min(value = 1)
    private Float percentageDiscount;
    private Date startDate;
    private Date endDate;


    public Discount() {
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

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}
