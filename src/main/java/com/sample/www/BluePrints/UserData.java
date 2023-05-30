package com.sample.www.BluePrints;

import java.util.Random;

public class UserData {

    private String gender;
    private String firstName;
    private String lastName;
    private String day;
    private String month;
    private String year;
    private String email;
    private String company;
    private String password ;
    private String confirmPassword;

    static Random randomGenerator = new Random();
    static int randomInt = randomGenerator.nextInt(1000);
    public static String em = "arjolaavdulaj" + randomInt+"@gmail.com";

    public UserData(){
        setGender("Female");
        setFirstName("Arjola");
        setLastName("Avdulaj");
        setDay("2");
        setMonth("January");
        setYear("2002");
        setEmail(em);
        setCompany("Google");
        setPassword("arjola123");
        setConfirmPassword("arjola123");
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String name) {
        this.firstName = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
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

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}
