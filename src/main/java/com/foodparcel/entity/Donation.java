package com.foodparcel.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Donation  {
    @Id
    private String donationId;
    private String donationDate;
    private double donateAmount;

    protected Donation(){}

    public Donation(Builder builder) {
        this.donationId = builder.donationId;
        this.donationDate = builder.donationDate;
        this.donateAmount = builder.donateAmount;
    }

    public String getDonationId() {
        return donationId;
    }

    public String getDonationDate() {
        return donationDate;
    }

    public double getDonateAmount() {
        return donateAmount;
    }

    @Override
    public String toString() {
        return "Donation{" +
                "donationId='" + donationId + '\'' +
                ", donationDate='" + donationDate + '\'' +
                ", donateAmount=" + donateAmount +
                '}';
    }

    public static class Builder{
        private String donationId, donationDate;
        private double donateAmount;

        public Builder setDonationId(String donationId) {
            this.donationId = donationId;
            return this;
        }

        public Builder setDonationDate(String donationDate) {
            this.donationDate = donationDate;
            return this;
        }

        public Builder setDonateAmount(double donateAmount) {
            this.donateAmount = donateAmount;
            return this;
        }

        public Builder copy (Donation donation){
            this.donationId = donation.donationId;
            this.donationDate = donation.donationDate;
            this.donateAmount = donation.donateAmount;
            return this;
        }

        public Donation build(){
            return new Donation(this);
        }
    }
}


