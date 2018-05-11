package com.hk.bookstore.Repository;

import com.hk.bookstore.Model.BookCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookCategoryRepository extends JpaRepository<BookCategory, Integer> {
}

