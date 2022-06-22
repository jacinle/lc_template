package template.sort;

import java.util.Arrays;

public class RadixSort {

    // sort from least significant digit
    public void sort(int[] nums) {
        int max = Arrays.stream(nums).max().getAsInt();
        for(int exp = 1; max/exp > 0; exp *= 10 )
            countSort(nums, exp);
    }

    private void countSort(int[] nums, int exp) {
        int n = nums.length;
        int base = 10;
        int[] output = new int[n];
        int[] count = new int[base];

        // count the xth digit  (nums[i]/exp)%base
        for(int i=0;i<n;i++) count[(nums[i]/exp)% base ]++;
        for(int i=1;i<n;i++) count[i] += count[i-1];

        for(int i=n-1;i>=0;i--) {
            int index = count[(nums[i]/exp)% base];
            output[ index - 1  ] = nums[i];
            count[index]--;
        }
        // copy output back to num
        for(int i=0;i<n;i++) nums[i] = output[i];
    }
}
