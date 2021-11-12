package com.thanhdol.selenium.automation_exam.dataobjects;

public class UserRegisterData {
    private PersonalInfo personalInfo;
    private PersonalAddress personalAddress;
    public PersonalAddress getPersonalAddress() {
        return personalAddress;
    }
    public void setPersonalAddress(PersonalAddress personalAddress) {
        this.personalAddress = personalAddress;
    }
    public PersonalInfo getPersonalInfo() {
        return personalInfo;
    }
    public void setPersonalInfo(PersonalInfo personalInfo) {
        this.personalInfo = personalInfo;
    }

}
