package dailyChallenge;

import java.util.Stack;

public class BrowserHistoryClass {

    static class BrowserHistory {

        Stack<String> history;
        Stack<String> forwardPages;

        public BrowserHistory(String homepage) {
            history = new Stack<>();
            forwardPages = new Stack<>();
            history.add(homepage);
        }

        public void visit(String url) {
            history.add(url);
            if(forwardPages.size()>0) forwardPages = new Stack<>();
        }

        public String back(int steps) {
            while (steps-- > 0) {
                if (history.size() == 1) {
                    break;
                }
                forwardPages.add(history.pop());
            }

            return history.peek();
        }

        public String forward(int steps) {
            while (forwardPages.size() != 0 && steps-- > 0) {
                history.add(forwardPages.pop());
            }
            return history.peek();
        }
    }

    public static void main(String[] args) {

        BrowserHistory browserHistory = new BrowserHistory("leetcode.com");
        browserHistory.visit("google.com");       // You are in "leetcode.com". Visit "google.com"
        browserHistory.visit("facebook.com");     // You are in "google.com". Visit "facebook.com"
        browserHistory.visit("youtube.com");      // You are in "facebook.com". Visit "youtube.com"
        System.out.println(browserHistory.back(1));                 // You are in "youtube.com", move back to "facebook.com" return "facebook.com"
        System.out.println(browserHistory.back(1));                // You are in "facebook.com", move back to "google.com" return "google.com"
        System.out.println(browserHistory.forward(1));                // You are in "google.com", move forward to "facebook.com" return "facebook.com"
        browserHistory.visit("linkedin.com");     // You are in "facebook.com". Visit "linkedin.com"
        System.out.println(browserHistory.forward(2));               // You are in "linkedin.com", you cannot move forward any steps.
        System.out.println(browserHistory.back(2));                  // You are in "linkedin.com", move back two steps to "facebook.com" then to "google.com". return "google.com"
        System.out.println(browserHistory.back(7));                   // You are in "google.com", you can move back only one step to "leetcode.com". return "leetcode.com"

    }

}
