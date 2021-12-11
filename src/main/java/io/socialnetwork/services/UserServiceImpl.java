package io.socialnetwork.services;

import io.socialnetwork.exceptions.UserNotFoundException;
import io.socialnetwork.domains.Timeline;
import io.socialnetwork.domains.User;
import io.socialnetwork.repository.HomeTimelineRepo;
import io.socialnetwork.repository.ProfileTimelineRepo;
import io.socialnetwork.repository.UserRepo;

public class UserServiceImpl implements UserService {
    UserRepo userRepo;
    HomeTimelineRepo homeTimelineRepo;
    ProfileTimelineRepo profileTimelineRepo;

    public UserServiceImpl(UserRepo userRepo, HomeTimelineRepo homeTimelineRepo, ProfileTimelineRepo profileTimelineRepo) {
        this.userRepo = userRepo;
        this.homeTimelineRepo = homeTimelineRepo;
        this.profileTimelineRepo = profileTimelineRepo;
    }

    @Override
    public void signup(String username) {
        User user = new User(username);
        userRepo.save(user);
    }

    @Override
    public Timeline login(String username) {
        User user = userRepo.getByName(username);
        if (user == null) {
            throw new UserNotFoundException(username);
        }

        Timeline timeline = new Timeline();
        timeline.setHomeTimeline(homeTimelineRepo.get(user));
        timeline.setProfileTimeline(profileTimelineRepo.get(user));

        return timeline;
    }

    @Override
    public User getByName(String username) {
        return userRepo.getByName(username);
    }

    @Override
    public void addFollower(String userName, String followerName) {
        User follower = userRepo.getByName(followerName);
        userRepo.addFollower(userName, follower);
    }
}
