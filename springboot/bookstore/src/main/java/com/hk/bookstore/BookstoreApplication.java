package com.hk.bookstore;

import com.hk.bookstore.Model.Book;
import com.hk.bookstore.Model.BookCategory;
import com.hk.bookstore.Repository.BookCategoryRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class BookstoreApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(BookstoreApplication.class, args);
    }

    private static final Logger logger = LoggerFactory.getLogger(BookstoreApplication.class);

    @Autowired
    private BookCategoryRepository bookCategoryRepository;

    @Override
    @Transactional
    public void run(String... strings) throws Exception {
        // save a couple of categories
        BookCategory categoryA = new BookCategory("Category A");
        Set bookAs = new HashSet<Book>() {{
            add(new Book("Book A1", categoryA));
            add(new Book("Book A2", categoryA));
            add(new Book("Book A3", categoryA));
        }};
        categoryA.setBooks(bookAs);

        BookCategory categoryB = new BookCategory("Category B");
        Set bookBs = new HashSet<Book>() {{
            add(new Book("Book B1", categoryB));
            add(new Book("Book B2", categoryB));
            add(new Book("Book B3", categoryB));
        }};
        categoryB.setBooks(bookBs);

        /*
        bookCategoryRepository.save(new HashSet<BookCategory>() {{
            add(categoryA);
            add(categoryB);
        }});
        */

        bookCategoryRepository.save(categoryA);
        bookCategoryRepository.save(categoryB);

        // fetch all categories
        for (BookCategory bookCategory : bookCategoryRepository.findAll()) {
            logger.info(bookCategory.toString());
        }
    }
}
