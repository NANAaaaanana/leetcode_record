package learning.daliy;

public class DifferenceOfSum_2535_0926 {
    public int differenceOfSum(int[] nums) {
        int addAll = 0;
        int addBySituation = 0;
        for(int i : nums) {
            addAll += i;
            addBySituation += getSum(i);
        }
        return Math.abs(addAll - addBySituation);
    }

    private int getSum(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] nums = {1,15,6,3};
        DifferenceOfSum_2535_0926 differenceOfSum_2535_0926 = new DifferenceOfSum_2535_0926();
        System.out.println(differenceOfSum_2535_0926.differenceOfSum(nums));
    }
}
