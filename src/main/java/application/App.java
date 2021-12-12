package application;

import model.Author;
import model.Book;
import service.AuthorService;
import service.BookService;
import service.DocService;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Locale;
import java.util.Scanner;

public class App {
    private static EntityManagerFactory entityManagerFactory
            = Persistence.createEntityManagerFactory(
            "booksPU");

    private static EntityManager entityManager
            = entityManagerFactory.createEntityManager();

    public static void main(String[] args){

        String operationCode = "";

        do {
            System.out.println("What you want do?");
            System.out.println("1 - Search books by title\t2 - Get book info\t3 - Get books by author\t4 - Show author info\t Q - Quit application\t");
            Scanner input = new Scanner(System.in);
            Scanner inScanner = new Scanner(System.in);

            operationCode = input.nextLine();
                try{
                    switch (operationCode){
                        case "1":
                            DocService docService = new DocService();
                            System.out.println("Please type book title: ");
                            docService.getDocsByTitle(inScanner.nextLine()).forEach(System.out::println);
                            break;
                        case "2":
                            BookService bookService = new BookService();
                            System.out.println("Please type book key: ");
                            String bookKey = inScanner.nextLine();
                            Book book = bookService.getBookByKey(bookKey);
                            System.out.println(book);
                            break;
                        case "3":
                            AuthorService authorService = new AuthorService();
                            System.out.println("Please author key: ");
                            authorService.getAuthorBooks(inScanner.nextLine()).forEach(System.out::println);
                            break;
                        case "4":
                            authorService = new AuthorService();
                            System.out.println("Please type author key: ");
                            String authorKey = inScanner.nextLine();
                            Author author = authorService.getAuthorInfo(authorKey);
                            System.out.println(author);
                            break;
                        case "q":
                            System.out.println("Goodbye!!!");
                            break;
                        default:
                            throw new NoSuchMethodException("Unexpected operation code.");
                    }
                }
                catch (NoSuchMethodException e){
                    System.out.println(e.getMessage());
                }
        }
        while (!operationCode.toLowerCase(Locale.getDefault()).equals("q"));

    }
}
