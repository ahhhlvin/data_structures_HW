# AC_Homeworks

InterviewCake HW# 1 possible solution:

   int returnMaxDif()
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
