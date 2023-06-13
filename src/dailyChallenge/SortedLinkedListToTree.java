package dailyChallenge;

public class SortedLinkedListToTree {

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    ListNode head;
    public TreeNode sortedListToBST(ListNode head) {
        this.head = head;
        return createBST(0, len(head) - 1);
    }

    private TreeNode createBST(int left, int right) {
        if (left > right) {
            return null;
        }

        int mid = (left + right) >> 1;
        TreeNode root = new TreeNode();
        root.left = createBST(left, mid - 1);
        root.val = head.val;
        head = head.next;
        root.right = createBST(mid + 1, right);
        return root;
    }

    private int len(ListNode head) {
        ListNode index = head;
        int ans = 0;
        while (index != null) {
            index = index.next;
            ans++;
        }
        return ans;
    }

}
