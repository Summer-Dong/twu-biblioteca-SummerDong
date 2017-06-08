package com.twu.biblioteca;

import java.util.Scanner;

public class BibliotecaApp {

  public static void main(String[] args) {
    System.out.println("Hello, world!");
  }

  //welcome msg
  private String welcomeMsg = "Welcome to Biblioteca!";

  public String getWelcomeMsg() {
    return welcomeMsg;
  }

  //book list
  private Books[] books = new Books[]{
    new Books("The House of Morgan", "Ron Chernow", 1990),
    new Books("Billy Lynn's Long Halftime Walk", "Ben Fountain ", 2012),
    new Books("White Teeth", "Zadie Smith", 2000),
    new Books("Atonement", "Ian McEwan", 2001),
    new Books("Half of a Yellow Sun", "Chimamanda Ngozi Adichie", 2006)
  };

  private Options[] options = new Options[] {
    new Options("B_L","Book List")
  };

  public Books[] getBooks() {
    return books;
  }
  public String getBooksDetails(){
    String bookDetails="";
    for(int i=0;i<books.length;i++){
      bookDetails = bookDetails + books[i].getDetails() + '\n';
    }
    return bookDetails;
  }
  //main menu
  public String getMainMenu(){
    String option="";
    for (int i=0;i<options.length;i++){
      option = option + options[i].getOptionDetail()+ '\n';
    }
    return option;
  }

  public String getMenuCheck(){
    Scanner scan = new Scanner(System.in);
    String option = scan.next().substring(0, 3);
    for (int i=0;i<options.length;i++){
      if(option.equals(options[i].getOptionSymbol()))
        return option;
    }
    return "You have select an invalid option!";
  }
}
