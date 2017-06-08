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
  public void returnBookTest() throws Exception {
    BibliotecaApp self = new BibliotecaApp();
    self.books[0].setAvailable(false);
    self.books[1].setAvailable(false);
    self.books[2].setAvailable(false);
    self.books[3].setAvailable(false);
    assertEquals("Half of a Yellow Sun,Chimamanda Ngozi Adichie,2006."+"\n",self.getBooksDetails());
  }

  @Test
  public void checkOutBookTest() throws Exception {
    BibliotecaApp self = new BibliotecaApp();
    self.books[0].setAvailable(false);
    self.books[1].setAvailable(false);
    self.books[2].setAvailable(false);
    self.books[3].setAvailable(false);
    assertEquals("Half of a Yellow Sun,Chimamanda Ngozi Adichie,2006."+"\n",self.getBooksDetails());
  }

  @Test
  public void invalidMenuCheckTest() throws Exception{
    ByteArrayInputStream in = new ByteArrayInputStream("N_M\n".getBytes());
    System.setIn(in);
    assertEquals("You have select an invalid option!",bibliotecaApp.getMenuCheck());
  }

  @Test
  public void validMenuCheckTest() throws Exception{
    ByteArrayInputStream in = new ByteArrayInputStream("B_L\n".getBytes());
    System.setIn(in);
    assertEquals("B_L",bibliotecaApp.getMenuCheck());
  }

  @Test
  public void getMainMenuTest() throws Exception {
    String option="";
    for (int i=0;i<options.length;i++){
      option = option + options[i].getOptionDetail();
    }
    System.out.print(option);
    assertEquals(option, bibliotecaApp.getMainMenu());
  }

  @Test
  public void getBooksDetailsTest() throws Exception {
    String bookDetails = "";
    for (int i = 0; i < books.length; i++) {
      bookDetails = bookDetails + books[i].getDetails() + '\n';
    }
    assertEquals(bookDetails, bibliotecaApp.getBooksDetails());
  }

  @Test
  public void getWelcomeMsgTest() throws Exception {
    assertEquals("Welcome to Biblioteca!", bibliotecaApp.getWelcomeMsg());
  }

  @Test
  public void getBooksTest() throws Exception {
    assertThat(bibliotecaApp.getBooks(), new SamePropertyValuesAs(books));
  }
}
