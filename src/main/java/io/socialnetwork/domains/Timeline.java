package io.socialnetwork.domains;

import java.util.List;

public class Timeline {
    public User user;
    public List<Post> profileTimeline;
    public List<Post> homeTimeline;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Post> getProfileTimeline() {
        return profileTimeline;
    }

    public void setProfileTimeline(List<Post> profileTimeline) {
        this.profileTimeline = profileTimeline;
    }

    public List<Post> getHomeTimeline() {
        return homeTimeline;
    }

    public void setHomeTimeline(List<Post> homeTimeline) {
        this.homeTimeline = homeTimeline;
    }

    @Override
    public String toString() {
        return "Timeline{" +
                ", profileTimeline=" + profileTimeline +
                ", homeTimeline=" + homeTimeline +
                '}';
    }
}
