package template.sort;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class SortTest {
    @Test
    void testRadix() {
        RadixSort radixSort = new RadixSort();

        int[] nums = { 785, 10001, 10009, 10010, 999, 123, 12, 3};
        int[] expected = { 3, 12, 123, 785, 999, 10001, 10009, 10010};

        radixSort.sort(nums);
        assertArrayEquals(expected, nums);

    }
}
