package io.socialnetwork.repository;

import io.socialnetwork.domains.Post;
import io.socialnetwork.domains.User;

import java.util.List;

public interface HomeTimelineRepo {
    public void save(User user, Post post);
    public List<Post> get(User user);
}
