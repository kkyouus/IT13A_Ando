
package midterm;

public class Multi_Dimentional1 {
    public static void main(String[] args) {
        
        int[][] numbers= {
                           {1, 2, 3, 4},
                           {5, 6, 7, 8},
                           {9, 10, 11, 12}
        };
        for (int i = 0; i < numbers.length; i++) {
            System.out.print("The Elements in Row" + (i + 1) + ": ");
            for (int j = 0; j < numbers[i].length; j++) {
                System.out.print(numbers[i][j] + " ");
            }
            System.out.println();
        }
        
    }
    
}
   
