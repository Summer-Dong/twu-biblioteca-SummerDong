package com.twu.biblioteca;

import org.junit.Test;
import org.hamcrest.beans.SamePropertyValuesAs;
import static org.junit.Assert.*;

/**
 * Created by summer on 2017/6/7.
 */
public class BibliotecaAppTest {
  BibliotecaApp bibliotecaApp = new BibliotecaApp();
  private Books[] books = new Books[]{
    new Books("The House of Morgan", "Ron Chernow", 1990),
    new Books("Billy Lynn's Long Halftime Walk", "Ben Fountain ", 2012),
    new Books("White Teeth", "Zadie Smith", 2000),
    new Books("Atonement", "Ian McEwan", 2001),
    new Books("Half of a Yellow Sun", "Chimamanda Ngozi Adichie", 2006)
  };

  //welcome msg test
  @Test
  public void getWelcomeMsg() throws Exception {
    assertEquals("Welcome to Biblioteca!", bibliotecaApp.getWelcomeMsg());
  }
  //show booklist test
  @Test
  public void getBooks() throws Exception {
    assertThat(bibliotecaApp.getBooks(), new SamePropertyValuesAs(books));
  }
}
