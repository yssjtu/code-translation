public int maxDepth(Node root) { if (root == null) { return 0; } int maxChildDepth = 0; List<Node> children = root.children; for (Node child : children) { int childDepth = maxDepth(child); maxChildDepth = Math.max(maxChildDepth, childDepth); } return maxChildDepth + 1; }
public ListNode rotateRight(ListNode head, int k) { if (k == 0 || head == null || head.next == null) { return head; } int n = 1; ListNode iter = head; while (iter.next != null) { iter = iter.next; n++; } int add = n - k % n; if (add == n) { return head; } iter.next = head; while (add-- > 0) { iter = iter.next; } ListNode ret = iter.next; iter.next = null; return ret; }
public int findShortestSubArray(int[] nums) { Map<Integer, int[]> map = new HashMap<Integer, int[]>(); int n = nums.length; for (int i = 0; i < n; i++) { if (map.containsKey(nums[i])) { map.get(nums[i])[0]++; map.get(nums[i])[2] = i; } else { map.put(nums[i], new int[]{1, i, i}); } } int maxNum = 0, minLen = 0; for (Map.Entry<Integer, int[]> entry : map.entrySet()) { int[] arr = entry.getValue(); if (maxNum < arr[0]) { maxNum = arr[0]; minLen = arr[2] - arr[1] + 1; } else if (maxNum == arr[0]) { if (minLen > arr[2] - arr[1] + 1) { minLen = arr[2] - arr[1] + 1; } } } return minLen; }
public int[] maxSlidingWindow(int[] nums, int k) { int n = nums.length; int[] prefixMax = new int[n]; int[] suffixMax = new int[n]; for (int i = 0; i < n; ++i) { if (i % k == 0) { prefixMax[i] = nums[i]; } else { prefixMax[i] = Math.max(prefixMax[i - 1], nums[i]); } } for (int i = n - 1; i >= 0; --i) { if (i == n - 1 || (i + 1) % k == 0) { suffixMax[i] = nums[i]; } else { suffixMax[i] = Math.max(suffixMax[i + 1], nums[i]); } } int[] ans = new int[n - k + 1]; for (int i = 0; i <= n - k; ++i) { ans[i] = Math.max(suffixMax[i], prefixMax[i + k - 1]); } return ans; }
public String predictPartyVictory(String senate) { int n = senate.length(); Queue<Integer> radiant = new LinkedList<Integer>(); Queue<Integer> dire = new LinkedList<Integer>(); for (int i = 0; i < n; ++i) { if (senate.charAt(i) == 'R') { radiant.offer(i); } else { dire.offer(i); } } while (!radiant.isEmpty() && !dire.isEmpty()) { int radiantIndex = radiant.poll(), direIndex = dire.poll(); if (radiantIndex < direIndex) { radiant.offer(radiantIndex + n); } else { dire.offer(direIndex + n); } } return !radiant.isEmpty() ? "Radiant" : "Dire"; }
public int totalHammingDistance(int[] nums) { int ans = 0, n = nums.length; for (int i = 0; i < 30; ++i) { int c = 0; for (int val : nums) { c += (val >> i) & 1; } ans += c * (n - c); } return ans; }
public int numRescueBoats(int[] people, int limit) { int ans = 0; Arrays.sort(people); int light = 0, heavy = people.length - 1; while (light <= heavy) { if (people[light] + people[heavy] <= limit) { ++light; } --heavy; ++ans; } return ans; }
public int minDistance(String word1, String word2) { int m = word1.length(), n = word2.length(); int[][] dp = new int[m + 1][n + 1]; for (int i = 1; i <= m; i++) { char c1 = word1.charAt(i - 1); for (int j = 1; j <= n; j++) { char c2 = word2.charAt(j - 1); if (c1 == c2) { dp[i][j] = dp[i - 1][j - 1] + 1; } else { dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]); } } } int lcs = dp[m][n]; return m - lcs + n - lcs; }