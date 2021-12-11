package io.socialnetwork.services;

import io.socialnetwork.domains.Post;
import io.socialnetwork.domains.User;
import io.socialnetwork.repository.HomeTimelineRepo;
import io.socialnetwork.repository.PostRepo;
import io.socialnetwork.repository.ProfileTimelineRepo;

public class PostServiceImpl implements PostService {
    public UserService userService;

    public PostRepo postRepo;
    public HomeTimelineRepo homeTimelineRepo;
    public ProfileTimelineRepo profileTimelineRepo;

    public PostServiceImpl(UserService userService, PostRepo postRepo, HomeTimelineRepo homeTimelineRepo, ProfileTimelineRepo profileTimelineRepo) {
        this.userService = userService;
        this.postRepo = postRepo;
        this.homeTimelineRepo = homeTimelineRepo;
        this.profileTimelineRepo = profileTimelineRepo;
    }

    @Override
    public Post save(String username, String msg) {
        User user = userService.getByName(username);

        Post post = new Post(user, msg);
        Post savedPost = postRepo.save(post);

        for (User following: user.getFollowing()) {
            homeTimelineRepo.save(following, savedPost);
        }

        profileTimelineRepo.save(user, savedPost);

        return savedPost;
    }

    @Override
    public void upvote(Integer postId) {
        postRepo.upvote(postId);
    }

    @Override
    public void downvote(Integer postId) {
        postRepo.downvote(postId);
    }
}
