package application;

import model.Author;
import model.Book;
import connector.AuthorService;
import connector.BookService;
import connector.DocService;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Locale;
import java.util.Scanner;

public class App {

    private final ApplicationService application;

    public App(ApplicationService application) {
        this.application = application;
    }

    public void start(){

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
                            System.out.println("Please type book title: ");
                            application.getByName(inScanner.nextLine()).forEach(System.out::println);
                            break;
                        case "2":
                            System.out.println("Please type book ISBN: ");
                            String bookKey = inScanner.nextLine();
                            Book book = application.getByISBN(bookKey);
                            System.out.println(book);
                            break;
                        case "3":
                            System.out.println("Please author key: ");
                            application.getBooksByAuthor(inScanner.nextLine()).forEach(System.out::println);
                            break;
                        case "4":
                            System.out.println("Please type author ID: ");
                            long authorKey = inScanner.nextLong();
                            Author author = application.getAuthorInfo(authorKey);
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
