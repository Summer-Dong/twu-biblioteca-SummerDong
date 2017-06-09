package com.twu.biblioteca;

/**
 * Created by summer on 2017/6/8.
 */
public class Users {
  private String libraryNum;
  private String password;
  private String name;
  private String email;
  private String address;
  private String phoneNum;

  public Users(String libraryNum, String password, String name, String email, String address, String phoneNum){
    this.libraryNum=libraryNum;
    this.password=password;
    this.name=name;
    this.email=email;
    this.address=address;
    this.phoneNum=phoneNum;
  }

  public String getLibraryNum(){
    return libraryNum;
  }
  public String getPassword(){
    return password;
  }

  public String getUserInfo(){
    return name+','+email+','+address+','+phoneNum+'.';
  }
}
