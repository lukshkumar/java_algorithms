// N queens have been implemented using the CSP, where the variables are all queens, domain of each variable is placed is stored with in a 2d array 
// The -1 in domain array represents an empty slot which means that the particular position in that cordinate of n by n chess is free and not yet shrinked
//  by anyone.

// Encoding Scheme: Once any queen shrinks the domain of other variables, the particular cordinate position in domain array is replaced from -1 with the
// Number of queen (column number) to identify later on that which queen shrinked what queen.


package nqueen_csp;
import java.util.*;

/**
 *
 * @author Luksh Kumar
 */

public class Nqueen_csp {

    /**
     * @param args the command line arguments
     */
   
    int N;
    
    // Intializing the N (Size of Chess chess) and the domain of each variable i.e each queen.
    // Printing the End results.
    Nqueen_csp(int n )
    {
       
       N=n;
     
       int chess[][] = new int[N][N];
       int domain[][] = new int[N][N];
        
        
       
        for(int i  =0;i<N;i++)
        {
            for(int j = 0;j<N;j++)
            {
                chess[i][j] = 0;
                
                // -1 in the value of domain means that this postiion in the row is free. 
                // The variable that will make it to shrink will replace this -1 with its own value. 
                
                domain[i][j] = -1;
                
                
            }
        }

        if(recurence(chess, domain, 0) == true)
        {
            System.out.println("Solution: ");
            for(int i=0;i<N;i++)
            {
                for(int j=0;j<N;j++)
                {
                    if(chess[i][j] == 1)
                    {
                        System.out.print("Q" + "  ");
                    }
                    else
                    {
                        System.out.print("0" + "  ");
                    }
                    
                }
                System.out.println("");
            }
          /*  
            for(int i=0;i<N;i++)
            {
                for(int j=0;j<N;j++)
                {
                    System.out.print(domain[i][j] + " ");
                    
                }
                System.out.println("");
            }
           */
        }
        else
        {
            System.out.println("The solution can not be found because there is no way no placing the queens in such an order where they do not attack.");
        }
        //System.out.println("Total Recursive Calls:" + calls);

        
    }
    
    boolean check_constraints(int chess[][], int column, int row)
    {
        calls++;
        
        // This loop particularly checks for all the constraint in that same row.
        for(int i = column -1 ; i>=0; i--)
        {
            if(chess[row][i] == 1)
            {
                //System.out.println("False in 1");
                return false;
            }
        }
        
        // This loop particularly checks all the constraints in lower left diagonal.
        
        for(int i = column ,  j = row; i>=0 && j<=N-1; i-- , j++)
        {
            if(chess[j][i] == 1)
            {
              //  System.out.println("False in 2");
               return false;
            }
            
          
        }
        
        // This loop particularly checks all the constraints in upper left diagonal.
        
        for(int i = column ,  j = row  ; i>=0 && j>=0; i-- , j--)
        {
            if(chess[j][i] == 1)
            {
                //System.out.println("False in 3");
               return false;
            }
            
           
        }
        
        //Note: No need to check for right upper and lower diagonals and rows since the queens are added sqenntially, column by column.
        
        return true;
    }
    
    int calls = 0;
    
     boolean recurence(int[][] chess, int[][] domain, int column) {
         
        // Base Case 
         if(column == N)
         {
             return true;
                  
         }
         
         // Recursive Function.
         
         for(int i = 0;i<N;i++)
         {
             if(domain[i][column] == -1)
             {
                 
             if(check_constraints(chess, column, i))
             {
                 chess[i][column] = 1;
                 
                    // Shrinking the Domain of same row
                    for(int k = 0 ; k< N; k++)
                    {
                        if(domain[i][k] == -1)
                        domain[i][k] = column;
                    }
                    
                    // Shrinking the Domain of same column
                    for(int k = 0 ; k< N; k++)
                    {
                        if(domain[k][column] == -1)
                        domain[k][column] = column;
                    }
                    
                    // Shrinking the Domain of the lower left diagonal
                    for(int k = column ,  l = i; k>=0 && l<=N-1; k-- , l++)
                    {
                        if(domain[l][k] == -1)
                       domain[l][k] = column;


                    }
                    
                    // Shrinking the Domain of the upper right diagonal
                    for(int k = column ,  l = i; l>=0 && k<=N-1; k++ , l--)
                    {
                        if(domain[l][k] == -1)
                       domain[l][k] = column;


                    }
                    
                    // Shrinking the Domain of the upper left diagonal
                    for(int k = column ,  l = i; l>=0 && k>=0; k-- , l--)
                    {
                        if(domain[l][k] == -1)
                       domain[l][k] = column;


                    }
                    
                    // Shrinking the Domain of the lower right diagonal
                    for(int k = column ,  l = i; l<=N-1 && k<=N-1; k++ , l++)
                    {
                        if(domain[l][k] == -1)
                       domain[l][k] = column;


                    }

 

                 if(recurence(chess, domain, column + 1))
                 {
                    return true;
                 }
            
                 
                 
                 chess[i][column] = 0;
                 
                 // Removing the values which we shrinked ealier because we are placing the queen on different place now.
                 
                 for(int k = 0;k<N;k++)
                 {
                     for(int l = 0;l<N;l++)
                     {
                        if(domain[k][l] == column)
                        {
                            domain[k][l] = -1;
                        }
                     }
                 }
                    

 
             }
             
            
                 
          
         }
        }
         
         return false;
  
    
    }
   
     
     
    public static void main(String[] args) {
        // TODO code application logic here
        
        System.out.println("Enter the number of queens: (A Positive Integer Value)");
        Scanner in = new Scanner(System.in); 
        int value  = in.nextInt();
        if(value<=0)
        {
            System.out.println("Re-enter the number of queens: (A Positive Integer value)"); 
            value  = in.nextInt();
        }
        Nqueen_csp obj = new Nqueen_csp(value);
        
        
    }

    
}
