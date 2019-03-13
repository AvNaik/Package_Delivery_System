package application;

import java.util.*;

public class shortestPath {

	private final List<VertexNodes> nodes;
	private final List<Edge> edges;
	private Set<VertexNodes> setNodes;
	private Set<VertexNodes> unSetNodes;
	private Map<VertexNodes, VertexNodes> Neighbors;
	private Map<VertexNodes, Integer> cost;


	public shortestPath (shortestPathGraph g) {
		this.nodes = new ArrayList<VertexNodes>(g.getVertice());
		this.edges = new ArrayList<Edge>(g.getEdges());
	}

	public void execute(VertexNodes source) {
		setNodes = new HashSet<VertexNodes>();
		unSetNodes = new HashSet<VertexNodes>();
		cost = new HashMap<VertexNodes, Integer>();
		Neighbors = new HashMap<VertexNodes, VertexNodes>();
		cost.put(source, 0);
		unSetNodes.add(source);
		while (unSetNodes.size() > 0) {
			VertexNodes node = getMinimum(unSetNodes);
			setNodes.add(node);
			unSetNodes.remove(node);
			findMinimalDistances(node);
		}
	}
	private void findMinimalDistances(VertexNodes node) {
		List<VertexNodes> adjacentNodes = getNeighbors(node);
		for (VertexNodes target : adjacentNodes) {
			if (getShortestDistance(target) > getShortestDistance(node)
					+ getDistance(node, target)) {
				cost.put(target, getShortestDistance(node)
						+ getDistance(node, target));
				Neighbors.put(target, node);
				unSetNodes.add(target);
			}
		}
	}
	public int getDistance(VertexNodes node, VertexNodes target) {
		for (Edge edge : edges) {
			if (edge.getSource().equals(node) && edge.getDestination().equals(target)) {
				return edge.getpacketWeight();
			}
		}
		throw new RuntimeException("Should not happen");
	}
	private List<VertexNodes> getNeighbors(VertexNodes node) 
	{
		List<VertexNodes> neighbors = new ArrayList<VertexNodes>();
		for (Edge edge : edges) {
			if (edge.getSource().equals(node) && !isSettled(edge.getDestination())) {
				neighbors.add(edge.getDestination());
			}
		}
		return neighbors;
	}
	public VertexNodes getMinimum(Set<VertexNodes> Vertice) {
		VertexNodes minimum = null;
		for (VertexNodes VertexNodes : Vertice) {
			if (minimum == null) 
			{
				minimum = VertexNodes;
			} else 
			{
				if (getShortestDistance(VertexNodes) < getShortestDistance(minimum))
				{
					minimum = VertexNodes;
				}
			}
		}
		return minimum;
	}
	private boolean isSettled(VertexNodes VertexNodes) {
		return setNodes.contains(VertexNodes);
	}
	public int getShortestDistance(VertexNodes destination) {
		Integer d = cost.get(destination);
		if (d == null) {
			return Integer.MAX_VALUE;
		} else {
			return d;
		}
	}
	public LinkedList<VertexNodes> getPath(VertexNodes target) {
		LinkedList<VertexNodes> path = new LinkedList<>();
		VertexNodes step = target;
	//	VertexNodes nostep = (VertexNodes) Neighbors;
		// check if a path exists
		if (Neighbors.get(step) == null) {
			return null;
		}
		path.add(step);
		while (Neighbors.get(step) != null) {
			step = Neighbors.get(step);
			path.add(step);
		}
		Collections.reverse(path);
		return path;
	}
}
