package org.example.library;

import java.util.List;

public class LibraryApp {
    private LibraryManager libraryManager;

    public LibraryApp() {
        this.libraryManager = new LibraryManager();
    }

    public LibraryApp(LibraryManager libraryManager) {
        this.libraryManager = libraryManager;
    }

    public List<String> listBooks() {
        return libraryManager.listBooks();
    }
}
