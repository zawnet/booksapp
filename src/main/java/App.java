import connector.OpenlibraryAPIConnector;
import service.DocService;

public class App {

    public static void main(String[] args) {

        DocService docService = new DocService();
        docService.getDocsByTitle("ogniem i mieczem");
    }
}
