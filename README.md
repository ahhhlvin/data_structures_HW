
public static ArrayList<Integer> getProducts() {
    int[] nums = {1, 7, 3, 4};
    Arraylist<Integer> products = new ArrayList<Integer>(4);
    
    for (int i = 0; i < nums.length; i++) {
        for (int num : nums) {
            if ( num != nums[i] ) {
                products.add(nums[i] *= num);
            }
        }
    }
}
