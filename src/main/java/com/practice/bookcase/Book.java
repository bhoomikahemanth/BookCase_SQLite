package com.practice.bookcase;

import java.util.ArrayList;

public class Book
{
    private int bookID;
    private String bookTitle;
    private String bookAuthor;
    private String bookYear;

    private String bookBlurb;
    private String coverURL;
    InitialiseDB initDB = new InitialiseDB();

    public static ArrayList<Book> books = new ArrayList<>();

    public Book()
    {

    }

    public Book(int bookID,String bookTitle,String bookAuthor,String bookYear,String bookBlurb, String coverURL)
    {
        this.bookID = bookID;
        this.bookTitle = bookTitle;
        this.bookAuthor = bookAuthor;
        this.bookYear = bookYear;
        this.bookBlurb = bookBlurb;
        this.coverURL = coverURL;
    }

    public int getBookID()
    {
            return bookID;
    }

    public void setBookID(int bookID)
    {
        this.bookID = bookID;
    }

    public String getBookTitle()
    {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle)
    {
        this.bookTitle = bookTitle;
    }

    public String getBookAuthor()
    {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor)
    {
        this.bookAuthor = bookAuthor;
    }

    public String getBookYear()
    {
        return bookYear;
    }

    public String getBookBlurb()
    {
        return bookBlurb;
    }

    public String getCoverURL()
    {
        return coverURL;
    }

    public InitialiseDB getInitDB()
    {
        return initDB;
    }

    public static ArrayList<Book> getBooks()
    {
        return books;
    }

    public void setBookBlurb(String bookBlurb)
    {
        this.bookBlurb = bookBlurb;
    }

    public void setCoverURL(String coverURL)
    {
        this.coverURL = coverURL;
    }

    public void setInitDB(InitialiseDB initDB)
    {
        this.initDB = initDB;
    }

    public static void setBooks(ArrayList<Book> books)
    {
        Book.books = books;
    }

    public void setBookYear(String bookYear)
    {
        this.bookYear = bookYear;
    }

    public void addNewBook(Book book)
    {
        initDB.addNewBook(initDB.getDBConnection(),book);
    }
    
    public ArrayList<Book> getAllBooks()
    {
        books = initDB.getBooks(initDB.getDBConnection());
        return books;
    }

    public void updateBookRecord(Book book)
    {
        initDB.updateBookRecord(initDB.getDBConnection(),book);
    }

    public void removeBook(Book book)
    {
        initDB.removeBook(initDB.getDBConnection(),book);
    }

}

