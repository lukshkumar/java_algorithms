

// Graph is implemented using Array of Linkedlist or an adjency list since it was a scarce graph. The names of the cities are encoded using Java 
// built-in "HashMap". DFS is implemented using a stack.

//Comments are added above each function for better understanding of the code.


package dfs_search;

import java.io.*;

import java.util.*; 
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;


 

class Dfs_search
{ 
    public int V;   
    
    public LinkedList<Integer> adj[]; 
  
    // Constructor function to initialize the vertices (nodes)
    
    Dfs_search(int v) 
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
    
    // This is a recursive function which basically implements the DFS traversal and thier pathway is also tracked. 
    // Values of parent are stored in an array named as parent.
    
    int stop = 0;
    void DFS_recursive(int s, int d, boolean visited[], int parent[])
    {
        int source =  s;
        int destination = d;
        
        visited[s]=true; 
         
               
        
            int index = 0;
          
            System.out.print(convert2(s) + " -> "); 
 
            
           
            while(index < adj[s].size()) 
            { 
                
               
                int n = adj[s].get(index); 
                if(!visited[n] && n==destination)
                {
                    visited[n] = true;
                    parent[n] = s;
                    System.out.print(convert2(n)); 
 
                    stop = 1;
                }
                else if (!visited[n] && stop==0) 
                { 
                    visited[n] = true;
                    parent[n] = s;
                    DFS_recursive(n, destination, visited, parent); 
                }
                index = index+ 2;
               
                
            }
            
            
           
        
        
    }
    //Function to initiate the DFS search and call recursive function.
    void DFS(int s, int d) 
    { 
        boolean visited[] = new boolean[V];
        int parent[] = new int[V];
  
        System.out.println("Search Nodes: ");
        
        DFS_recursive(s, d, visited, parent);
        
        
        int source = s;
        int destination = d;
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
        
   
        System.out.println("\nTotal cost: " + cost);
     

        
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
    
   
    public static void main(String args[]) 
    { 
        Dfs_search g = new Dfs_search(21); 
        
            //Graph Edges Input with their corresponding weights.

        
                g.convert("ORADEA", "ZERIND", 71);
		g.convert("ORADEA", "SIBIU", 151);
		
                g.convert("ARAD", "TIMISOARA", 118);
		g.convert("ARAD", "SIBIU", 140);
                g.convert("ZERIND", "ARAD", 75);
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
		g.convert("BUCHAREST", "Urziceni", 85);
		g.convert("Giugiu", "BUCHAREST" , 90);
                g.convert("Neamt", "LASI", 87);
		g.convert("Urziceni", "Valsui", 142);
		g.convert("Urziceni", "HIRSOVA", 98);
		g.convert("LASI", "Valsui", 92);
		g.convert("HIRSOVA", "EFORIE", 86);
       
       
        
        System.out.println("-----------------------  Depth First Search Implementation   --------------");
        
        System.out.println("\n ------------- --------------FROM ARAD TO BUCHAREST-------------------------------- \n");
  
        g.DFS(convert3("ARAD"),convert3("BUCHAREST")); 
        
        System.out.println("\nNote:  This is an exceptional case in which we can observe that search nodes and pathway are same but \n       this really does not guarantee in DFS. To verify this, you can replace the destination with Urziceni \n       and observe that search nodes are different than pathway.");
    } 
}

