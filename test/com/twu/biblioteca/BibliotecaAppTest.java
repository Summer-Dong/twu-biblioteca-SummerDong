package com.twu.biblioteca;

import org.junit.Test;
import org.hamcrest.beans.SamePropertyValuesAs;
import java.io.ByteArrayInputStream;
import static org.junit.Assert.*;

/**
 * Created by summer on 2017/6/7.
 */
public class BibliotecaAppTest {

  BibliotecaApp bibliotecaApp = new BibliotecaApp();

  public Books[] books = new Books[]{
    new Books("The House of Morgan", "Ron Chernow", 1990, true),
    new Books("Billy Lynn's Long Halftime Walk", "Ben Fountain ", 2012, true),
    new Books("White Teeth", "Zadie Smith", 2000, true),
    new Books("Atonement", "Ian McEwan", 2001, true),
    new Books("Half of a Yellow Sun", "Chimamanda Ngozi Adichie", 2006, true)
  };

  private Options[] options = new Options[]{
    new Options("B_L", "Book List"),
    new Options("Q_S","Quit System"),
    new Options("C_B","Checkout Book"),
    new Options("R_B","Return Book")
  };

  @Test
  public void should_show_return_Book() throws Exception {
    //Given
    BibliotecaApp self = new BibliotecaApp();
    //When
    self.books[0].setAvailable(false);
    self.books[1].setAvailable(false);
    self.books[2].setAvailable(false);
    self.books[3].setAvailable(false);
    //Then
    assertEquals("Half of a Yellow Sun,Chimamanda Ngozi Adichie,2006."+"\n",self.getBooksDetails());
  }

  @Test
  public void should_hide_checkout_book() throws Exception {
    //Given
    BibliotecaApp self = new BibliotecaApp();
    //When
    self.books[0].setAvailable(false);
    self.books[1].setAvailable(false);
    self.books[2].setAvailable(false);
    self.books[3].setAvailable(false);
    //Then
    assertEquals("Half of a Yellow Sun,Chimamanda Ngozi Adichie,2006."+"\n",self.getBooksDetails());
  }

  @Test
  public void should_show_invalid_msg() throws Exception{
    //Given
    ByteArrayInputStream in = new ByteArrayInputStream("N_M\n".getBytes());
    //When
    System.setIn(in);
    //Then
    assertEquals("You have select an invalid option!",bibliotecaApp.getMenuCheck());
  }

  @Test
  public void should_show_valid_menuInfo() throws Exception{
    //Given
    ByteArrayInputStream in = new ByteArrayInputStream("B_L\n".getBytes());
    //When
    System.setIn(in);
    //Then
    assertEquals("B_L",bibliotecaApp.getMenuCheck());
  }

  @Test
  public void should_get_main_menu() throws Exception {
    //Given
    String option="";
    for (int i=0;i<options.length;i++){
      option = option + options[i].getOptionDetail();
    }
    //Then
    assertEquals(option, bibliotecaApp.getMainMenu());
  }

  @Test
  public void should_get_books_details() throws Exception {
    //Given
    String bookDetails = "";
    for (int i = 0; i < books.length; i++) {
      bookDetails = bookDetails + books[i].getDetails() + '\n';
    }
    //Then
    assertEquals(bookDetails, bibliotecaApp.getBooksDetails());
  }

}
