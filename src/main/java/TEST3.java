import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class TEST3 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        in.nextLine();
        String line = in.nextLine();
        Stack<Character> stack = new Stack<>();
        Stack<Character> stack1 = new Stack<>();
        Stack<Character> stack2 = new Stack<>();
        int actLen = 0, index = 0;
        for (int i=0; i<num; i++) {
            char c = line.charAt(i);
            if (c == 'L') {
                if (index < actLen) {
                    index++;
                }
            }
            if (stack1.isEmpty()) {
                if (c == '(') {
                    stack.push(c);
                }
            }
        }
        List<Integer> count = new ArrayList<>();
    }

}
