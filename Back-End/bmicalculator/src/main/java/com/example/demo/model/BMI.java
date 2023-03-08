package com.example.demo.model;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class BMI {
  @Id
  private Long id;

  private Double height;

  private Double weight;

  private Double bmiValue;

  public BMI() {}

  public BMI(long id,Double height, Double weight, Double bmiValue) {
	this.id = id;
    this.height = height;
    this.weight = weight;
    this.bmiValue = bmiValue;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Double getHeight() {
    return height;
  }

  public void setHeight(Double height) {
    this.height = height;
  }

  public Double getWeight() {
    return weight;
  }

  public void setWeight(Double weight) {
    this.weight = weight;
  }

  public Double getBmiValue() {
    return bmiValue;
  }

  public void setBmiValue(Double bmiValue) {
    this.bmiValue = bmiValue;
  }
}
