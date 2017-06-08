package com.twu.biblioteca;

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

  public Books[] getBooks() {
    return books;
  }
}
