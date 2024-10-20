package com.rulemachine.model;


import java.lang.reflect.Field;

public class UserAttributes {
    private int age;
    private String department;
    private int salary;
    private int experience;

    // Getters and setters
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    // Method to dynamically retrieve the value of an attribute
    public String get(String attribute) {
        try {
            // Use reflection to find the field by name
            Field field = this.getClass().getDeclaredField(attribute);
            field.setAccessible(true); // Make sure the field is accessible
            Object value = field.get(this); // Get the value of the field

            return value.toString(); // Return the value as a String
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
            return null; // Return null if the attribute is not found or accessible
        }
    }
}
