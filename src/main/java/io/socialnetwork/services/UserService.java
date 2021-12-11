package io.socialnetwork.services;

import io.socialnetwork.domains.Timeline;
import io.socialnetwork.domains.User;

public interface UserService {
    public void signup(String username);
    public Timeline login(String username);
    public User getByName(String username);
    public void addFollower(String userName, String followerName);
}
