package com.algorithms.nowcoder.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @Author: jiangfw
 * @Date: 2023/09/22
 */
public class MicroBlog {

    Map<Integer, List<Integer>> followMap = new HashMap<>();
    Map<Integer, List<Blog>> blogMap = new HashMap<>();


    public static void main(String[] args) throws InterruptedException {

        MicroBlog mircroBlog = new MicroBlog();
        // 用户 1，2，3
        mircroBlog.follow(1, 2);
//        mircroBlog.follow(1, 2);
        //1. 用户1创建5条推文
        mircroBlog.postBlog(1, 11100001);
        mircroBlog.postBlog(1, 11100002);
        mircroBlog.postBlog(1, 11100003);
        mircroBlog.postBlog(1, 11100004);
        mircroBlog.postBlog(1, 11100005);
        mircroBlog.postBlog(2, 22200001);
        mircroBlog.postBlog(2, 22200002);
        mircroBlog.postBlog(2, 22200003);
        mircroBlog.postBlog(2, 22200004);
        mircroBlog.postBlog(2, 22200005);
        mircroBlog.postBlog(2, 22200006);

        mircroBlog.postBlog(1, 11100006);
        mircroBlog.postBlog(3, 33300001);
        mircroBlog.postBlog(3, 33300002);
        mircroBlog.postBlog(3, 33300003);
        mircroBlog.postBlog(3, 33300004);
        mircroBlog.postBlog(3, 33300005);
        //2.查询用户1下的博文
        System.out.println("1关注了2，可以看到的博文");
        List<Integer> newsFeed = mircroBlog.getNewsFeed(1);
        System.out.println(newsFeed);

        mircroBlog.unfollow(1, 2);
        System.out.println("1取消关注了2，可以看到的博文");
        List<Integer> newsFeed2 = mircroBlog.getNewsFeed(1);
        System.out.println(newsFeed2);
    }

    /**
     * 创建一条新的推文
     */
    public void postBlog(Integer userId, Integer blogId) {
        if (this.blogMap.get(userId) != null) {
            List<Blog> blogList = this.blogMap.get(userId);
            blogList.add(new Blog(userId, System.currentTimeMillis(), blogId));
        } else {
            List<Blog> blogList = new ArrayList<>();
            blogList.add(new Blog(userId, System.currentTimeMillis(), blogId));
            this.blogMap.put(userId, blogList);
        }
    }

    /**
     * 检索最近的十条推文。每个推文都必须是由此用户关注的人或者是用户自己发出的。
     * 推文必须按照时间顺序由最近的开始排序。
     * *
     */
    public List<Integer> getNewsFeed(Integer userId) {
        List<Integer> result;
        List<Blog> resultList = new ArrayList<>();
        List<Integer> myFollowerList = this.followMap.get(userId);
        if (myFollowerList != null) {
            myFollowerList.forEach(e -> {
                resultList.addAll(this.blogMap.get(e));
            });
        }
        //自己的
        List<Blog> mineBlogList = this.blogMap.get(userId);
        resultList.addAll(mineBlogList);
        result = resultList.stream()
                .sorted((o1, o2) -> o2.getCreateTime() <= o1.getCreateTime() ? -1 : 1)
                .limit(10).map(Blog::getBlogId).collect(Collectors.toList());

        return result;
    }

    /**
     * 关注一个用户
     *
     * @param followerId 关注人
     * @param followeeId 被关注人
     * @return
     */
    public boolean follow(Integer followerId, Integer followeeId) {
        if (this.followMap.get(followerId) != null) {
            List<Integer> followList = this.followMap.get(followerId);
            followList.add(followeeId);
        } else {
            List<Integer> followList = new ArrayList<>();
            followList.add(followeeId);
            this.followMap.put(followerId, followList);
        }
        return true;
    }

    /**
     * 取消关注一个用户
     *
     * @param followerId
     * @param followeeId
     * @return
     */
    public boolean unfollow(Integer followerId, Integer followeeId) {
        if (this.followMap.get(followerId) != null) {
            List<Integer> followList = this.followMap.get(followerId);
            followList.remove(followeeId);
        }
        return true;
    }


    public static class Blog {

        private Integer author;
        private Long createTime;
        private Integer blogId;

        public Blog(Integer author, Long createTime, Integer blogId) {
            this.author = author;
            this.createTime = createTime;
            this.blogId = blogId;
        }

        public Integer getAuthor() {
            return this.author;
        }

        public void setAuthor(Integer author) {
            this.author = author;
        }

        public Long getCreateTime() {
            return this.createTime;
        }

        public void setCreateTime(Long createTime) {
            this.createTime = createTime;
        }

        public Integer getBlogId() {
            return this.blogId;
        }

        public void setBlogId(Integer blogId) {
            this.blogId = blogId;
        }
    }

}
