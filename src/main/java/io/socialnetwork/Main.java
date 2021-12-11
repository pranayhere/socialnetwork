package io.socialnetwork;

import io.socialnetwork.domains.Post;
import io.socialnetwork.domains.Timeline;
import io.socialnetwork.domains.User;
import io.socialnetwork.repository.*;
import io.socialnetwork.services.PostService;
import io.socialnetwork.services.PostServiceImpl;
import io.socialnetwork.services.UserService;
import io.socialnetwork.services.UserServiceImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<String, User> users = new HashMap<>();
        Map<Integer, Post> posts = new HashMap<>();
        Map<String, List<Post>> homeTimeline = new HashMap<>();
        Map<String, List<Post>> profileTimeline = new HashMap<>();

        UserRepo userRepo = new UserRepoImpl(users);
        PostRepo postRepo = new PostRepoImpl(posts);
        HomeTimelineRepo homeTimelineRepo = new HomeTimelineRepoImpl(homeTimeline);
        ProfileTimelineRepo profileTimelineRepo = new ProfileTimelineRepoImpl(profileTimeline);

        UserService userService = new UserServiceImpl(userRepo, homeTimelineRepo, profileTimelineRepo);
        PostService postService = new PostServiceImpl(userService, postRepo, homeTimelineRepo, profileTimelineRepo);

        userService.signup("pranay");
        userService.signup("rahul");
        userService.signup("ram");

        userService.addFollower("pranay", "rahul");
        userService.addFollower("pranay", "ram");
        userService.addFollower("rahul", "ram");

        Post p1 = postService.save("pranay", "hello from pranay");
        Post p2 = postService.save("rahul", "hello from rahul");
        Post p3 = postService.save("ram", "hello from ram");

        postService.upvote(p1.id);
        postService.upvote(p2.id);
        postService.downvote(p3.id);

        Timeline timelineRahul = userService.login("rahul");
        Timeline timelneRam = userService.login("ram");
        Timeline timelnePranay = userService.login("pranay");

        System.out.println(timelineRahul);
        System.out.println(timelneRam);
        System.out.println(timelnePranay);
    }
}