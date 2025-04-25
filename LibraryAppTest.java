package org.example.library;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LibraryAppTest {

    @Test
    public void testLibraryApp() {
        LibraryManager libraryManager = new LibraryManager();
        LibraryApp app = new LibraryApp(libraryManager);

        libraryManager.addBook(new Book("1984", "George Orwell", 1949));
        libraryManager.addBook(new Book("Brave New World", "Aldous Huxley", 1932));

        assertTrue(app.listBooks().contains("1984"));
        assertTrue(app.listBooks().contains("Brave New World"));
    }
}
