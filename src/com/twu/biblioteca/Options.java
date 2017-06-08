package com.twu.biblioteca;

/**
 * Created by summer on 2017/6/8.
 */
public class Options {
  private String command;
  private String description;

  public Options (String command,String description){
    this.command=command;
    this.description=description;
  }

  public String getOptionCommand(){
    return command;
  }

  public String getOptionDetail(){
    return command + " :  " + description + '\n';
  }
}
