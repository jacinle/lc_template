package template.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BucketSort {
    /*
    bucketSort(arr[], n)
            1) Create k empty buckets (Or lists).
            2) Do following for every array element arr[i].
            .......a) Insert arr[i] into bucket[n*array[i]]
            3) Sort individual buckets using insertion sort. // use java sort , which is timsort close to o(n)
            4) Concatenate all sorted buckets.
     */
    public void bucketSort(double[] nums, int k) {

        List<List<Double>> buckets = new ArrayList();

        for(int i=0; i<k; i++)
            buckets.add(new ArrayList<>());

        for(int i=0; i<nums.length;i++)
        {
            int bucket_index = (int) (k*nums[i]);

            List<Double> bucket = buckets.get(bucket_index);

            bucket.add(nums[i]);
        }

        for(int i=0; i<buckets.size(); i++) {
            Collections.sort(buckets.get(i));
        }
        int i=0;
        for(List<Double> bucket : buckets) {
            for(double d : bucket) {
                nums[i++] = d;
            }
        }
    }
}
