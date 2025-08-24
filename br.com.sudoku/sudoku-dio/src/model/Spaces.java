package model;

public class Spaces {
private boolean isFixed;
private Integer number; //dessa forma pode ser null
private int expectedNumber; //numero esperado para a posicao

public Spaces(boolean isFixed, Integer number, int expectedNumber) {
    this.expectedNumber = expectedNumber;
    this.isFixed = isFixed;
    this.number = number;
}
public int getExpectedNumber() {
    return expectedNumber;
}
public void setExpectedNumber(int expectedNumber) {
    this.expectedNumber = expectedNumber;
}
public boolean isFixed() {
    return isFixed;
}
public void setFixed(boolean isFixed) {
    this.isFixed = isFixed;
}
public Integer getNumber() {
    return number;
}
public void setNumber(Integer number) {
    this.number = number;
}
}
