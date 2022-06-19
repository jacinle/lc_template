package template.mergesort;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class MergeSortTest {
    @Test
    public void test() {
        MergeSort q = new MergeSort();
        int[] nums = { 6, 9, 1, 7, 3, 2, 8, 9, 1, 5, 4, 6, -100, -201};
        int[] res = q.mergesort(nums);

        int[] expected = {-201, -100, 1, 1, 2, 3, 4, 5, 6,6, 7, 8, 9, 9};
        assertArrayEquals(res, expected);
    }
}
