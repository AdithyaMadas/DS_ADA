package heaps;

import java.util.*;

public class Twitter {
    class Tweet implements Comparable<Tweet> {
        int tweetId;
        long time;

        public Tweet(int tweetId, long time) {
            this.tweetId = tweetId;
            this.time = time;
        }

        @Override
        public int compareTo(Tweet o) {
            return (int) (o.time - time);
        }
    }
    Map<Integer, Set<Integer>> followerMap;
    Map<Integer, List<Tweet>> userTweets;

    long time = 1;

    public Twitter() {
        followerMap = new HashMap<>();
        userTweets = new HashMap<>();
    }

    public void postTweet(int userId, int tweetId) {
        List<Tweet> tweets = userTweets.getOrDefault(userId, new ArrayList<>());
        tweets.add(new Tweet(tweetId, time++));
        userTweets.put(userId, tweets);
    }

    public List<Integer> getNewsFeed(int userId) {
        Set<Integer> following = followerMap.getOrDefault(userId, new HashSet<>());
        following.add(userId);
        PriorityQueue<Tweet> pq = new PriorityQueue<>();
        for (int user : following) {
            for (Tweet i : userTweets.getOrDefault(user, new ArrayList<>())) {
                pq.offer(i);
            }
        }
        int i = 10;
        ArrayList<Integer> tweets = new ArrayList<>();
        while (!pq.isEmpty() && i-- > 0) {
            tweets.add(pq.poll().tweetId);
        }
        return tweets;
    }

    public void follow(int followerId, int followeeId) {
        Set<Integer> followees = followerMap.getOrDefault(followerId, new HashSet<>());
        followees.add(followeeId);
        followerMap.put(followerId, followees);
    }

    public void unfollow(int followerId, int followeeId) {
        Set<Integer> set = followerMap.get(followerId);
        set.remove(followeeId);
        followerMap.put(followerId, set);
    }

    public static void main(String[] args) {
        Twitter twitter = new Twitter();
        twitter.postTweet(1, 5);
        System.out.println(twitter.getNewsFeed(1));
        twitter.follow(1, 2);
        twitter.postTweet(2, 6);
        System.out.println(twitter.getNewsFeed(1));
        twitter.unfollow(1, 2);
        System.out.println(twitter.getNewsFeed(1));
    }
}
