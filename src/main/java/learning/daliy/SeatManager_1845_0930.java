package learning.daliy;

import java.util.HashMap;
import java.util.Map;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * 1845. 座位预约管理系统
 * 请你设计一个管理 n 个座位预约的系统，座位编号从 1 到 n 。
 *
 * 请你实现 SeatManager 类：
 *
 * SeatManager(int n) 初始化一个 SeatManager 对象，它管理从 1 到 n 编号的 n 个座位。所有座位初始都是可预约的。
 * int reserve() 返回可以预约座位的 最小编号 ，此座位变为不可预约。
 * void unreserve(int seatNumber) 将给定编号 seatNumber 对应的座位变成可以预约。
 */
public class SeatManager_1845_0930 {
    private SortedSet<Integer> seat;

    public SeatManager_1845_0930(int n) {
        seat = new TreeSet<>();
        for (int i = 1; i <= n; i++) {
            seat.add(i);
        }
    }

    public int reserve() {
        int toReserve = seat.first();
        seat.remove(toReserve);
        return toReserve;
    }

    public void unreserve(int seatNumber) {
        seat.add(seatNumber);
    }

    public static void main(String[] args) {
        SeatManager_1845_0930 seatManager = new SeatManager_1845_0930(5);
        System.out.println(seatManager.reserve());
        System.out.println(seatManager.reserve());
        seatManager.unreserve(2);
        System.out.println(seatManager.reserve());
        System.out.println(seatManager.reserve());
    }
}
