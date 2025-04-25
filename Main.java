package org.example;

import java.util.*;
import java.io.*;

public class Main {

    static ArrayList<String[]> books = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            System.out.println("\n=== LibraryManager3000 ===");
            System.out.println("1. Add Book");
            System.out.println("2. View All Books");
            System.out.println("3. Delete Book");
            System.out.println("4. Edit Book");
            System.out.println("5. Search Book by Title");
            System.out.println("6. Filter by Author");
            System.out.println("7. Filter by Genre");
            System.out.println("8. Sort by Title");
            System.out.println("9. Sort by Year");
            System.out.println("10. Save to File");
            System.out.println("11. Load from File");
            System.out.println("12. Export to CSV");
            System.out.println("13. Import from CSV");
            System.out.println("14. Quit");

            String option = scanner.nextLine();

            if (option.equals("1")) {
                String[] book = new String[5];
                System.out.print("Title: ");
                book[0] = scanner.nextLine();
                System.out.print("Author: ");
                book[1] = scanner.nextLine();
                System.out.print("Year: ");
                book[2] = scanner.nextLine();
                System.out.print("Genre: ");
                book[3] = scanner.nextLine();
                System.out.print("ISBN: ");
                book[4] = scanner.nextLine();
                books.add(book);
                System.out.println("Book added!");
            } else if (option.equals("2")) {
                if (books.isEmpty()) {
                    System.out.println("No books in library.");
                } else {
                    int index = 0;
                    for (String[] b : books) {
                        System.out.println(index++ + ") " + b[0] + " | " + b[1] + " | " + b[2] + " | " + b[3] + " | " + b[4]);
                    }
                }
            } else if (option.equals("3")) {
                System.out.print("Enter index to delete: ");
                int i = Integer.parseInt(scanner.nextLine());
                if (i >= 0 && i < books.size()) {
                    books.remove(i);
                    System.out.println("Deleted.");
                } else {
                    System.out.println("Invalid index.");
                }
            } else if (option.equals("4")) {
                System.out.print("Enter index to edit: ");
                int i = Integer.parseInt(scanner.nextLine());
                if (i >= 0 && i < books.size()) {
                    String[] b = books.get(i);
                    System.out.print("New Title (leave empty to keep): ");
                    String newTitle = scanner.nextLine();
                    if (!newTitle.isEmpty()) b[0] = newTitle;

                    System.out.print("New Author (leave empty to keep): ");
                    String newAuthor = scanner.nextLine();
                    if (!newAuthor.isEmpty()) b[1] = newAuthor;

                    System.out.print("New Year (leave empty to keep): ");
                    String newYear = scanner.nextLine();
                    if (!newYear.isEmpty()) b[2] = newYear;

                    System.out.print("New Genre (leave empty to keep): ");
                    String newGenre = scanner.nextLine();
                    if (!newGenre.isEmpty()) b[3] = newGenre;

                    System.out.print("New ISBN (leave empty to keep): ");
                    String newISBN = scanner.nextLine();
                    if (!newISBN.isEmpty()) b[4] = newISBN;

                    System.out.println("Book updated.");
                } else {
                    System.out.println("Invalid index.");
                }
            } else if (option.equals("5")) {
                System.out.print("Search by title: ");
                String query = scanner.nextLine().toLowerCase();
                for (String[] b : books) {
                    if (b[0].toLowerCase().contains(query)) {
                        System.out.println(b[0] + " | " + b[1] + " | " + b[2] + " | " + b[3] + " | " + b[4]);
                    }
                }
            } else if (option.equals("6")) {
                System.out.print("Filter by author: ");
                String author = scanner.nextLine().toLowerCase();
                for (String[] b : books) {
                    if (b[1].toLowerCase().contains(author)) {
                        System.out.println(b[0] + " | " + b[1] + " | " + b[2] + " | " + b[3] + " | " + b[4]);
                    }
                }
            } else if (option.equals("7")) {
                System.out.print("Filter by genre: ");
                String genre = scanner.nextLine().toLowerCase();
                for (String[] b : books) {
                    if (b[3].toLowerCase().contains(genre)) {
                        System.out.println(b[0] + " | " + b[1] + " | " + b[2] + " | " + b[3] + " | " + b[4]);
                    }
                }
            } else if (option.equals("8")) {
                Collections.sort(books, new Comparator<String[]>() {
                    public int compare(String[] a, String[] b) {
                        return a[0].compareToIgnoreCase(b[0]);
                    }
                });
                System.out.println("Sorted by title.");
            } else if (option.equals("9")) {
                Collections.sort(books, new Comparator<String[]>() {
                    public int compare(String[] a, String[] b) {
                        return a[2].compareToIgnoreCase(b[2]);
                    }
                });
                System.out.println("Sorted by year.");
            } else if (option.equals("10")) {
                try {
                    BufferedWriter writer = new BufferedWriter(new FileWriter("library.txt"));
                    for (String[] b : books) {
                        writer.write(b[0] + ";" + b[1] + ";" + b[2] + ";" + b[3] + ";" + b[4] + "\n");
                    }
                    writer.close();
                    System.out.println("Saved to library.txt");
                } catch (IOException e) {
                    System.out.println("Error saving file.");
                }
            } else if (option.equals("11")) {
                try {
                    BufferedReader reader = new BufferedReader(new FileReader("library.txt"));
                    books.clear();
                    String line;
                    while ((line = reader.readLine()) != null) {
                        String[] parts = line.split(";");
                        if (parts.length == 5) {
                            books.add(parts);
                        }
                    }
                    reader.close();
                    System.out.println("Loaded from file.");
                } catch (IOException e) {
                    System.out.println("Error loading file.");
                }
            } else if (option.equals("12")) {
                try {
                    BufferedWriter writer = new BufferedWriter(new FileWriter("library.csv"));
                    writer.write("Title,Author,Year,Genre,ISBN\n");
                    for (String[] b : books) {
                        writer.write(b[0] + "," + b[1] + "," + b[2] + "," + b[3] + "," + b[4] + "\n");
                    }
                    writer.close();
                    System.out.println("Exported to CSV.");
                } catch (IOException e) {
                    System.out.println("CSV export failed.");
                }
            } else if (option.equals("13")) {
                try {
                    BufferedReader reader = new BufferedReader(new FileReader("library.csv"));
                    books.clear();
                    String line = reader.readLine(); // skip header
                    while ((line = reader.readLine()) != null) {
                        String[] parts = line.split(",");
                        if (parts.length == 5) {
                            books.add(parts);
                        }
                    }
                    reader.close();
                    System.out.println("CSV imported.");
                } catch (IOException e) {
                    System.out.println("CSV import failed.");
                }
            } else if (option.equals("14")) {
                running = false;
            } else {
                System.out.println("Unknown option.");
            }
        }
    }
}
