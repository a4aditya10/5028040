class Book {
    String bookId;
    String title;
    String author;

    public Book(String bookId, String title, String author) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
    }
}

class LibraryManagementSystem {
    private Book[] books;

    public LibraryManagementSystem(Book[] books) {
        this.books = books;
    }

    public Book linearSearch(String title) {
        for (Book book : books) {
            if (book.title.equals(title)) {
                return book;
            }
        }
        return null;
    }

    public Book binarySearch(String title) {
        int left = 0;
        int right = books.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int result = title.compareTo(books[mid].title);

            if (result == 0) {
                return books[mid];
            } else if (result > 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null;
    }
}
public class Main {
    public static void main(String[] args) {
        // Create an array of Book objects
        Book[] books = {
            new Book("B001", "The Catcher in the Rye", "J.D. Salinger"),
            new Book("B002", "To Kill a Mockingbird", "Harper Lee"),
            new Book("B003", "1984", "George Orwell"),
            new Book("B004", "Pride and Prejudice", "Jane Austen"),
            new Book("B005", "The Great Gatsby", "F. Scott Fitzgerald")
        };

        // Initialize the Library Management System with the books
        LibraryManagementSystem library = new LibraryManagementSystem(books);

        // Perform a linear search for a book
        String searchTitleLinear = "1984";
        Book foundBookLinear = library.linearSearch(searchTitleLinear);
        if (foundBookLinear != null) {
            System.out.println("Linear Search - Book found:");
            System.out.println("ID: " + foundBookLinear.bookId + ", Title: " + foundBookLinear.title +
                               ", Author: " + foundBookLinear.author);
        } else {
            System.out.println("Linear Search - Book not found.");
        }

        // Perform a binary search for a book (assuming the array is sorted by title)
        String searchTitleBinary = "Pride and Prejudice";
        Book foundBookBinary = library.binarySearch(searchTitleBinary);
        if (foundBookBinary != null) {
            System.out.println("\nBinary Search - Book found:");
            System.out.println("ID: " + foundBookBinary.bookId + ", Title: " + foundBookBinary.title +", Author: " + foundBookBinary.author);
        } else {
            System.out.println("Binary Search - Book not found.");
        }
    }
}