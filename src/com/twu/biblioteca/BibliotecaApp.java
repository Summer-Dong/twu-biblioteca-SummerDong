package com.twu.biblioteca;

public class BibliotecaApp {

    public static void main(String[] args) {
        System.out.println("Hello, world!");
    }
    //welcome msg
    private String welcomeMsg = "Welcome to Biblioteca!";
    public String getWelcomeMsg(){
        return welcomeMsg;
    }
    //book list
    private Books[] books = new Books[]{

    };
    public Books[] getBooks(){
        return books;
    }
}
