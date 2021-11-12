package com.thanhdol.selenium.automation_exam.dataobjects;

public enum EGender {
    MISTER("Mr."),
    MISTRESS("Mrs.");
    private String val;
    EGender(String value) {
        this.val = value;
    }
    public String getValue() {
        return val;
    }

}
