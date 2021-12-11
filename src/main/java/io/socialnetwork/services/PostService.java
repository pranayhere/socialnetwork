package io.socialnetwork.services;

import io.socialnetwork.domains.Post;

public interface PostService {
    public Post save(String username, String msg);
    public void upvote(Integer postId);
    public void downvote(Integer postId);
}
