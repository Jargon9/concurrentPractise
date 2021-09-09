import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class N2 {


    public static   void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i=0; i<t; i++) {
            in.nextLine();
            int m = in.nextInt();
            int[][] classStudents = new int[m][2];
            int students = in.nextInt();
            in.nextLine();
            for (int j=0; j<m; j++) {
                classStudents[j][0] = in.nextInt();
                classStudents[j][1] = in.nextInt();
            }
            System.out.println(maxTool(classStudents, students));
            in.nextLine();
        }
    }

    public static double maxTool(int[][] classStudents, int students) {

        int n = classStudents.length;
        // 定义优先队列，优先级按照增加 1 名学生之后能够产生的最大贡献来排序

        PriorityQueue<double[]> queue1 = new PriorityQueue<>((o1, o2) -> judgeOrder(o1, o2));
        PriorityQueue<double[]> queue = new PriorityQueue<>((o1, o2) -> judgeOrder(o1, o2));
        // 转化为 double，方便小数计算
        for (int[] c : classStudents) {
            queue.offer(new double[]{c[0], c[1]});
        }
        // 分配学生，每次分配 1 名
        while (students > 0) {
            double[] maxClass = queue.poll(); //取出能够产生最大影响的班级
            maxClass[0] += 1.0; //通过的人数
            maxClass[1] += 1.0; //班级总人数

            queue.offer(maxClass); //将更新后的重新加入队列中
            students--;
        }
        // 计算最终结果
        double res = 0;
        while (!queue.isEmpty()) {
            double[] c = queue.poll();
            res += (c[0] / c[1]);
        }
        return res / n;
    }

    public static int judgeOrder(double[] x1, double[] x2) {
        double x = ((x2[0] + 1) / (x2[1] + 1) - x2[0] / x2[1]);
        double y = ((x1[0] + 1) / (x1[1] + 1) - x1[0] / x1[1]);
        if (x > y) return 1;
        if (x < y) return -1;
        return 0;
    }
}
