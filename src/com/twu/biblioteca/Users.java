package com.twu.biblioteca;

/**
 * Created by summer on 2017/6/8.
 */
public class Users {
  private String libraryNum;
  private String password;
  private String name;
  private String email;
  private String phoneNum;

  public Users(String libraryNum, String password, String name, String email, String phoneNum){
    this.libraryNum=libraryNum;
    this.password=password;
    this.name=name;
    this.email=email;
    this.phoneNum=phoneNum;
  }

  public String getLibraryNum(){
    return libraryNum;
  }
  public String getPassword(){
    return password;
  }

  public String getUserInfo(){
    return "Your name:"+name+'\n'+"Your email:"+email+'\n'+"Your phone number:"+phoneNum+'.';
  }
}
