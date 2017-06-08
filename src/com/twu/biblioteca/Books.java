package com.twu.biblioteca;

/**
 * Created by summer on 2017/6/8.
 */
public class Books {
  private String title;
  private String author;
  private int year;

  public Books(String title, String author, int year){
    this.title=title;
    this.author=author;
    this.year=year;
  }

  public String getTitle(){
    return title;
  }

  public String getAuthor(){
    return author;
  }

  public int getYear(){
    return year;
  }

  public String getDetails(){
    return getTitle()+','+getAuthor()+','+getYear()+'.';
  }
}
