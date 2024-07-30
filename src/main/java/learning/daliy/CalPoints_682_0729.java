package learning.daliy;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

import lombok.extern.slf4j.Slf4j;

/**
 * 682. 棒球比赛
 */
public class CalPoints_682_0729 {
    public int calPoints(String[] ops) {
        int ret = 0;
        List<Integer> points = new ArrayList<Integer>();
        for (String op : ops) {
            int n = points.size();
            switch (op.charAt(0)) {
                case '+':
                    ret += points.get(n - 1) + points.get(n - 2);
                    points.add(points.get(n - 1) + points.get(n - 2));
                    break;
                case 'D':
                    ret += 2 * points.get(n - 1);
                    points.add(2 * points.get(n - 1));
                    break;
                case 'C':
                    ret -= points.get(n - 1);
                    points.remove(n - 1);
                    break;
                default:
                    ret += Integer.parseInt(op);
                    points.add(Integer.parseInt(op));
                    break;
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        System.out.println(new CalPoints_682_0729().calPoints(new String[]{"5", "2", "C", "D", "+"}));
    }
}
