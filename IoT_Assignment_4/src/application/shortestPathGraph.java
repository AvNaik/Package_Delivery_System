package application;

import java.util.*;

public class shortestPathGraph {
	private final List <VertexNodes> Vertice;
	private final List <Edge> edges;

	public shortestPathGraph (List<VertexNodes> Vertice, List<Edge> edges) {
		this.Vertice = Vertice;
		this.edges = edges;
	}
	public List<VertexNodes> getVertice() {
		return Vertice;
	}
	public List<Edge> getEdges() {
		return edges;
	}
}