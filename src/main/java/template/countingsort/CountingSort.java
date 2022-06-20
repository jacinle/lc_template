package template.countingsort;

public class CountingSort {

    public int[] sort(int[] nums, int unique_no){
        int n = nums.length;
        int[] count = new int[unique_no];
        int[] output = new int[n];
        // count the element
        for(int i=0; i<n; i++) {
            count[nums[i]]++;
        }

        // build an incremental count so it stores the location index (+1)
        for(int i=1; i<unique_no; i++) {
            count[i] += count[i-1];
        }

        for(int i=0; i<n; i++) {
            output[count[nums[i]]-1] = nums[i];
            --count[nums[i]]; // reduce the count
        }
        return output;
    }
}
