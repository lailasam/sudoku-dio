package model;

public class Spaces {
private boolean isFixed;
private Integer number; //dessa forma pode ser null
public Spaces(boolean isFixed, Integer number) {
    this.isFixed = isFixed;
    this.number = number;
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
