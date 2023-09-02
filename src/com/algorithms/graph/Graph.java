package com.algorithms.graph;

import com.algorithms.base.base3.Bag;
import com.algorithms.base.base3.Stack;
import com.algorithms.util.In;

/**
 * @author jiangfw
 */
public class Graph {
	private static final String NEWLINE = System.getProperty("line.separator");

	private final int V;
	private int E;
	private Bag<Integer>[] adj;

	public Graph(int V) {
		if (V < 0) {
            throw new IllegalArgumentException("Number of vertices must be nonnegative");
        }
		this.V = V;
		this.E = 0;
		adj = (Bag<Integer>[])new Bag[V];
		for(int v = 0; v < V; v++){
			adj[v] = new Bag<Integer>();
		}
	}
	
    public Graph(In in) {
        this(in.readInt());
        int E = in.readInt();
        if (E < 0) {
            throw new IllegalArgumentException("Number of edges must be nonnegative");
        }
        for (int i = 0; i < E; i++) {
            int v = in.readInt();
            int w = in.readInt();
            addEdge(v, w);
        }
    }
	
	public Graph(Graph G){
		this(G.V);
		this.E = G.E;
		for(int v = 0; v < G.V; v++){
			Stack<Integer> reverse = new Stack<Integer>();
			for(int w :G.adj[v]){
				reverse.push(w);
			}
			
			for(int w : reverse){
				adj[v].add(w);
			}
		}
	}
	
	public int V(){
		return V;
	}
	
	public int E(){
		return E;
	}
	
    // throw an IndexOutOfBoundsException unless 0 <= v < V
    private void validateVertex(int v) {
        if (v < 0 || v >= V) {
            throw new IndexOutOfBoundsException("vertex " + v + " is not between 0 and " + (V-1));
        }
    }

    /**
     * Adds the undirected edge v-w to this graph.
     *
     * @param  v one vertex in the edge
     * @param  w the other vertex in the edge
     * @throws IndexOutOfBoundsException unless both 0 <= v < V and 0 <= w < V
     */
    public void addEdge(int v, int w) {
        validateVertex(v);
        validateVertex(w);
        E++;
        adj[v].add(w);
        adj[w].add(v);
    }
    
    public Iterable<Integer> adj(int v) {
        validateVertex(v);
        return adj[v];
    }

    /**
     * Returns the degree of vertex <tt>v</tt>.
     *
     * @param  v the vertex
     * @return the degree of vertex <tt>v</tt>
     * @throws IndexOutOfBoundsException unless 0 <= v < V
     */
    public int degree(int v) {
        validateVertex(v);
        return adj[v].size();
    }


    /**
     * Returns a string representation of this graph.
     *
     * @return the number of vertices <em>V</em>, followed by the number of edges <em>E</em>,
     *         followed by the <em>V</em> adjacency lists
     */
    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append(V + " vertices, " + E + " edges " + NEWLINE);
        for (int v = 0; v < V; v++) {
            s.append(v + ": ");
            for (int w : adj[v]) {
                s.append(w + " ");
            }
            s.append(NEWLINE);
        }
        return s.toString();
    }
}
