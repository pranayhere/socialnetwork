package io.socialnetwork.repository;

import io.socialnetwork.domains.Post;
import io.socialnetwork.domains.User;

import java.util.Map;

public class PostRepoImpl implements PostRepo {
    Map<Integer, Post> posts;
    Integer id;

    public PostRepoImpl(Map<Integer, Post> posts) {
        this.id = 1;
        this.posts = posts;
    }

    @Override
    public Post save(Post post) {
        post.setId(id);
        posts.put(post.id, post);
        id++;
        return post;
    }

    @Override
    public Post get(Integer postId) {
        return posts.get(postId);
    }

    @Override
    public void upvote(Integer postId) {
        Post post = posts.get(postId);
        post.setUpvotes(post.getUpvotes() + 1);
        posts.put(postId, post);
    }

    @Override
    public void downvote(Integer postId) {
        Post post = posts.get(postId);
        post.setUpvotes(post.getDownvotes() - 1);
        posts.put(postId, post);
    }
}
