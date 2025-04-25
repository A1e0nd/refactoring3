package org.example.library;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class LibraryManagerTest {

    private LibraryManager libraryManager;

    @BeforeEach
    public void setUp() {
        libraryManager = new LibraryManager();
        libraryManager.addBook(new Book("1984", "George Orwell", 1949));
    }

    @Test
    public void testAddBook() {
        int sizeBefore = libraryManager.getBooks().size();
        libraryManager.addBook(new Book("Animal Farm", "George Orwell", 1945));
        int sizeAfter = libraryManager.getBooks().size();
        assertEquals(sizeBefore + 1, sizeAfter);
    }

    @Test
    public void testSearchBooksByTitle() {
        List<Book> result = libraryManager.searchBooksByTitle("1984");
        assertEquals(1, result.size());
        assertEquals("1984", result.get(0).getTitle());
    }
}
