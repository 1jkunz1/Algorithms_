public class enumerate {

    // all runs start at "main"
    public static void main(String[] args) {
        enumerateSubsets(5);
        enumerateCombinations(3, 5);
        enumerate5Permutations();
    }


    // enumerate all subsets of the set { 1, 2, ..., n }, where n < 65.
    public static void enumerateSubsets (int n) {   
         // Pre: n < 65
         System.out.println("All subsets of " + n + " numbers:"); 
         for (int x = 0; x < (1 << n); x++) {
             System.out.print("{"); 
             for (int j = 1; j <= n; j++)
		 if ((x & (1 << (j-1))) != 0) 
		     System.out.print(j + ", ");
             System.out.print("}\n"); 
         }
    }

    // print the first n elements of the array x as a set.
    public static void printArray(int x[], int n) {
    	System.out.print("{"); 
    	System.out.print(x[0]);
    	for (int i = 1; i < n; i++)
	    System.out.print(", " + x[i]);
    	System.out.print("}\n"); 
    }
    
    // print all k-combinations of n elements.
    public static void enumerateCombinations (int k, int n) {   
        int x[] = new int[100];    // k <= 100
	System.out.println("All " + k + "-combinations of " + n + " numbers:"); 
        for (int j = 0; j < k; j++) x[j] = j+1;
        while (true) {
             printArray(x, k);
             if (nextCombination(k - 1, x, k, n) == false) break; 
//change the call to accommodate the extra parameter
        }
    }

    // modify the array x to generate the next k-combination from x.
    // In general, the first k-combination of n elements is { 1, 2, ..., k } 
    // and the last k-combination is { n-k+1, n-k+2, ..., n }.
     public static boolean nextCombination (int j, int x[], int k, int n) {
        if (j < 0 || j > k) return false;

        if (x[j] <= (n - k + j)) {
            x[j]++;  
            for (int i = 1; i < k - j;  i++)
                x[i+j] = x[j]+i;
            return true; 
        }

        return nextCombination(j - 1, x, k, n);
    }
    // This is an awkward method to print all 5! permutations of 5 elements.
    public static void enumerate5Permutations () {   
        // Pre: n = 5
	System.out.println("All permutations of 5 numbers:"); 
        for (int x1 = 1; x1 <= 5; x1++) 
             for (int x2 = 1; x2 <= 5; x2++) if (x1 != x2)
                  for (int x3 = 1; x3 <= 5; x3++) if (x3 != x1 && x3 != x2)
                      for (int x4 = 1; x4 <= 5; x4++) if (x4 != x1 && x4 != x2 && x4 != x3)
                           for (int x5 = 1; x5 <= 5; x5++) 
                               if (x5 != x1 && x5 != x2 && x5 != x3 && x5 != x4) {
				   System.out.print("[ ");
				   System.out.print(x1+", "+x2+", "+x3+", "+x4+", "+x5); 
				   System.out.print("]\n"); 
			       }
    }

//My Implementation of next permutation function 

Boolean nextPermutation(int x[], int N)
{
     int i, pos, maxPos, p;
     

     pos = maxPos = -1;
     for (i=0; i < N-1; i++)
         if (x[i] < x[i+1])
            pos = i;
           
                                         
  if (pos == -1) 
        return false;

    
     for (i=pos+1; i < N; i++)
         if (x[pos] < x[i])
            maxPos = i;
     


     t = x[pos];
     x[pos] = x[maxPos];
     x[maxPos] = t;
     

     for (i=pos+1; i < (N+pos+1)/2; i++)
     {
         t = x[i];
         x[i] = x[N-i+pos];
         x[N-i+pos] = t;
     }

     
     return true;
}
}
