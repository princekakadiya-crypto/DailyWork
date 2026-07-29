package com.tss.behavioural.Iterator.model;

public class Library {
    private Book[] books;

    public Library(Book[] books) {
        this.books = books;
    }
    public Iterator<Book> iterator()
    {
        return new  BookIterator(books);
    }
}
