/**
 * Created by star on 9/5/18.
 */

class PushZero {

    static void moveZeros2(int arr[]){   int n = arr.length;
        int cntr = 0;
        // cntr will keep track
        for (int i = 0; i < n; i++) // travers the array
            if (arr[i] != 0) // If element at i is  not zero,
                            //  replace the element at index 'cntr' with this element
                arr[cntr++] = arr[i]; //
        // after moving all element to front
        while (cntr < n) // for rest of the digit put zero from cntr
            arr[cntr++] = 0;
    }

    static void moveZeros1(int[] nums) {
        int cntr=0,strt=0;
        for(int j=0,i=0;j<nums.length;j++){
            if(nums[j]==0&&cntr==0){ // if nums index is zero store it in start
                i=j;
                strt=i;
                cntr++;
            }else if(nums[j]!=0){ // the nums index is not zero swap it with next number with start of zero
                swap(nums,strt,j);
                strt=strt+1;
            }else if(nums[j]==0&&cntr!=0){
                cntr++;
            }
        }
    }

    public static void swap(int[] nums,int a,int b){
        int temp=nums[a];
        nums[a]=nums[b];
        nums[b]=temp;
    }

    public static void main (String[] args)
    {
        int arr[] = {0,1,0,3,12};
        int n = arr.length;
        moveZeros1(arr);
        for(int i:arr)
            System.out.print(i+", ");
    }
}