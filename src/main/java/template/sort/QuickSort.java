package template.sort;

import java.util.Arrays;
import java.util.Random;

public class QuickSort {

    public static void main(String[] args) {
        QuickSort q = new QuickSort();
        int[] nums = { 6, 9, 1, 7, 3, 2, 8, 9, 1, 5, 4, 6, -100, -201};
        q.quicksort(nums);
        System.out.println(Arrays.toString(nums));
    }

    public int[] quicksort(int[] nums) {
        helper(0, nums.length-1, nums);
        return nums;
    }

    public void helper(int left, int right, int[] nums) {
        if(left<right) {
            int pi = partition(left, right, nums);
            helper(left, pi-1, nums);
            helper(pi+1, right, nums);
        }
    }
    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void getRandomPartition(int left, int right, int[] nums) {
        Random rand= new Random();
        int pivot = rand.nextInt(right-left)+left;
        System.out.println(pivot);
        int temp1=nums[pivot];
        nums[pivot]=nums[right];
        nums[right]=temp1;

    }

    public int partition(int left, int right, int[] nums) {
        getRandomPartition(left, right, nums); //optional call
        int pivot =right;
        int start = left;
        int end = right-1;
        while(start<=end) {
            if(nums[start]<=nums[pivot]) start++;
            else if(nums[end] > nums[pivot]) end--;
            else swap(nums, start++, end--);  // where the start element is larger than pivot and end element is smaller than pivot, swap
        }
        swap(nums, start, pivot);
        return start;
    }
}
