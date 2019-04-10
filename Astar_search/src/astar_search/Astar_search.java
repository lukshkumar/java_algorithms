


// Graph is implemented using Array of Linkedlist or an adjency list since it was a scarce graph. The names of the cities are encoded using Java 
// built-in "HashMap". A star is implemented using a queue mechanism to keep the records of its adjacent nodes and count their heuristic + previous path cost.

//Comments are added above each function for better understanding of the code.

package astar_search;

import java.io.*;

import java.util.*; 
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
 

class Astar_search
{ 
    public int V;   
    
    public LinkedList<Integer> adj[]; 
  
    // Constructor function to initialize the vertices (nodes)
    
    Astar_search(int v) 
    { 
        V = v; 
        
        adj = new LinkedList[v]; 
        
        for (int i=0; i<v; ++i) 
            adj[i] = new LinkedList(); 
    } 
  //This function creates the edges and since it is undirected graph therefore each edge is created both ways.
  
    void addEdge(int v,int w, int cost) 
    { 
        adj[v].add(0,w);
    
        adj[v].add(1,cost);
        
        adj[w].add(0,v);
        
        adj[w].add(1,cost);
       
    } 
    // This function which basically implements the A star algorithm by calculating as per its fucntion. 
 
    void Astar(int s, int d) 
    { 
        int source =  s;
        int destination = d;
        
        boolean visited[] = new boolean[V];
        int parent[] = new int[V];
  
        // Mark the current node as visited and enqueue it 
        
        visited[s]=true; 
        
        System.out.println("Search Nodes: ");
        
        int sum =0 , min =0;
        
        while (s!=destination) 
        { 
            int index = 0;
            
            
           System.out.print(convert2(s)); 
   
            System.out.print(" -> ");
            
            int first_adjacent = 1;
            int next = 0;
            while(index < adj[s].size()) 
            { 
                
               
                int n = adj[s].get(index); 
                if (!visited[n]) 
                { 
                    visited[n] = true;
                    parent[n] = s;
                    
                    int check = n;
                    int cost = 0, first, second = 0;
                    //String string = "" + convert2(check);
                    while(check!=source)
                    {

                        first = parent[check];
                      //  string = convert2(first) + " -> " + string;
                        while(adj[first].get(second) != check)
                        {
                            second++;
                        }
                        cost = cost + adj[first].get(second +1);
                        check = first;
                        second  = 0;

                    }

                    sum = cost + heuristic_table(convert2(n));
                    
                     if(first_adjacent==1)
                    {
                        min = sum;
                        next = n;
                    }
                    else 
                    {
                        if(sum < min)
                        {
                            min = sum;
                            next = n;
                        }
                    }

                }
                
               
                first_adjacent =0;
                index = index+ 2;
               
                
            }
            s= next;
            
            
           
        }
        
        System.out.print(convert2(destination));
        
        int check = destination;
        int cost = 0, first, second = 0;
        String string = "" + convert2(check);
        while(check!=source)
        {
            
            first = parent[check];
            string = convert2(first) + " -> " + string;
            while(adj[first].get(second) != check)
            {
                second++;
            }
            cost = cost + adj[first].get(second +1);
            check = first;
            second  = 0;
            
        }
        
        System.out.println("\n\nPathway: ");
        //String reverse = new StringBuffer(string).reverse().toString();
        
        System.out.println(string);
        
   
        System.out.println("\nTotal cost: " + cost + "\n");
    }
    
      // Function to map the corresponding edges with its hashed numbers.
  
    public void convert(String a, String b, int c)
    {
        HashMap<String,Integer> map = new HashMap<String,Integer>();
        
               map.put("ORADEA", 0);
		map.put("SIBIU", 1);
		map.put("ZERIND", 2);
		map.put("ARAD", 3);
		map.put("TIMISOARA", 4);
		map.put("LUGOJ", 5);
		map.put("MEHADIA", 6);
		map.put("DROBETA", 7);
		map.put("FAGARAS", 8);
		map.put( "PITESTI", 9);
		map.put("CRAIOVA", 10);
		map.put("Giugiu", 11);
		map.put("Neamt", 12);
		map.put("Pitesti", 13);
		map.put("Rimnicu_Vikea", 14);
		map.put("Urziceni", 15);
		map.put("Valsui", 16);
		map.put( "BUCHAREST", 17);
		map.put("LASI",18);
		map.put("EFORIE", 19);
		map.put("HIRSOVA",20);
        
        addEdge(map.get(a),map.get(b),c);
        
        
    }
      //Function to map the corresponding cities to its hashed numbers.
  
    public static int convert3(String a)
    {
        HashMap<String,Integer> map = new HashMap<String,Integer>();
        
               map.put("ORADEA", 0);
		map.put("SIBIU", 1);
		map.put("ZERIND", 2);
		map.put("ARAD", 3);
		map.put("TIMISOARA", 4);
		map.put("LUGOJ", 5);
		map.put("MEHADIA", 6);
		map.put("DROBETA", 7);
		map.put("FAGARAS", 8);
		map.put( "PITESTI", 9);
		map.put("CRAIOVA", 10);
		map.put("Giugiu", 11);
		map.put("Neamt", 12);
		map.put("Pitesti", 13);
		map.put("Rimnicu_Vikea", 14);
		map.put("Urziceni", 15);
		map.put("Valsui", 16);
		map.put( "BUCHAREST", 17);
		map.put("LASI",18);
		map.put("EFORIE", 19);
		map.put("HIRSOVA",20);
                
                return(map.get(a));
        
    }
     // Function to decode or hash back the cities names from numbers.

    public String convert2(int a)
    {
        HashMap<Integer, String> map = new HashMap<Integer,String>();
       
                map.put(0,"ORADEA");
		map.put(1,"SIBIU");
		map.put(2,"ZERIND");
		map.put(3,"ARAD");
		map.put(4,"TIMISOARA");
		map.put(5,"LUGOJ");
		map.put(6,"MEHADIA");
		map.put(7,"DROBETA");
		map.put(8,"FAGARAS");
		map.put(9,"PITESTI");
		map.put(10,"CRAIOVA");
		map.put(11,"Giugiu");
		map.put(12,"Neamt");
		map.put(13,"Pitesti");
		map.put(14,"Rimnicu_Vikea");
		map.put(15,"Urziceni");
		map.put(16,"Valsui");
		map.put(17, "BUCHAREST");
		map.put(18,"LASI");
		map.put(19,"EFORIE");
		map.put(20,"HIRSOVA");
        
        return map.get(a);
        
      
    }
    
    //This is the table where all of the heuristic values are stored.
    
    public int heuristic_table(String a)
    {
        //heuristic Table
            HashMap<String, Integer> map = new HashMap<String,Integer>();
            
                map.put("ORADEA", 380);
		map.put("SIBIU", 253);
		map.put("ZERIND", 374);
		map.put("ARAD", 366);
		map.put("TIMISOARA", 329);
		map.put("LUGOJ", 244);
		map.put("MEHADIA", 241);
		map.put("DROBETA", 242);
		map.put("FAGARAS", 176);
		map.put( "PITESTI", 100);
		map.put("CRAIOVA", 160);
		map.put("Giugiu",77);
		map.put("Neamt", 234);
		map.put("Pitesti", 100);
		map.put("Rimnicu_Vikea", 193);
		map.put("Urziceni", 80);
		map.put("Valsui", 199);
		map.put( "BUCHAREST", 0);
		map.put("LASI",226);
		map.put("EFORIE", 161);
		map.put("HIRSOVA",151);
        
             return map.get(a);
    }
    
   
    public static void main(String args[]) 
    { 
        Astar_search g = new Astar_search(21); 
        
           
   //Graph Edges Input with their corresponding weights.
    
                g.convert("ORADEA", "ZERIND", 71);
		g.convert("ORADEA", "SIBIU", 151);
		g.convert("ZERIND", "ARAD", 75);
                g.convert("ARAD", "TIMISOARA", 118);
		g.convert("ARAD", "SIBIU", 140);
		g.convert("TIMISOARA", "LUGOJ", 111);
		g.convert("LUGOJ", "MEHADIA", 70);
                g.convert("MEHADIA", "DROBETA", 75);
		g.convert("DROBETA", "CRAIOVA", 120);
		g.convert("SIBIU", "FAGARAS", 99);
		g.convert("SIBIU", "Rimnicu_Vikea", 80);
		g.convert("Rimnicu_Vikea", "Pitesti", 97);
		g.convert("Rimnicu_Vikea", "CRAIOVA", 146);
		g.convert("CRAIOVA", "Pitesti", 138);
		g.convert("FAGARAS", "BUCHAREST", 211);
		g.convert("Pitesti", "BUCHAREST", 101);
                g.convert("Giugiu", "BUCHAREST" , 90);
		g.convert("BUCHAREST", "Urziceni", 85);
		g.convert("Neamt", "LASI", 87);
		g.convert("Urziceni", "Valsui", 142);
		g.convert("Urziceni", "HIRSOVA", 98);
		g.convert("LASI", "Valsui", 92);
		g.convert("HIRSOVA", "EFORIE", 86);
                
                
                
            
           
       
                 
       
        
        System.out.println("-----------------------  A* (Informed Search Implementation)   --------------"); 
  
         System.out.println("\n ------------- --------------FROM ARAD TO BUCHAREST-------------------------------- \n");
  
        g.Astar(convert3("ARAD"),convert3("BUCHAREST"   )); 
        
        System.out.println("Note: Search nodes and pathway always remain the same in A star algorithm because  \n      it only proceed to the node having minimum of heuristic and previous path cost i.e f(n) = g(n) + h(n) ");
    } 
}

