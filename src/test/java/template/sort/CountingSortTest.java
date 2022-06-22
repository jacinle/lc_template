package template.sort;

import org.junit.jupiter.api.Test;
import template.sort.CountingSort;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class CountingSortTest {
    @Test
    public void test() {
        CountingSort sort = new CountingSort();
        int[] nums = {1,4,1,2,7,5};
        int[] expected = {1,1,2,4,5,7};
        int[] res = sort.sort(nums, 10);

        assertArrayEquals(res, expected);
    }
}
