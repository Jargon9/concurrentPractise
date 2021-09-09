import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class TEST4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        int gap = in.nextInt();
        in.nextLine();
        int[] nums = new int[num];
        for (int i=0; i<num; i++) {
            nums[i] = in.nextInt();
        }
        System.out.println(getRes(nums, gap));

    }
    public static int getRes(int[] nums, int gap) {
        Arrays.sort(nums);
        Queue<Integer> queue = new LinkedList<>();
        Queue<Integer> allQueue = new LinkedList<>();
        int reverCount = 1, tempCount = 0;
        int[] dp = new int[nums.length+1];
        dp[0] = 0;
        for (int i=1; i<nums.length+1; i++) {

            if (allQueue.isEmpty() || nums[i-2]+gap < nums[i-1]) {
                allQueue.offer(nums[i-1]);
                if (i>1 && nums[i-2] == nums[i-1]) {
                    tempCount++;
                } else {
                    reverCount *= tempCount;
                    tempCount = 0;
                }
            } else {
                allQueue.clear();
            }

            if (!queue.isEmpty() && queue.peek()+gap < nums[i-1]) {
                while (!queue.isEmpty() && queue.peek()+gap < nums[i-1]) {
                    queue.poll();
                }
            }
            if (queue.isEmpty() || queue.peek()+gap >= nums[i-1]) {
                queue.offer(nums[i-1]);
                if (i > 1) {
                    dp[i] = dp[i-queue.size()] * getNum(queue.size()) + dp[i-1] + reverCount;
                } else {
                    dp[i] = 1;
                }
            }
        }
        return dp[nums.length];
    }
    public static int getNum(int x) {
        int res = 1;
        for (int i=1; i< x+1; i++) {
            res *= i;
        }
        int out = 1;
        for (int i=1; i< x; i++) {
            out *= i;
        }
        return res - out;
    }
}
