package io.socialnetwork.repository;

import io.socialnetwork.domains.Post;
import io.socialnetwork.domains.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ProfileTimelineRepoImpl implements ProfileTimelineRepo {
    Map<String, List<Post>> profileTimeline;

    public ProfileTimelineRepoImpl(Map<String, List<Post>> profileTimeline) {
        this.profileTimeline = profileTimeline;
    }

    @Override
    public void save(User user, Post post) {
        profileTimeline.computeIfAbsent(user.name, k -> new ArrayList<>()).add(post);
    }

    @Override
    public List<Post> get(User user) {
        return profileTimeline.get(user.name);
    }
}
