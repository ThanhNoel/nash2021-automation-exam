package com.thanhdol.selenium.automation_exam.dataobjects;

public class PersonalAddress {
    private String firstName;  // required
    private String lastName;// required
    private String company;
    private String address;// required
    private String city;// required
    private String state; // required if country = 'United States'
    private String postCode;// required if country = 'United States'
    private String country;// required
    private String additionalInformation;
    private String homePhone;  // either this of mobile phone required
    private String mobilePhone;
    private String addressAlias;  // required
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getCompany() {
        return company;
    }
    public void setCompany(String company) {
        this.company = company;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country = country;
    }
    public String getAdditionalInformation() {
        return additionalInformation;
    }
    public void setAdditionalInformation(String additionalInformation) {
        this.additionalInformation = additionalInformation;
    }
    public String getHomePhone() {
        return homePhone;
    }
    public void setHomePhone(String homePhone) {
        this.homePhone = homePhone;
    }
    public String getMobilePhone() {
        return mobilePhone;
    }
    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }
    public String getAddressAlias() {
        return addressAlias;
    }
    public void setAddressAlias(String addressAlias) {
        this.addressAlias = addressAlias;
    }
    public String getState() {
        return state;
    }
    public void setState(String state) {
        this.state = state;
    }
    public String getPostCode() {
        return postCode;
    }
    public void setPostCode(String zipCode) {
        this.postCode = zipCode;
    }

}
