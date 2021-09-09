import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class N128 {
    public static  void main(String[] args) {
        System.out.println(longestConsecutive(new int[]{1, 3, 2, 4}));
    }
    public static int longestConsecutive(int[] nums) {
        Map<Integer, Integer> headLen = new HashMap<>();
        Map<Integer, Integer> tailLen = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        int res = 1;
        for (int temp : nums) {
            if (set.contains(temp)) {
                continue;
            }
            set.add(temp);
            res = Math.max(res, headleNum(headLen, tailLen, temp));
        }
        return res;
    }

    public static int headleNum(Map<Integer, Integer> headLen, Map<Integer, Integer> tailLen, int num) {
        int tail = num - 1;
        int head = num + 1;
        if (headLen.containsKey(head) && tailLen.containsKey(tail)) {
            int len1 = headLen.get(head), len2 = tailLen.get(tail);
            headLen.put(num-len2, len1+len2+1);
            tailLen.put(num+len1, len1+len2+1);
            headLen.remove(head);
            tailLen.remove(tail);
            return len1+len2+1;
        } else if (headLen.containsKey(head)) {
            int len = headLen.get(head);
            headLen.remove(head);
            headLen.put(num, len+1);
            tailLen.put(num+len, len+1);
            return len+1;
        } else if (tailLen.containsKey(tail)) {
            int len = tailLen.get(tail);
            tailLen.remove(tail);
            tailLen.put(num, len+1);
            headLen.put(num-len, len+1);
            return len+1;
        } else {
            tailLen.put(num, 1);
            headLen.put(num, 1);
            return 1;
        }
    }}
