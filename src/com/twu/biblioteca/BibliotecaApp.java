package com.twu.biblioteca;

import java.util.Scanner;

public class BibliotecaApp {

  public static void main(String[] args) {
    BibliotecaApp biblioteca = new BibliotecaApp();
    biblioteca.getWelcomeMsg();
    biblioteca.getMainMenu();
    biblioteca.checkOption();
  }

  //welcome msg
  private String welcomeMsg = "Welcome to Biblioteca!";
  public String getWelcomeMsg() {
    System.out.println(welcomeMsg+"\n");
    return welcomeMsg;
  }

  //book list
  public Books[] books = new Books[]{
    new Books("The House of Morgan", "Ron Chernow", 1990, true),
    new Books("Billy Lynn's Long Halftime Walk", "Ben Fountain ", 2012, true),
    new Books("White Teeth", "Zadie Smith", 2000, true),
    new Books("Atonement", "Ian McEwan", 2001, true),
    new Books("Half of a Yellow Sun", "Chimamanda Ngozi Adichie", 2006, true)
  };

  private Options[] options = new Options[] {
    new Options("B_L","Book List"),
    new Options("Q_S","Quit System"),
    new Options("C_B","Checkout Book")
  };

  public Books[] getBooks() {
    return books;
  }

  public String getBooksDetails(){
    String bookDetails="";
    for(int i=0;i<books.length;i++){
      if(books[i].getIsAvailable())
      bookDetails = bookDetails + books[i].getDetails() + '\n';
    }
    return bookDetails;
  }
  //main menu
  public String getMainMenu(){
    String option="";
    for (int i=0;i<options.length;i++){
      option = option + options[i].getOptionDetail();
    }
    System.out.print(option);
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

  public void checkOption(){
    BibliotecaApp biblioteca = new BibliotecaApp();
    while(true){
      String command = biblioteca.getMenuCheck();
      if (command.equals("Q_S")){
        System.out.println("You have quit the system.Thank you!");
        break;
      }else if (command.equals("B_L")){
        System.out.printf("%s",biblioteca.getBooksDetails());
        continue;
      }else if (command.equals("C_B")){
        if (biblioteca.checkOutBook())
          System.out.println("Thank you! Enjoy the book");
        else
          System.out.println("That book is not available.");
        continue;
      }else{
        System.out.printf("%s",command);
        continue;
      }
    }
  }

  public boolean checkOutBook(){
    Scanner scan = new Scanner(System.in);
    String bookTitle = scan.nextLine();
    for (int i=0;i<books.length;i++){
      if (books[i].getTitle().equals(bookTitle) && books[i].getIsAvailable()){
        books[i].setAvailable(false);
        return true;
      }
    }
    return false;
  }
}
