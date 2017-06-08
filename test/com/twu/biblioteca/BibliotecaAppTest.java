package com.twu.biblioteca;

import org.junit.Test;
import org.hamcrest.beans.SamePropertyValuesAs;
import static org.junit.Assert.*;

/**
 * Created by summer on 2017/6/7.
 */
public class BibliotecaAppTest {
  BibliotecaApp bibliotecaApp = new BibliotecaApp();
  private Books[] books = new Books[] {

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
