package com.twu.biblioteca;

/**
 * Created by summer on 2017/6/8.
 */
public class Books {
  private String title;
  private String author;
  private int year;
  private boolean isAvailable;

  public Books(String title, String author, int year, boolean available){
    this.title=title;
    this.author=author;
    this.year=year;
    this.isAvailable=available;
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

  public String getDetails(){
    return title+','+author+','+year+'.';
  }
}
