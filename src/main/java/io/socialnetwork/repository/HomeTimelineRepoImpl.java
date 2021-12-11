package io.socialnetwork.repository;

import io.socialnetwork.domains.Post;
import io.socialnetwork.domains.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class HomeTimelineRepoImpl implements HomeTimelineRepo {
    Map<String, List<Post>> homeTimeline;

    public HomeTimelineRepoImpl(Map<String, List<Post>> homeTimeline) {
        this.homeTimeline = homeTimeline;
    }

    @Override
    public void save(User user, Post post) {
        homeTimeline.computeIfAbsent(user.name, k -> new ArrayList<>()).add(post);
    }

    @Override
    public List<Post> get(User user) {
        return homeTimeline.get(user.name);
    }
}
