package com.foodparcel.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Application implements Serializable {
    @Id
    private String id ;
    private String firstName;
    private String lastName ;
    private String homeAddress ;
    private String contactNumber ;
    private int numberOfDependants ;
    private double income;

    protected Application(){}

    private Application (Builder builder){
        this.id= builder.id;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.homeAddress = builder.homeAddress;
        this.contactNumber = builder.contactNumber;
        this.numberOfDependants = builder.numberOfDependants;
        this.income = builder.income;
    }
    //Getters
    public String getId() {
        return id;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getHomeAddress() {
        return homeAddress;
    }

    public double getIncome() {
        return income;
    }

    public int getNumberOfDependants() {
        return numberOfDependants;
    }

    @Override
    public String toString() {
        return "Application{" +
                "id=" + id +
                ", contactNumber=" + contactNumber +
                ", numberOfDependants=" + numberOfDependants +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", homeAddress='" + homeAddress + '\'' +
                ", income=" + income +
                '}';
    }

    public static class Builder {
        private String id , contactNumber ;
        private int numberOfDependants ;
        private String firstName , lastName , homeAddress ;
        private double income;


        public  Builder setid(String id) {
            this.id = id;
            return  this;
        }
        public  Builder setcontactNumber(String contactNumber) {
            this.contactNumber = contactNumber;
            return  this;
        }
        public  Builder setnumberOfDependants (int numberOfDependants){
            this.numberOfDependants = numberOfDependants;
            return  this;
        }
        public  Builder setfirstName(String firstName) {
            this.firstName = firstName;
            return  this;
        }
        public  Builder setlastName(String lastName) {
            this.lastName = lastName;
            return  this;
        }
        public  Builder sethomeAddress(String homeAddress) {
            this.homeAddress = homeAddress;
            return  this;
        }
        public  Builder setIncome (double income){
            this.income = income;
            return  this;
        }

        public Builder copy(Application application){
            this.id = application.id;
            this.contactNumber = application.contactNumber;
            this.numberOfDependants = application.numberOfDependants;
            this.firstName = application.firstName;
            this.lastName = application.lastName;
            this.homeAddress = application.homeAddress;
            this.income = application.income;
            return  this;
        }
        public Application build(){
            return  new Application(this);

        }
    }

}
