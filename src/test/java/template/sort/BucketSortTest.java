package template.sort;

import org.junit.jupiter.api.Test;
import template.sort.BucketSort;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class BucketSortTest {
    @Test
    public void test() {
        BucketSort sort = new BucketSort();
        double[] nums = { 0.3123, 0.345,  0.0345, 0.1234, 0.9877, 0.43545, 0.656, 0.0232,};
        double[] expected = { 0.0232, 0.0345, 0.1234,  0.3123, 0.345,  0.43545, 0.656, 0.9877};
        int k=10;
        sort.bucketSort(nums, k);

        assertArrayEquals(nums, expected);

    }
}
