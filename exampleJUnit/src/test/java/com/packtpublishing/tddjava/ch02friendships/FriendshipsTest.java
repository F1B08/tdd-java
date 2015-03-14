package com.packtpublishing.tddjava.ch02friendships;

import com.packtpublishing.tddjava.ch02friendships.Friendships;
import org.junit.*;

public class FriendshipsTest {
    @BeforeClass
    public static void beforeClass() {
        // This method will be executed once on initialization time
    }

    @AfterClass
    public static void afterClass() {
        // This method will be executed once when all test are executed
    }

    @Before
    public void before() {
        // This method will be executed once before each test execution
    }

    @After
    public void after() {
        // This method will be executed once after each test execution
    }
    
    @Test
    public void test1() {
        Friendships friendships = new Friendships();

        Assert.assertTrue("Joe does not have friends", friendships.getFriendsList("Joe").isEmpty());
        Assert.assertEquals("Joe has 0 friends", 0, friendships.getNumberOfFriends("Joe"));
    }
    
    @Test
    public void test2() {
        Friendships friendships = new Friendships();
        friendships.makeFriends("Joe", "Audrey");
        
        Assert.assertTrue("Joe and Audrey are friends", friendships.areFriends("Joe", "Audrey"));
        Assert.assertTrue("Audrey and Joe are friends", friendships.areFriends("Audrey", "Joe"));

        Assert.assertTrue("Joe is Audrey's friend", friendships.getFriendsList("Joe").contains("Audrey"));
        Assert.assertEquals("Joe has 1 friend", 1, friendships.getNumberOfFriends("Joe"));

        Assert.assertTrue("Audrey is Joe's friend", friendships.getFriendsList("Audrey").contains("Joe"));
        Assert.assertEquals("Joe has 1 friend", 1, friendships.getNumberOfFriends("Audrey"));
    }
    
    @Test(timeout = 10)
    public void test3() {
        Friendships friendships = new Friendships();
        friendships.makeFriends("Joe", "Audrey");
        friendships.makeFriends("Joe", "Peter");
        friendships.makeFriends("Joe", "Michael");
        friendships.makeFriends("Joe", "Britney");
        friendships.makeFriends("Joe", "Paul");

        Assert.assertEquals("Joe has 5 friends", 5, friendships.getNumberOfFriends("Joe"));
        Assert.assertTrue("Joe and Paul are friends", friendships.areFriends("Joe", "Paul"));
        Assert.assertFalse("Joe and Ralph are not friends", friendships.areFriends("Joe", "Ralph"));
    }
}
