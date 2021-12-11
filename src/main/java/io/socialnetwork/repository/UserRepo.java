package io.socialnetwork.repository;

import io.socialnetwork.domains.User;

import java.util.Map;

public interface UserRepo {
    public void save(User user);
    public User getByName(String username);
    public void addFollower(String username, User follower);
}
