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

  public Movies(String name, String director, int year, String rating, boolean available){
    this.name=name;
    this.director=director;
    this.year=year;
    this.rating=rating;
    this.isAvailable=available;
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

  public String getDetails(){
    return name+','+director+','+year+','+rating+'.';
  }
}
