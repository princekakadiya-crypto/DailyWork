package com.tss.behavioural.Iterator.model;

public class BookIterator implements Iterator<Book>{
    private Book[] books;
    private int index=0;

    public BookIterator(Book[] books) {
        this.books = books;
    }

    @Override
    public boolean hasNext() {
        return index< books.length;
    }

    @Override
    public Book next() {
        return books[index++];
    }
}
