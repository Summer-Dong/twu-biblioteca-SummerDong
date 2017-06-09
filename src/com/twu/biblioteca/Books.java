package com.twu.biblioteca;

/**
 * Created by summer on 2017/6/8.
 */
public class Books {
  private String title;
  private String author;
  private int year;
  private boolean isAvailable;
  private String checkoutUser;

  public Books(String title, String author, int year, boolean available, String checkoutUser){
    this.title=title;
    this.author=author;
    this.year=year;
    this.isAvailable=available;
    this.checkoutUser=checkoutUser;
  }

   public String getTitle(){
     return title;
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
    return title+','+author+','+year+'.';
  }

  public String getCheckoutDetails(){
    return title+','+checkoutUser+'.';
  }
}
