package main.java.tests;

import main.java.utils.Constants;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import main.java.service.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpClientErrorException;

public class PostServiceTest {

    @Test
    public void getEntity_existingPostEndPoint_statusOK() {
        Assertions.assertEquals(HttpStatus.OK, PostService.getEntity(Constants.BLOG_POSTS_URI + "/posts").getStatusCode());
    }

    @Test
    public void getEntity_existingUserEndPoint_statusOK() {
        Assertions.assertEquals(HttpStatus.OK, PostService.getEntity(Constants.BLOG_POSTS_URI + "/users").getStatusCode());
    }

    @Test
    public void getEntity_postDoesntExist_status404() {
        Assertions.assertThrows(HttpClientErrorException.class, () -> PostService.getEntity(Constants.BLOG_POSTS_URI + "/posts/0").getStatusCode());
    }

    @Test
    public void getUserById_inexistentUser_404NotFound() {
        Assertions.assertThrows(HttpClientErrorException.class, () -> PostService.getUserById(0));
    }

    @Test
    public void getUserById_userId3_nameClementine() {
        Assertions.assertEquals("Clementine Bauch", PostService.getUserById(3).getName());
    }

    @Test
    public void getUserIdByPostTitle_eumEtEstOccaecati_1() {
        Assertions.assertEquals(1, PostService.getUserIdByPostTitle("eum et est occaecati"));
    }

    @Test
    public void getUserIdByPostTitle_titleDoesntExist_0() {
        Assertions.assertEquals(0, PostService.getUserIdByPostTitle("titleDoesntExis"));
    }
}
