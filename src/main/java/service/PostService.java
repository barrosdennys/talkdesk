package main.java.service;

import main.java.model.BlogPosts;
import main.java.model.Users;
import main.java.utils.Constants;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import java.util.ArrayList;
import java.util.List;

public class PostService {

    private static final RestTemplate restTemplate = new RestTemplate();
    private static List<BlogPosts> blogPosts = new ArrayList<>();

    /**
     *
     * GET request to a given URI and returns the ResponseEntity
     *
     * @param uri  the URI to be passed
     * @return ResponseEntity response
     *
     */
    public static ResponseEntity getEntity(String uri) {
        ResponseEntity response = restTemplate.exchange(uri, HttpMethod.GET,
                null, new ParameterizedTypeReference<List<BlogPosts>>() {
                });
        return response;
    }

    /**
     *
     * Gets all post entries
     * @return a list of all blog posts
     *
     */
    public static List<BlogPosts> getAllPosts() {
        if (blogPosts.isEmpty()) {
            ResponseEntity<List<BlogPosts>> posts = getEntity(Constants.BLOG_POSTS_URI + "/posts");
            blogPosts = posts.getBody();
            return blogPosts;
        }
        return blogPosts;
    }

    /**
     *
     * Gets a Users object based on the userId
     *
     * @param userId the userId from the user
     * @return Users user
     *
     */
    public static Users getUserById(int userId) {
        return restTemplate.getForObject(Constants.BLOG_POSTS_URI + "/users/" + userId, Users.class);
    }

    /**
     *
     * Gets the userId from the author of the blog post based on its title
     *
     * @param postTitle the title of the blog post
     * @return int userId if user exists or 0 if user doesn't exist
     *
     */
    public static int getUserIdByPostTitle(String postTitle) {
        List<BlogPosts> posts = getAllPosts();

        for (BlogPosts post : posts) {
            if (post.getTitle().equals(postTitle)) {
                return post.getUserId();
            }
        }
        return 0;
    }

    /**
     *
     * Gets all post titles from a user based on their userId
     *
     * @param userId id of the user
     * @return list of strings with all postTitles
     *
     */
    public static List<String> getAllPostTitlesFromUser(int userId) {
        List<String> postTitles = new ArrayList<>();
        List<BlogPosts> posts = getAllPosts();

        for (BlogPosts post : posts) {
            if (post.getUserId() == userId) {
                postTitles.add(post.getTitle());
            }
        }
        return postTitles;
    }
}


