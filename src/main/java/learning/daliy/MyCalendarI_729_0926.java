package learning.daliy;

import java.util.TreeMap;

/**
 * 729. My Calendar I
 * You are implementing a program to use as your calendar. We can add a new event if adding the event will not cause a double booking.
 * A double booking happens when two events have some non-empty intersection (i.e., some moment is common to both events.).
 * The event can be represented as a pair of integers start and end that represents a booking on the half-open interval [start, end), the range of real numbers x such that start <= x < end.
 * Implement the MyCalendar class:
 * MyCalendar() Initializes the calendar object.
 * boolean book(int start, int end) Returns true if the event can be added to the calendar successfully without causing a double booking. Otherwise, return false and do not add the event to the calendar.
 */
public class MyCalendarI_729_0926 {

    private TreeMap<Integer, Integer> calendar;

    public MyCalendarI_729_0926() {
        calendar = new TreeMap<>();
    }


    public boolean book(int start, int end) {
            Integer prev = calendar.floorKey(start);
            Integer next = calendar.ceilingKey(start);
            if ((prev == null || calendar.get(prev) <= start) && (next == null || end <= next)) {
                calendar.put(start, end);
                return true;
            }
            return false;
    }

    public static void main(String[] args) {
        MyCalendarI_729_0926 myCalendar = new MyCalendarI_729_0926();
        System.out.println(myCalendar.book(10, 20));
        System.out.println(myCalendar.book(15, 25));
        System.out.println(myCalendar.book(20, 30));
    }

}
