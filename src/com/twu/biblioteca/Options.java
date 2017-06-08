package com.twu.biblioteca;

/**
 * Created by summer on 2017/6/8.
 */
public class Options {
  private String symbol;
  private String description;

  public Options (String symbol,String description){
    this.symbol=symbol;
    this.description=description;
  }

  public String getOptionSymbol(){
    return symbol;
  }

  public String getOptionDescription(){
    return description;
  }

  public String getOptionDetail(){
    return symbol + ":" + description + '\n';
  }
}
