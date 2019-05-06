import java.util.*;

class KMax {

    int[] nums;
    int k;
    int[] result;

    public KMax(int[] nums, int k) {
        this.nums = nums;
        this.k = k;
        this.result = new int[nums.length - k + 1];

        Deque<Integer> dq = new ArrayDeque<>();
        for (int i = 0; i < nums.length; i++) {
            dq.add(nums[i]);
            if (dq.size() > k) dq.removeFirst();
            while (dq.getFirst() < dq.getLast()) {dq.removeFirst();}

            if (i - k + 1 >= 0) {
                result[i - k + 1] = dq.getFirst();
            }
        }
    }




    public static void main(String[] args) {
        int[] nums = new int[]{};
        Jren.p(new KMax(nums, 0).result);
    }
}