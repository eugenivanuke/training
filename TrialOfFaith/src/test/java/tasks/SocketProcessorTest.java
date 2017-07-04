package tasks;

import org.junit.Test;

import static org.junit.Assert.*;

public class SocketProcessorTest {
    @Test
    public void twoSum() {
        int target;
        target = System.in.read();
        int nums[];

        int[] indices = new int[1];
        for (int i=0; i <= nums.length; i++){
                if (nums[i] + nums[i+1] == target) {
                indices[0] = nums[i];
                indices[1] = nums[i+1];
            }
        }
        System.out.println(indices);
    }
}

