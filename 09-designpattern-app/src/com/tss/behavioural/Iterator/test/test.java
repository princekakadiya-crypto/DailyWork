package com.tss.behavioural.Iterator.test;

import com.tss.behavioural.Iterator.model.Book;
import com.tss.behavioural.Iterator.model.Iterator;
import com.tss.behavioural.Iterator.model.Library;

public class test {
    public static void main(String[] args) {
        Book[] books={
                new Book("abc"),
                new Book("pqr"),
                new Book("xyz")
        };
        Library library=new Library(books);

        Iterator<Book> iterator= library.iterator();
        while (iterator.hasNext())
        {
            Book book=iterator.next();
            System.out.println(book.getBookName());
        }
    }
}


