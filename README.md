# AC_Homeworks

InterviewCake HW# 1 possible solution:



   private int returnMaxDif()
    {
      int[] stocks = {10, 7, 5, 8, 11, 9};
       int maxDif = 0;
       
       for (int i = 0; i < stocks.length-1; i++) {
           for (int j = 1; j < stocks.length; j++) {
               if (i - j > maxDif) {
                   maxDif = i - j;
               }
           }
       }
       
       return maxDif;
      
    }


InterviewCake HW# 2:


private int[] getProducts() {
    int[] nums = {1, 7, 3, 4};
    int[] products= {};

   for (int i = 0; i < nums.length; i++) {
       for (int j = 0; j < nums.length; j++) {
           if (i = j) {
             
           } else {
            products[i] = (nums[i] * nums[j]);    
           }
           
       }
   }

}
