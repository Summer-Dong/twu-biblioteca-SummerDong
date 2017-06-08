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
  public void getWelcomeMsg() {
    System.out.println("Welcome to Biblioteca!"+"\n");
  }

  //book list
  public Books[] books = new Books[]{
    new Books("The House of Morgan", "Ron Chernow", 1990, true),
    new Books("Billy Lynn's Long Halftime Walk", "Ben Fountain ", 2012, true),
    new Books("White Teeth", "Zadie Smith", 2000, true),
    new Books("Atonement", "Ian McEwan", 2001, true),
    new Books("Half of a Yellow Sun", "Chimamanda Ngozi Adichie", 2006, true)
  };

  //options
  private Options[] options = new Options[] {
    new Options("B_L","Book List"),
    new Options("Q_S","Quit System"),
    new Options("C_B","Checkout Book"),
    new Options("R_B","Return Book")
  };

   //getBooksDetails
  public String getBooksDetails(){
    String bookDetails="";
    for(int i=0;i<books.length;i++){
      if(books[i].checkIsAvailable())
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

  //check menu
  public String getMenuCheck(){
    Scanner scan = new Scanner(System.in);
    String option = scan.next().substring(0, 3);
    for (int i=0;i<options.length;i++){
      if(option.equals(options[i].getOptionCommand()))
        return option;
    }
    return "You have select an invalid option!";
  }

  //respond to menu selection
  public void checkOption(){
    BibliotecaApp biblioteca = new BibliotecaApp();

     while(true){
       String command = biblioteca.getMenuCheck();
       if (command.equals("Q_S")){
         System.out.println("You have quit the system.Thank you!");
         break;
       }else if (command.equals("B_L")){
         System.out.print(biblioteca.getBooksDetails());
         continue;
       }else if (command.equals("C_B")){
         if (biblioteca.checkOutBook())
           System.out.println("Thank you! Enjoy the book");
         else
           System.out.println("That book is not available.");
         continue;
       }else if(command.equals("R_B")){
         if (biblioteca.returnBook())
           System.out.println("Thank you for returning the book.");
         else
           System.out.println("That is not a valid book to return.");
         continue;
       }
     }
  }

  //checkOutBook
  public boolean checkOutBook(){
    Scanner scan = new Scanner(System.in);
    String bookTitle = scan.nextLine();
    for (int i=0;i<books.length;i++){
      if (books[i].getTitle().equals(bookTitle) && books[i].checkIsAvailable()){
        books[i].setAvailable(false);
        return true;
      }
    }
    return false;
  }

  //returnBook
  public boolean returnBook(){
    Scanner scan = new Scanner(System.in);
    String bookTitle = scan.nextLine();
    for (int i=0;i<books.length;i++){
      if (books[i].getTitle().equals(bookTitle) && !(books[i].checkIsAvailable())){
        books[i].setAvailable(true);
        return true;
      }
    }
    return false;
  }
}
