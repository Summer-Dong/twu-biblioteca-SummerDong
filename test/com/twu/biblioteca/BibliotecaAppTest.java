package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by summer on 2017/6/7.
 */
public class BibliotecaAppTest {
  @Test
  public void getBooks() throws Exception {
  }

  BibliotecaApp bibliotecaApp = new BibliotecaApp();

  @Test
  public void getWelcomeMsg() throws Exception {
    assertEquals("Welcome to Biblioteca!", bibliotecaApp.getWelcomeMsg());
  }

}
