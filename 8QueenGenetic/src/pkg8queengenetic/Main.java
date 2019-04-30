
package pkg8queengenetic;
import java.util.*;

/**
 *
 * @author AliKirmani
 */



class Implementation{
    
    public int n;
    
    public Implementation(int rec){
        n=rec;
        gen_first = new int[n];
        gen_second= new int[n];
        gen_third= new int[n];
        gen_fourth= new int[n];
    }
    
    public int [] gen_first;
    public int [] gen_second;
    public int [] gen_third;
    public int [] gen_fourth;

    
    public void mutate(int first[], int second[], int third[], int fourth[]){
        
        int [] unique_first = new int[n];
        int [] unique_second = new int[n];
        int [] unique_third = new int[n];
        int [] unique_fourth = new int[n];
        
        HashSet<Integer> hash = new HashSet<Integer>();
        HashSet<Integer> hash2 = new HashSet<Integer>();
        HashSet<Integer> hash3 = new HashSet<Integer>();
        HashSet<Integer> hash4 = new HashSet<Integer>();
        
        
        for(int i=0;i<n;i++){
            hash.add(i+1);
            hash2.add(i+1);
            hash3.add(i+1);
            hash4.add(i+1);
        }
        /*
        System.out.println("First");
        
        for(int i=0;i<n;i++){
            System.out.print(first[i]+" ");
        }
        System.out.println("");
        
        System.out.println("");
        
        */
        
        for(int i=0;i<n;i++){
            if(hash.contains(first[i])){
                hash.remove(first[i]);
            }
            
            if(hash2.contains(second[i])){
                hash2.remove(second[i]);
            }
            
            if(hash3.contains(third[i])){
                hash3.remove(third[i]);
            }
            
            if(hash4.contains(fourth[i])){
                hash4.remove(fourth[i]);
            }
            
        }
        
        //System.out.println("Set");
        // Example
        Iterator iterator = hash.iterator();
        Iterator iterator2 = hash2.iterator();
        Iterator iterator3 = hash3.iterator();
        Iterator iterator4 = hash4.iterator();
       
        /*while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
        
        */
        
        // Duplicate Elimination
        
        // First
        
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(first[i]==first[j]){
                    //System.out.println("Dup: "+ first[i]);
                    while(iterator.hasNext()){
                        first[j]=(int)iterator.next();
                       // hash.remove(first[j]);
                        break;
                    }
                }
            }
        }
        
        // Second
        
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(second[i]==second[j]){
                    //System.out.println("Dup: "+ first[i]);
                    while(iterator2.hasNext()){
                        second[j]=(int)iterator2.next();
                       // hash.remove(first[j]);
                        break;
                    }
                }
            }
        }
        
         // Third
        
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(third[i]==third[j]){
                    //System.out.println("Dup: "+ first[i]);
                    while(iterator3.hasNext()){
                        third[j]=(int)iterator3.next();
                       // hash.remove(first[j]);
                        break;
                    }
                }
            }
        }
        
           // Fourth
        
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(fourth[i]==fourth[j]){
                    //System.out.println("Dup: "+ first[i]);
                    while(iterator4.hasNext()){
                        fourth[j]=(int)iterator4.next();
                       // hash.remove(first[j]);
                        break;
                    }
                }
            }
        }
        
        /*
         System.out.println("Then");
        
        for(int i=0;i<n;i++){
            System.out.print(first[i]+" ");
        }
        
        */
        
        int same1 =1, same2 =1, same3 =1;
        
        for(int i = 0;i<3;i++)
        {
            while(same1 !=0 || same2 !=0 || same3!=0 )
           {
            for(int j =0 ;j<n;j++)
            {
                
                if(i == 0)
                {
                    
                    if(first[j]==second[j])
                    {

                    }
                    else
                    {
                        same1 = 0;
                    }
                    if(first[j]==third[j])
                    {

                    }
                    else
                    {
                        same2 = 0;
                    }
                    if(first[j]==fourth[j])
                    {

                    }
                    else
                    {
                        same3 = 0;
                    }
                }
                
                 if(i == 1)
                {
                    
                    if(second[j]==third[j])
                    {

                    }
                    else
                    {
                        same2 = 0;
                    }
                    
                    if(second[j]==fourth[j])
                    {

                    }
                    else
                    {
                        same3 = 0;
                    }
                }
                 
                    if(i == 2)
                {
                    
                    if(third[j]==fourth[j])
                    {

                    }
                    else
                    {
                        same3 = 0;
                    }
                    
                    
                }
                    
                 
                
               
                
               
                    

            }
           //   System.out.println("i: " + i  + "  same1: " + same1 + "  same2: " + same2 + "   same3: " + same3);
            if(i == 0)
            {
             if(same1 == 0 && same2 ==0 && same3 ==0)
                {
                    
                }else
                {
                    Integer[] array = new Integer[]{first[0], first[1], first[2], first[3],first[4],first[5],first[6],first[7]};

                       
                        List<Integer> l = Arrays.asList(array);


                        Collections.shuffle(l);
                        
                      Object [] firsty = l.toArray();
                      
		for (int k = 0; k < firsty.length; k++)
			first[k] = (Integer)firsty[k];
                
                
                
                same1 =1; same2 =1; same3 =1;
                
                
                       
 
                }
            }
            
            if(i == 1)
            {
             if(same2 ==0 && same3 ==0)
                {
                    same1 =0;
                }else
                {
                    Integer[] array = new Integer[]{second[0], second[1], second[2], second[3],second[4],second[5],second[6],second[7]};

                       
                        List<Integer> l = Arrays.asList(array);


                        Collections.shuffle(l);
                        
                      Object [] firsty = l.toArray();
                      
		for (int k = 0; k < firsty.length; k++)
			second[k] = (Integer)firsty[k];
                
                
                same1 =0; same2 =1; same3 =1;
                
                
                       
 
                }
            }
            
             if(i == 2)
            {
                
                
             if(same3 ==0)
                {
                    same1 =0; same2 = 0;
                    }else
                {
                    Integer[] array = new Integer[]{third[0], third[1], third[2], third[3],third[4],third[5],third[6],third[7]};

                       
                        List<Integer> l = Arrays.asList(array);


                        Collections.shuffle(l);
                        
                      Object [] firsty = l.toArray();
                      
		for (int k = 0; k < firsty.length; k++)
			third[k] = (Integer)firsty[k];
                
                
                same1 =0; same2 =0; same3 =1;
                       
 
                }
            }
           }
            
            same1 =1;same2 =1;same3 =1;
        }
        
        
        
        for(int i=0;i<n;i++){
            gen_first[i]= first[i];
            gen_second[i]= second[i];
            gen_third[i]= third[i];
            gen_fourth[i]= fourth[i];
        }
        
        
    }
    
    public void crossOver(int first[], int second[], int third[]){
        // Criteria for Cross-over: (1st with 2nd) and  (2nd with 3rd)
        
       /* int [] first_new= first;
        int [] second_new= second;
         int [] second_third_new= second;
        int [] third_new = third;
        */
       
       int [] first_new= new int [n];
       int [] second_new= new int [n];
       int [] second_third_new= new int [n];
       int [] third_new= new int [n];
       
       for(int i=0;i<n;i++){
           first_new[i]= first[i];
           second_new[i]= second[i];
           second_third_new[i]= second[i];
           third_new[i]= third[i];
           
       }
       
        
        
        //System.out.println("-------------ORIGINAL-------------");
        
        //System.out.println("First");
        
        for(int i=0;i<n;i++){
          //  System.out.print(first[i]+ " ");
        }
        //System.out.println("");
        //System.out.println("Second");
        
        for(int i=0;i<n;i++){
          //  System.out.print(second[i]+ " ");
        }
        //System.out.println("");
        //System.out.println("Third");
        
        for(int i=0;i<n;i++){
          //  System.out.print(third[i]+ " ");
        }
        //System.out.println("");
        
       //System.out.println("-------------AFTER-------------");
       
       // 1st with 2nd
       
       // Generate random cross over point
       Random rand = new Random();
       int point;
       point= rand.nextInt(n-1)+1;
       
       //System.out.println("First Point: "+ point);
       
       int temp;
       
       for(int i=point;i<n;i++){
           temp= first[i];
           first_new[i]=second[i];
           second_new[i]= temp;
       }
       
       // 2nd with 3rd
       
       point= rand.nextInt(n-1)+1;
       
       //System.out.println("Second Point: "+ point);
       
       for(int i=point;i<n;i++){
           temp=second[i];
           second_third_new[i]= third[i];
           third[i]= temp;
       }
       
       
       
       // Printing
       
        
       /*
        System.out.println("First");
        
        for(int i=0;i<n;i++){
            System.out.print(first_new[i]+ " ");
        }
        
        System.out.println("");
        
        System.out.println("Second");
        
        for(int i=0;i<n;i++){
            System.out.print(second_new[i]+ " ");
        }
        
         System.out.println("");
        
        System.out.println("Third");
        
        for(int i=0;i<n;i++){
            System.out.print(second_third_new[i]+ " ");
        }
        
         System.out.println("");
        
        System.out.println("Fourth");
        
        for(int i=0;i<n;i++){
            System.out.print(third[i]+ " ");
        }
        
        System.out.println("");
        
        
        */
        
        /*
        gen_first= first_new;
        gen_second= second_new;
        gen_third= second_third_new;
        gen_fourth= third;
        */
        
        for(int i=0;i<n;i++){
            gen_first[i]= first_new[i];
            gen_second[i]= second_new[i];
            gen_third[i]= second_third_new[i];
            gen_fourth[i]= third[i];
        }
        
    }
    
     public int getFitness(int positions[]){
         
         int row_current,col_current,row_check,col_check;
         int row_new, col_new;
         int row_temp=0, col_temp=0;
         int row_temp2=0, col_temp2=0;
         int row_temp3=0, col_temp3=0;
         int row_temp4=0, col_temp4=0;
         int row_temp5=0, col_temp5=0;
         int row_temp6=0, col_temp6=0;
         int row_temp7=0, col_temp7=0;
         int count=0;
        

         for(int j=0;j<n;j++){
             row_check=positions[j];
             col_check=j;
             // diagonal (row d, col u)
             int checking=0;
             int checking2=0;
             int checking3=0;
             int checking4=0;
             int checking5=0;
             int checking6=0;
             int checking7=0;
             int checking8=0;
                
             for(int i=0;i<n;i++){
                if(row_check>0){
                    if(checking==0){
                        row_temp= row_check-1;
                        col_temp= col_check+1;
                        checking=1;
                    }else{
                        row_temp--;
                        col_temp++;
                    }
                    
                    if(col_temp>=0 && col_temp<n){

                        if(positions[col_temp]==row_temp){
                            count++;
                        }
                    
                    }

                }
             

             // diagonal (row u, col d)
           /*
                if(col_check>0){
                    if(checking2==0){
                        row_temp2= row_check+1;
                        col_temp2= col_check-1;
                        checking2=1;
                    }else{
                        row_temp2++;
                        col_temp2--;
                    }
                    
                    if(col_temp2>=0 && col_temp2<n){

                        if(positions[col_temp2]==row_temp2){
                            //count++;
                        }
                    
                    }

                }
             
             */

             // diagonal(row d, col d)
            
                if(row_check>0 && col_check>0){
                    if(checking3==0){
                        row_temp3= row_check-1;
                        col_temp3= col_check-1;
                        checking3=1;
                    }else{
                        row_temp3--;
                        col_temp3--;
                    }
                    
                 
                    if(col_temp3>=0 && col_temp3<n){
                        if(positions[col_temp3]==row_temp3){
                            count++;
                        }
                    }

                }
             
             

             // row(u)
             
           
                 if(checking4==0){
                    row_temp4= row_check+1;
                    col_temp4= col_check;
                    checking4=1;
                 }else{
                     row_temp4++;
                 }
                 
                  if(col_temp4>=0 && col_temp4<n){
                        if(positions[col_temp4]==row_temp4){
                            count++;
                        }
                    }
                 
             
             
               // row(d)
             
             
                 if(checking5==0){
                    row_temp5= row_check-1;
                    col_temp5= col_check;
                    checking5=1;
                 }else{
                     row_temp5--;
                 }
                 
                  if(col_temp5>=0 && col_temp5<n){
                        if(positions[col_temp5]==row_temp5){
                            count++;
                        }
                    }
                 
             
             
                     // col(u)
            
                 if(checking6==0){
                    row_temp6= row_check;
                    col_temp6= col_check+1;
                    checking6=1;
                 }else{
                     col_temp6++;
                 }
                 
                  if(col_temp6>=0 && col_temp6<n){
                        if(positions[col_temp6]==row_temp6){
                           count++;
                        }
                    }
                 
             
             
                     // col(d)
             
            /*
                 if(checking7==0){
                    row_temp7= row_check;
                    col_temp7= col_check-1;
                    checking7=1;
                 }else{
                     col_temp7--;
                 }
                 
                  if(col_temp7>=0 && col_temp7<n){
                        if(positions[col_temp7]==row_temp7){
                            //count++;
                        }
                    }
                 */
             }


         }
         //System.out.println(count);
         
         return count;
        
    }
}

public class Main {

    public static void main(String[] args) {
        
        int n=8;
        
        Implementation obj= new Implementation(n);
        
        obj.n=n;
        
        
        
        int [] positions= {3,2,5,4,3,2,1,3};
        int [] positions2= {2,4,4,1,5,1,2,4};
        int [] positions3= {3,2,7,5,2,4,1,1};
        int [] positions4= {2,4,7,4,8,5,5,2};
        int [] positions5= {1,5,8,6,3,7,2,4};
         
        //int attacks= obj.getFitness(positions5);
        
        //System.out.println(attacks);
        
        // GET Random Population
        
        Random rand = new Random();
        
        //System.out.println(rand.nextInt(n)+1);
        
       int [] first = new int [n];
       int [] second= new int [n];
       int [] third= new int [n];
       int [] fourth= new int [n];
       
       HashSet<Integer> hash = new HashSet<Integer>();
       HashSet<Integer> hash2 = new HashSet<Integer>();
       HashSet<Integer> hash3 = new HashSet<Integer>();
       HashSet<Integer> hash4 = new HashSet<Integer>();
       int add;
       
       /*
  
       for(int i=0;i<n;i++){
           add= rand.nextInt(n)+1;
           
           while (hash.contains(add)) { 
                add = rand.nextInt(n)+1; 
           }
           
           hash.add(add);
           first[i]= add;
           
           add= rand.nextInt(n)+1;
           
            while (hash2.contains(add)) { 
                add = rand.nextInt(n)+1; 
           }
           
            hash2.add(add);
           second[i]= add;
           
           add= rand.nextInt(n)+1;
           
           while (hash3.contains(add)) { 
                add = rand.nextInt(n)+1; 
           }
           
           hash3.add(add);
           
           third[i]= add;
           
           add= rand.nextInt(n)+1;
           
           while (hash4.contains(add)) { 
                add = rand.nextInt(n)+1; 
           }
           
           hash4.add(add);
           fourth[i]= add;
       }
       
       */
       
       for(int i=0;i<n;i++){
           add= rand.nextInt(n)+1;
           first[i]= add;
           
           add= rand.nextInt(n)+1;
           second[i]= add;
           
           add= rand.nextInt(n)+1;
           third[i]= add;
           
            add= rand.nextInt(n)+1;
           fourth[i]= add;
       }
        
        int [] fitness={obj.getFitness(first),obj.getFitness(second), obj.getFitness(third), obj.getFitness(fourth)};
        
       // System.out.println(fitness[1]);
       
       //int [] fitness= {2,1,4,3};
       int [] fitness_index= {0,1,2,3};
       
       int temp, temp2;
       
       for(int i=0;i<fitness.length-1;i++){
           for(int j=0;j<fitness.length-i-1;j++){
               if(fitness[j] > fitness[j+1]){
                   temp= fitness[j];
                   fitness[j]= fitness[j+1];
                   fitness[j+1]= temp;
                   
                   temp= fitness_index[j];
                   fitness_index[j]=fitness_index[j+1];
                   fitness_index[j+1]=temp;
               }
           }
       }
       
      /* for(int i=0;i<fitness.length;i++){
           System.out.println(fitness[i]+ " " + fitness_index[i]);
       }

       */  
      
     /* for(int i=0;i<first.length;i++){
           System.out.println(first[i]);
       }
      
     */
     
        System.out.println("Fitness 1: "+ fitness[0]);
     
     int [] sending_first= new int[n];
     int [] sending_second= new int[n];
     int [] sending_third= new int[n];
     
    int [] gen_first= new int[n];
    int [] gen_second= new int[n];
    int [] gen_third= new int[n];
    int [] gen_fourth= new int[n];
     
     for(int i=0;i<3;i++){
         if(i==0){
            if(fitness_index[i]==0){
                sending_first= first;
            }else if(fitness_index[i]==1){
                sending_first= second;
            }else if(fitness_index[i]==2){
                sending_first= third;
            }else if(fitness_index[i]==3){
                sending_first= fourth;
            }
            
         }
         
         if(i==1){
            if(fitness_index[i]==0){
                sending_second= first;
            }else if(fitness_index[i]==1){
                sending_second= second;
            }else if(fitness_index[i]==2){
                sending_second= third;
            }else if(fitness_index[i]==3){
                sending_second= fourth;
            }
            
         }
         
         if(i==2){
            if(fitness_index[i]==0){
                sending_third= first;
            }else if(fitness_index[i]==1){
                sending_third= second;
            }else if(fitness_index[i]==2){
                sending_third= third;
            }else if(fitness_index[i]==3){
                sending_third= fourth;
            }
            
         }
         
     }
       /* System.out.println("First");
     for(int i=0;i<n;i++){
         System.out.println(sending_first[i]);
     }
        System.out.println("Second");
     for(int i=0;i<n;i++){
         System.out.println(sending_second[i]);
     }
        System.out.println("Third");
     for(int i=0;i<n;i++){
         System.out.println(sending_third[i]);
     }

    */
       
       obj.crossOver(sending_first, sending_second, sending_third);
       

    
     for(int i=0;i<n;i++){
            gen_first[i]= obj.gen_first[i];
            gen_second[i]= obj.gen_second[i];
            gen_third[i]= obj.gen_third[i];
            gen_fourth[i]= obj.gen_fourth[i];
            //System.out.println("Here: "+" "+ gen_first[i]);
        }
    
     obj.mutate(gen_first, gen_second, gen_third, gen_fourth);
     
        // Get Fitness
        /*
        int [] fitness_new_2={obj.getFitness(gen_first),obj.getFitness(gen_second), obj.getFitness(gen_third), obj.getFitness(gen_fourth)};
        
        // Get Fitness Index
        int [] fitness_index_new_2= {0,1,2,3};      
         
        // Sort Fitness and Fitness Index
        
          for(int i=0;i<fitness_new_2.length-1;i++){
           for(int j=0;j<fitness_new_2.length-i-1;j++){
               if(fitness_new_2[j] > fitness_new_2[j+1]){
                   temp= fitness_new_2[j];
                   fitness_new_2[j]= fitness_new_2[j+1];
                   fitness_new_2[j+1]= temp;
                   
                   temp= fitness_index_new_2[j];
                   fitness_index_new_2[j]=fitness_index_new_2[j+1];
                   fitness_index_new_2[j+1]=temp;
               }
           }
       }
          
          System.out.println("Fitness 2: "+ fitness_new_2[0]);

*/
     
     
     int fitness_count=0;
     
        
     
     // ---------------------------- STARTING THE LOOPING PROCESS -------------------------- ///
      
     int gen_counter=0;
     int check=99;
     
     while(check!=0 ){
         
         // Get Fitness
        int [] fitness_new={obj.getFitness(gen_first),obj.getFitness(gen_second), obj.getFitness(gen_third), obj.getFitness(gen_fourth)};
        
        // Get Fitness Index
        int [] fitness_index_new= {0,1,2,3};      
         
        // Sort Fitness and Fitness Index
        
          for(int i=0;i<fitness_new.length-1;i++){
           for(int j=0;j<fitness_new.length-i-1;j++){
               if(fitness_new[j] > fitness_new[j+1]){
                   temp= fitness_new[j];
                   fitness_new[j]= fitness_new[j+1];
                   fitness_new[j+1]= temp;
                   
                   temp= fitness_index_new[j];
                   fitness_index_new[j]=fitness_index_new[j+1];
                   fitness_index_new[j+1]=temp;
               }
           }
       }
          
          System.out.println("Fitness "+ (gen_counter+2)+": "+fitness_new[0]);
          
          if(fitness_new[0]==0){
              check=0;
          }
          
          if(gen_counter>10000 && gen_counter<20000){
              if(fitness_new[0]==1){
                  check=0;
              }
          }
          
          
          //System.out.println("Counter: "+ gen_counter);
          
          if(gen_counter>=20000){
              if(fitness_new[0]==2 ){
                  check=0;
              }
          }
          
          if(gen_counter >40000){
              check=0;
          }
          
         
          
          if(check==0){
               System.out.println("Generation:");
              if(fitness_index_new[0]==0){
                  for(int i=0;i<n;i++){
                      System.out.print(gen_first[i]+ " ");
                  }
                  
                  System.out.println("\nSolution: ");
                  for(int i = 0;i<n;i++)
                  {
                      for(int j=1;j<=n;j++)
                      {
                          if(j == gen_first[i])
                          {
                              System.out.print("Q" + " ");
                          }
                          else
                          {
                              System.out.print("0" + " ");
                          }
                          
                      }
                      System.out.println("");
                  }
              }
              
              if(fitness_index_new[0]==1){
                  for(int i=0;i<n;i++){
                      System.out.print(gen_second[i]+ " ");
                  }
                  
                   System.out.println("\nSolution: ");
                  for(int i = 0;i<n;i++)
                  {
                      for(int j=1;j<=n;j++)
                      {
                          if(j == gen_second[i])
                          {
                              System.out.print("Q" + " ");
                          }
                          else
                          {
                              System.out.print("0" + " ");
                          }
                          
                      }
                      System.out.println("");
                  }
              }
              
              if(fitness_index_new[0]==2){
                  for(int i=0;i<n;i++){
                      System.out.print(gen_third[i]+ " ");
                  }
                  
                   System.out.println("\nSolution: ");
                  for(int i = 0;i<n;i++)
                  {
                      for(int j=1;j<=n;j++)
                      {
                          if(j == gen_third[i])
                          {
                              System.out.print("Q" + " ");
                          }
                          else
                          {
                              System.out.print("0" + " ");
                          }
                          
                      }
                      System.out.println("");
                  }
              }
              
              if(fitness_index_new[0]==3){
                  for(int i=0;i<n;i++){
                      System.out.print(gen_fourth[i]+ " ");
                  }
                  
                   System.out.println("\nSolution: ");
                  for(int i = 0;i<n;i++)
                  {
                      for(int j=1;j<=n;j++)
                      {
                          if(j == gen_fourth[i])
                          {
                              System.out.print("Q" + " ");
                          }
                          else
                          {
                              System.out.print("0" + " ");
                          }
                          
                      }
                      System.out.println("");
                  }
              }
              
          }
          
          System.out.println("");
          
         // Choose best 3 Generations based on Fitness
         
              for(int i=0;i<3;i++){
                if(i==0){
                   if(fitness_index[i]==0){
                       sending_first= gen_first;
                   }else if(fitness_index[i]==1){
                       sending_first= gen_second;
                   }else if(fitness_index[i]==2){
                       sending_first= gen_third;
                   }else if(fitness_index[i]==3){
                       sending_first= gen_fourth;
                   }

                }

                if(i==1){
                   if(fitness_index[i]==0){
                       sending_second= gen_first;
                   }else if(fitness_index[i]==1){
                       sending_second= gen_second;
                   }else if(fitness_index[i]==2){
                       sending_second= gen_third;
                   }else if(fitness_index[i]==3){
                       sending_second= gen_fourth;
                   }

                }

                if(i==2){
                   if(fitness_index[i]==0){
                       sending_third= gen_first;
                   }else if(fitness_index[i]==1){
                       sending_third= gen_second;
                   }else if(fitness_index[i]==2){
                       sending_third= gen_third;
                   }else if(fitness_index[i]==3){
                       sending_third= gen_fourth;
                   }

                }
         
            }
              
         // Apply CrossOver
         
         obj.crossOver(sending_first, sending_second, sending_third);
         
         // Setting the New Generations:
         
         for(int i=0;i<n;i++){
            gen_first[i]= obj.gen_first[i];
            gen_second[i]= obj.gen_second[i];
            gen_third[i]= obj.gen_third[i];
            gen_fourth[i]= obj.gen_fourth[i];
        }
         
         // Mutation:
         
         obj.mutate(gen_first, gen_second, gen_third, gen_fourth);
         
           for(int i=0;i<n;i++){
            gen_first[i]= obj.gen_first[i];
            gen_second[i]= obj.gen_second[i];
            gen_third[i]= obj.gen_third[i];
            gen_fourth[i]= obj.gen_fourth[i];
        }
        
         // Counter
         gen_counter++;
     }
        
    
    }
    
}
