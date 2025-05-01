class Solution {
    private boolean canAssign(int k, int[] tasks, int[] workers, int pills, int strength) {
        Deque<Integer> q = new ArrayDeque<>();
        int cnt = 0;
        int p = pills;

        for (int i = k - 1; i >= 0; i--) {
            if (q.isEmpty() && workers[cnt] >= tasks[i]) {
                cnt++;
                continue;
            }
            if (!q.isEmpty() && q.peekFirst() >= tasks[i]) {
                q.pollFirst();
                continue;
            }
            while (cnt < k && workers[cnt] + strength >= tasks[i]) {
                q.offerLast(workers[cnt]);
                cnt++;
            }
            if (!q.isEmpty() && p > 0) {
                q.pollLast();
                p--;
                continue;
            }
            return false;
        }
        return true;
    }

    public int maxTaskAssign(int[] tasks, int[] workers, int pills, int strength) {
        Arrays.sort(tasks);
        Arrays.sort(workers);

        for (int i = 0, j = workers.length - 1; i < j; i++, j--) {
            int temp = workers[i];
            workers[i] = workers[j];
            workers[j] = temp;
        }

        int left = 0;
        int right = Math.min(tasks.length, workers.length);
        int res = 0;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (canAssign(mid, tasks, workers, pills, strength)) {
                res = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return res;
    }
}