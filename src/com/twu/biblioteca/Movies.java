package com.twu.biblioteca;

/**
 * Created by summer on 2017/6/8.
 */
public class Movies {
  private String name;
  private String director;
  private int year;
  private String rating;
  private boolean isAvailable;
  private String checkoutUser;

  public Movies(String name, String director, int year, String rating, boolean available, String checkoutUser){
    this.name=name;
    this.director=director;
    this.year=year;
    this.rating=rating;
    this.isAvailable=available;
    this.checkoutUser=checkoutUser;
  }

  public String getName(){
    return name;
  }

  public boolean checkIsAvailable(){
    return isAvailable;
  }

  public void setAvailable(boolean available){
    this.isAvailable=available;
  }

  public void setCheckoutUser(String checkoutUser){
    this.checkoutUser=checkoutUser;
  }

  public String getDetails(){
    return name+','+director+','+year+','+rating+'.';
  }

  public String getCheckoutDetails(){
    return name+','+checkoutUser+'.';
  }
}
