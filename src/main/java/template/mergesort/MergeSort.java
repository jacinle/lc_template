package template.mergesort;

public class MergeSort {

    public int[] mergesort(int[] nums) {
        return divide(nums, 0, nums.length-1);
    }

    private int[] divide(int[] nums, int left, int right) {
        if(left >= right) return new int[]{nums[left]};
        else {
            int mid = (left + right)/2;
            int[] left_result = divide(nums, left, mid);
            int[] right_result = divide(nums, mid+1, right);
            return merge(left_result, right_result);
        }
    }

    private int[] merge(int[] left_result, int[] right_result) {
        int [] res = new int[left_result.length+right_result.length];
        int l=0, r=0, k=0;
        while( l<left_result.length & r<right_result.length) {
            if(left_result[l]<right_result[r])
                res[k++] = left_result[l++];
            else
                res[k++] = right_result[r++];
        }
        while(l<left_result.length)    {
            res[k++] = left_result[l++];
        }
        while(r<right_result.length)    {
            res[k++] = right_result[r++];
        }
        return res;
    }
}
