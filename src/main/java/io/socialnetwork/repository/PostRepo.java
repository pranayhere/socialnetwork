package io.socialnetwork.repository;

import io.socialnetwork.domains.Post;

public interface PostRepo {
    public Post save(Post post);
    public Post get(Integer postId);
    public void upvote(Integer postId);
    public void downvote(Integer postId);
}
