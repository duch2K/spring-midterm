//package iitu.midterm.demo;
//
//import iitu.midterm.demo.controllers.BookController;
//import iitu.midterm.demo.controllers.UserController;
//import iitu.midterm.demo.entities.Book;
//import iitu.midterm.demo.entities.User;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.stereotype.Component;
//
//import java.util.List;
//import java.util.Scanner;
//
//@Component
//public class Library {
//    @Autowired
//    private UserController studentController;
//    @Autowired
//    private BookController bookController;
//    @Autowired
//    @Qualifier("getBeanScanner")
//    private Scanner sc;
//    private User user;
//
//    public Library() {}
//
//    private void login() {
//        String username, password;
//
//        while(true) {
//            System.out.print("\nUsername: ");
//            username = sc.next();
//
//            System.out.print("Password: ");
//            password = sc.next();
//
//            if (studentController.login(username, password)) {
//                user = studentController.getStudent(username);
//                System.out.println("Student: " + user);
//                break;
//            } else {
//                System.out.println("Username or password is not correct!");
//            }
//        }
//    }
//
//    private void logout() {
//        user = null;
//    }
//
//    private void showAllBooks() {
//        System.out.println("\nBooks");
//        List<Book> books = bookController.getBooks();
//
//        for (Book book : books) {
//            System.out.println(book.getInfo());
//        }
//    }
//
//    private void showMyBorrowedBooks() {
//        List<Book> books = bookController.getBooksByStudent(user);
//
//        if (books.size() != 0) {
//            System.out.println("\nMy borrowed books");
//
//            for (Book book : books) {
//                System.out.println(book.getInfo());
//            }
//        } else {
//            System.out.println("\nYour borrowed books list is empty!");
//        }
//    }
//
//    private void addBookInBorrowedBooks() {
//        List<Book> books = bookController.getBooksByNotStudent(user);
//
//        if (books.size() != 0) {
//            System.out.println("\nBooks");
//
//            for (int i = 0; i < books.size(); i++) {
//                System.out.println(i + ". " + books.get(i).getInfo());
//            }
//            System.out.print("input number of book: ");
//            int number = sc.nextInt();
//
//            studentController.addBookInBorrowedBooks(user.getUsername(), books.get(number));
//        } else {
//            System.out.println("\nBooks array is empty!");
//        }
//    }
//
//    public void deleteBookInBorrowedBooks() {
//        List<Book> books = bookController.getBooksByStudent(user);
//
//        if (books.size() != 0) {
//            System.out.println("\nMy borrowed books");
//
//            for (int i = 0; i < books.size(); i++) {
//                System.out.println(i + ". " + books.get(i).getInfo());
//            }
//            System.out.print("input number of book: ");
//            int number = sc.nextInt();
//
//            studentController.deleteBookInBorrowedBooks(user.getUsername(), books.get(number));
//        } else {
//            System.out.println("\nYour borrowed books list is empty!");
//        }
//    }
//
//
//
//
//    public void run() {
//        String op;
//
//        while(true) {
//            if (user == null) {
//                System.out.println("\nLogin - 1");
//                System.out.println("Exit - 0");
//                System.out.print("input: ");
//                op = sc.next();
//
//                if (op.equals("1")) {
//                    login();
//                } else if (op.equals("0")) {
//                    System.out.println("\nApp exit!");
//                    break;
//                } else {
//                    System.out.println("\nInvalid argument!");
//                }
//            } else {
//                System.out.println("\nShow all books - 1");
//                System.out.println("Show my borrowed books - 2");
//                System.out.println("Add book in my borrowed books - 3");
//                System.out.println("Delete book in my borrowed books - 4");
//                System.out.println("Logout - 10");
//                System.out.println("Exit - 0");
//                System.out.print("input: ");
//                op = sc.next();
//
//                if (op.equals("1")) {
//                    showAllBooks();
//                } else if (op.equals("2")) {
//                    showMyBorrowedBooks();
//                } else if (op.equals("3")) {
//                    addBookInBorrowedBooks();
//                } else if (op.equals("4")) {
//                    deleteBookInBorrowedBooks();
//                } else if (op.equals("10")) {
//                    logout();
//                } else if (op.equals("0")) {
//                    System.out.println("\nApp exit!");
//                    break;
//                } else {
//                    System.out.println("\nInvalid argument!");
//                }
//            }
//        }
//    }
//}
