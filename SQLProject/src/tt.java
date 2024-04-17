import java.util.Arrays;

/**
 * @author hxz
 */
public class tt {
    public static int longestConsecutive(int[] nums) {
        Arrays.sort(nums);
        System.out.println();
        for (int num : nums) {
            System.out.print(num+" ");
        }

        int max = 0;
        int temp = 0;
        int lastNum = 0;
        for(int i = 0;i < nums.length;i++){
            if(temp == 0){
                lastNum = nums[i];
                temp ++;
                continue;
            }

            if( (nums[i]) == (lastNum+1)){
                lastNum = nums[i];
                temp ++;
            }else{
                lastNum = nums[i];
                if(temp > max){
                    max = temp;
                }
                temp = 0;
            }
        }
        if (temp > max) max = temp;
        return max;
    }

    public static void main(String[] args) {
//        int[] nums = {1,4,7,8,33,2,5,66,3,5};
        int[] nums = {0,3,7,2,5,8,4,6,0,1};
        System.out.println();
        for (int num : nums) {
            System.out.print(num+" ");
        }

        System.out.println("\n"+longestConsecutive(nums));
    }
}
