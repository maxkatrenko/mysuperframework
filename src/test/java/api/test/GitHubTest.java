package api.test;

import api.controllers.UserController;
import api.models.User;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class GitHubTest {
    private UserController userController;

    @Before
    public void init() {
        userController = new UserController();
    }

    @Test
    public void testUserInfoResponse() {
        User remoteUser = userController.getUserByUsername("maxkatrenko");
        Assert.assertTrue(remoteUser.getHtml_url().contains("https://github.com/maxkatrenko"));
    }

    @Test
    public void testFollowers() {
        User[] followers = userController.getFollowersByUsername("maxkatrenko");
        Assert.assertEquals(1, followers.length);
    }

    @Test
    public void testFollowing() {
        User[] following = userController.getFollowingByUsername("maxkatrenko");
        Assert.assertEquals(1,following.length);
    }
}
