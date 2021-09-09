import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class test {
    public static void main(String[] args) {
        int[][] test = {{1,   3,  5,  9}, {10, 11, 12, 30}, {230, 300, 350, 500}};
//        findKthLargestTool1(test, 0, test.length - 1, 5);
        System.out.println(tool(test, 1));
    }

    public static boolean tool(int[][] test, int target) {
        int m = test.length,  n = test[0].length;
        int l=0, r=m-1;
        while (l < r) {
            int mid = (l + r) / 2;
            if (test[mid][0] > target) {
                r = mid - 1;
            } else if (test[mid][0] < target) {
                l = mid + 1;
            } else {
                return true;
            }
        }
        int row = l;
        l = 0;
        r = n-1;
        while (l < r) {
            int mid = (l + r) / 2;
            if (test[row][mid] > target) {
                r = mid - 1;
            } else if (test[row][mid] < target) {
                l = mid + 1;
            } else {
                return true;
            }
        }
        return false;
    }
}
