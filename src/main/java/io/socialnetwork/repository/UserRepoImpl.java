package io.socialnetwork.repository;

import io.socialnetwork.domains.User;

import java.util.Map;

public class UserRepoImpl implements UserRepo {
    Map<String, User> users;

    public UserRepoImpl(Map<String, User> users) {
        this.users = users;
    }

    @Override
    public void save(User user) {
        users.put(user.name, user);
    }

    @Override
    public User getByName(String username) {
        return users.get(username);
    }

    @Override
    public void addFollower(String username, User follower) {
        User user = getByName(username);
        user.following.add(follower);
        follower.followers.add(user);
    }
}
