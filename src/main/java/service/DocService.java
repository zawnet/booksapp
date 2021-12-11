package service;

import connector.HttpService;
import model.Doc;

import java.util.ArrayList;
import java.util.List;



public class DocService {

    private HttpService httpService;

    public DocService(HttpService httpService) {
        this.httpService = httpService;
    }

    public List<Doc> getDocsByTitle(String title){
        List<Doc> docList = new ArrayList<>();
        return docList;
    }

}
