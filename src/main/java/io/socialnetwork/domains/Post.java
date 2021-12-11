package io.socialnetwork.domains;

public class Post {
    public Integer id;
    public User user;
    public String msg;
    public Integer upvotes;
    public Integer downvotes;

    public Post(User user, String msg) {
        this.id = id;
        this.user = user;
        this.msg = msg;
        this.downvotes = 0;
        this.upvotes = 0;
    }

    public Integer getId() {
        return id;
    }

    public Integer getUpvotes() {
        return upvotes;
    }

    public void setUpvotes(Integer upvotes) {
        this.upvotes = upvotes;
    }

    public Integer getDownvotes() {
        return downvotes;
    }

    public void setDownvotes(Integer downvotes) {
        this.downvotes = downvotes;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", msg='" + msg + '\'' +
                ", upvotes=" + upvotes +
                ", downvotes=" + downvotes +
                '}';
    }
}
