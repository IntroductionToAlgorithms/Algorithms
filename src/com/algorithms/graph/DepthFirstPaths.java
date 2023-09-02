package com.algorithms.graph;

import java.util.Arrays;

import com.algorithms.base.base3.Stack;
import com.algorithms.util.In;
import com.algorithms.util.StdOut;

/**
 * @author jiangfw
 */
public class DepthFirstPaths {
	private boolean[] marked;
	private int[] edgeTo;
	private final int s;
	
	public DepthFirstPaths(Graph G, int s){
		this.s = s;
		edgeTo = new int[G.V()];
		marked = new boolean[G.V()];
		dfs(G,s);
	}
	
	private void dfs(Graph G, int v){
		marked[v] = true;
		System.out.println(Arrays.toString(edgeTo));
		for(int w : G.adj(v)){
			if(!marked[w]){
				edgeTo[w] = v;
				dfs(G,w);
			}
			
		}
	}
	
    public boolean hasPathTo(int v) {
        return marked[v];
    }

    /**
     * Returns a path between the source vertex <tt>s</tt> and vertex <tt>v</tt>, or
     * <tt>null</tt> if no such path.
     * @param v the vertex
     * @return the sequence of vertices on a path between the source vertex
     *   <tt>s</tt> and vertex <tt>v</tt>, as an Iterable
     */
    private Iterable<Integer> pathTo(int v) {
        if (!hasPathTo(v)) {
            return null;
        }
        Stack<Integer> path = new Stack<Integer>();
        for (int x = v; x != s; x = edgeTo[x]) {
            path.push(x);
        }
        path.push(s);
        return path;
    }
    
    public static void main(String[] args) {
        In in = new In("input/tinyG.txt");
        Graph G = new Graph(in);
        int s = 0;
        DepthFirstPaths dfs = new DepthFirstPaths(G, s);

        for (int v = 0; v < G.V(); v++) {
            if (dfs.hasPathTo(v)) {
                StdOut.printf("%d to %d:  ", s, v);
                for (int x : dfs.pathTo(v)) {
                    if (x == s) {
                        StdOut.print(x);
                    } else {
                        StdOut.print("-" + x);
                    }
                }
                StdOut.println();
            }

            else {
                StdOut.printf("%d to %d:  not connected\n", s, v);
            }

        }
    }

	
	

}
