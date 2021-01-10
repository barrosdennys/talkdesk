package main.java;

import main.java.service.PostService;
import main.java.model.Users;
import org.springframework.web.client.HttpClientErrorException;

public class Main {

    public static void printResults() {
        try {
            int userId = PostService.getUserIdByPostTitle("rem alias distinctio quo quis");
            Users user = PostService.getUserById(userId);

            System.out.println(user.toString());

            System.out.println("Blog posts written by " + user.getName());

            for (String title : PostService.getAllPostTitlesFromUser(userId)) {
                System.out.println("- " + title);
            }

        } catch (HttpClientErrorException e) {
            System.out.println("User not found");
        }
    }

    public static void main (String[] args){
        printResults();
    }
}
