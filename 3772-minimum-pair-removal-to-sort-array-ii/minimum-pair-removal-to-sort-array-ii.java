class Solution {
    static class Node {
        long value;
        Node prev, next;
        boolean removed;
        int idx; // tie-breaker: leftmost representative

        Node(long value, int idx) {
            this.value = value;
            this.idx = idx;
        }
    }

    static class MinSumPair {
        long sum;
        Node left, right;
        int leftIdx;

        MinSumPair(Node left, Node right) {
            this.left = left;
            this.right = right;
            this.sum = left.value + right.value;
            this.leftIdx = left.idx;
        }
    }

    private static boolean isReal(Node x) {
        return x != null && x.idx != -1; // dummy has idx=-1
    }

    private static int invEdge(Node a, Node b) {
        if (!isReal(a) || b == null) {
            return 0;
        }
        return a.value > b.value ? 1 : 0;
    }

    public static int minimumPairRemoval(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return 0;
        }

        Node dummy = new Node(0, -1);
        Node cur = dummy;

        // Build DLL
        for (int i = 0; i < nums.length; i++) {
            Node node = new Node(nums[i], i);
            cur.next = node;
            node.prev = cur;
            cur = node;
        }

        PriorityQueue<MinSumPair> pq = new PriorityQueue<>(
                (a, b) -> {
                    int c = Long.compare(a.sum, b.sum);
                    if (c != 0) {
                        return c;
                    }
                    return Integer.compare(a.leftIdx, b.leftIdx);
                }
        );

        // Init inversions + heap
        int inv = 0;
        Node run = dummy.next;
        while (run != null && run.next != null) {
            inv += invEdge(run, run.next);
            pq.offer(new MinSumPair(run, run.next));
            run = run.next;
        }

        if (inv == 0) {
            return 0;
        }

        int ops = 0;

        while (inv > 0) {
            MinSumPair p = pq.poll();

            // Shouldn't happen if inv>0, but defensive
            if (p == null) {
                break;
            }

            Node left = p.left;
            Node right = p.right;

            // Lazy deletion / adjacency validation
            if (left.removed || right.removed) {
                continue;
            }
            if (left.next != right) {
                continue; // stale pair
            }

            // Commit merge
            ops++;

            Node prev = left.prev;     // could be dummy
            Node next = right.next;    // could be null

            // Remove inversions of disappearing edges
            inv -= invEdge(prev, left);
            inv -= invEdge(left, right);
            inv -= invEdge(right, next);

            // Create merged node (inherits leftmost idx)
            Node merged = new Node(left.value + right.value, left.idx);

            // Relink prev <-> merged
            prev.next = merged;
            merged.prev = prev;

            // Relink merged <-> next
            merged.next = next;
            if (next != null) {
                next.prev = merged;
            }

            // Mark old nodes removed
            left.removed = true;
            right.removed = true;

            // Add inversions of new edges
            inv += invEdge(prev, merged);
            inv += invEdge(merged, next);

            // Push new candidate pairs
            if (isReal(prev)) {
                pq.offer(new MinSumPair(prev, merged));
            }
            if (next != null) {
                pq.offer(new MinSumPair(merged, next));
            }
        }

        return ops;
    }
}