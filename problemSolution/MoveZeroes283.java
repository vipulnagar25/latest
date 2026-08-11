package problemSolution.arrayp;

public class MoveZeroes283 {

    public static void moveZeroes(int[] nums) {
     int index=0;
     for(int i=0;i<nums.length;i++){
            if(nums[i]!=0){
                nums[index++]=nums[i];
            }
     }
     while (index<nums.length) {
        nums[index++]=0;
     }


    }

    static void main() {
        int[] nums = {0, 1, 0, 3, 12};
        moveZeroes(nums);
        System.out.println(java.util.Arrays.toString(nums));
    }
}
