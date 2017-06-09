package com.twu.biblioteca;

import java.util.Scanner;

public class BibliotecaApp {

  public static Users nowUser;

  public static void main(String[] args) {
    BibliotecaApp biblioteca = new BibliotecaApp();
    biblioteca.start(biblioteca);
  }
  public void start(BibliotecaApp biblioteca){
    biblioteca.getWelcomeMsg();
    biblioteca.login();
    biblioteca.getMainMenu();
    biblioteca.checkOption();
  }

  //welcome msg
  public void getWelcomeMsg() {
    System.out.println("Welcome to Biblioteca!"+"\n");
  }

  //options
  private Options[] options = new Options[] {
    new Options("B_L","Book List"),
    new Options("Q_S","Quit System"),
    new Options("C_B","Checkout Book"),
    new Options("R_B","Return Book"),
    new Options("M_L","Movie List"),
    new Options("C_M","Checkout Movie"),
    new Options("R_M","Return Movie"),
    new Options("U_I","User Information"),
    new Options("C_I","Checked-out Info")

  };

  //book list
  public static Books[] books = new Books[]{
    new Books("The House of Morgan", "Ron Chernow", 1990, true,"null"),
    new Books("Billy Lynn's Long Halftime Walk", "Ben Fountain ", 2012, true, "null"),
    new Books("White Teeth", "Zadie Smith", 2000, true, "null"),
    new Books("Atonement", "Ian McEwan", 2001, true, "null"),
    new Books("Half of a Yellow Sun", "Chimamanda Ngozi Adichie", 2006, true, "null")
  };

  //movie list
  public static Movies[] movies = new Movies[]{
    new Movies("Dangal", "Nitesh Tiwari", 2017,"9.2", true, "null"),
    new Movies("The Shawshank Redemption", "Frank Darabont", 1994, "9.6",true, "null"),
    new Movies("Forrest Gump", "Robert Zemeckis", 1994, "9.4", true, "null"),
    new Movies("3 idiots", "拉库马·希拉尼", 2011,"unrated", true, "null")
  };

  //user list
  public Users[] users = new Users[]{
    new Users("001-0001", "123456" , "Jason", "Jason@gmail.com","18713509001"),
    new Users("001-0003", "123456" , "Lily", "Lily@gmail.com", "18713509003"),
    new Users("001-0002", "123456" , "Lucy", "Lucy@gmail.com","18713509002")
  };
  //login
  public boolean login(){
    System.out.println("Please input your library number and password:"+"\n"+"(use a ',' between the library and pasword)");
    while(true){
      Scanner scan = new Scanner(System.in);
      String input = scan.next();
      for (int i=0;i<users.length;i++){
        if(input.length() == 15){
          String logNum = input.substring(0,8);
          String password = input.substring(9, 15);
          if (users[i].getLibraryNum().equals(logNum) && users[i].getPassword().equals(password)){
            System.out.println("Login Successfully!"+"\n"+"Please select the option you need:");
            nowUser = users[i];
            return true;
          }
        } else {
          System.out.println("Incorrect library number or password, please try again! ");
          break;
        }
      }
      continue;
    }
  }

   //getBooksDetails
  public String getBooksDetails(){
    String bookDetails="";
    for(int i=0;i<books.length;i++){
      if(books[i].checkIsAvailable())
        bookDetails = bookDetails + books[i].getDetails() + '\n';
    }
    return bookDetails;
  }

  //getMovieDetails
  public String getMoviesDetails(){
    String movieDetails="";
    for(int i=0;i<movies.length;i++){
      if(movies[i].checkIsAvailable())
        movieDetails = movieDetails + movies[i].getDetails() + '\n';
    }
    return movieDetails;
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
         System.out.println("You have quit the system.Thank you!"+"\n");
         biblioteca.start(biblioteca);
         break;
       }else if (command.equals("B_L")){
         System.out.print(biblioteca.getBooksDetails());
         continue;
       }else if (command.equals("M_L")){
         System.out.print(biblioteca.getMoviesDetails());
         continue;
       }else if (command.equals("C_B")){
         if (biblioteca.checkOutBook())
           System.out.println("Thank you! Enjoy the book");
         else
           System.out.println("That book is not available.");
         continue;
       }else if (command.equals("C_M")){
         if (biblioteca.checkOutMovie())
           System.out.println("Thank you! Enjoy the movie");
         else
           System.out.println("That movie is not available.");
         continue;
       }else if(command.equals("R_B")){
         if (biblioteca.returnBook())
           System.out.println("Thank you for returning the book.");
         else
           System.out.println("That is not a valid book to return.");
         continue;
       }else if(command.equals("R_M")){
         if (biblioteca.returnMovie())
           System.out.println("Thank you for returning the movie.");
         else
           System.out.println("That is not a valid movie to return.");
         continue;
       }else if (command.equals("U_I")){
         System.out.println(nowUser.getUserInfo());
         continue;
       }else if (command.equals("C_I")){
         for (int i=0;i<books.length;i++){
           if(books[i].checkIsAvailable()==false)
             System.out.println(books[i].getCheckoutDetails());
         }
         for (int i=0;i<movies.length;i++){
           if(movies[i].checkIsAvailable()==false)
             System.out.println(movies[i].getCheckoutDetails());
         }
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
        books[i].setCheckoutUser(nowUser.getUserName());
        return true;
      }
    }
    return false;
  }

  //checkOutMovie
  public boolean checkOutMovie(){
    Scanner scan = new Scanner(System.in);
    String movieName = scan.nextLine();
    for (int i=0;i<movies.length;i++){
      if (movies[i].getName().equals(movieName) && movies[i].checkIsAvailable()){
        movies[i].setAvailable(false);
        movies[i].setCheckoutUser(nowUser.getUserName());
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

  //returnMovie
  public boolean returnMovie(){
    Scanner scan = new Scanner(System.in);
    String movieName = scan.nextLine();
    for (int i=0;i<movies.length;i++){
      if (movies[i].getName().equals(movieName) && !(movies[i].checkIsAvailable())){
        movies[i].setAvailable(true);
        return true;
      }
    }
    return false;
  }
}
