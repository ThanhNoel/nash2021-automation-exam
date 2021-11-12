package com.thanhdol.selenium.automation_exam.dataobjects;

import java.util.Calendar;

public class PersonalInfo {

    private EGender gender;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private Calendar dateOfBirth;
    private boolean newsLetterSignup;
    private boolean specialOffersReceive;
    
    public EGender getGender() {
        return gender;
    }
    public void setGender(EGender gender) {
        this.gender = gender;
    }
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
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public Calendar getDateOfBirth() {
        return dateOfBirth;
    }
    public void setDateOfBirth(Calendar dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
    public boolean isNewsLetterSignup() {
        return newsLetterSignup;
    }
    public void setNewsLetterSignup(boolean newsLetterSignup) {
        this.newsLetterSignup = newsLetterSignup;
    }
    public boolean isSpecialOffersReceive() {
        return specialOffersReceive;
    }
    public void setSpecialOffersReceive(boolean specialOffersReceive) {
        this.specialOffersReceive = specialOffersReceive;
    }

}
