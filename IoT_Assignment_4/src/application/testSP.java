package application;

import java.util.*;

public class testSP {
	
	private List<VertexNodes> nodes;
	private List<Edge> edges;
	
	public LinkedList <VertexNodes> Testing (int source, int Destination)
	{
		nodes = new ArrayList<VertexNodes>();
		edges = new ArrayList<Edge>();
		for (int i = 0; i < 60; i++) {
			VertexNodes location = new VertexNodes( i+"", "" + i);
			nodes.add(location);
		}
		addLane("Edge_0", 0, 1, 1);
		addLane("Edge_1", 1, 2, 1);
		addLane("Edge_2", 2, 3, 1);
		addLane("Edge_3", 3, 4, 1);
		addLane("Edge_4", 4, 5, 1);
		addLane("Edge_5", 5, 6, 1);
		addLane("Edge_6", 6, 7, 1);
		addLane("Edge_7", 7, 8, 1);
		addLane("Edge_8", 8, 9, 1);
		addLane("Edge_9", 9, 10, 1);
		addLane("Edge_10", 10, 11, 1);
		addLane("Edge_11", 11, 12, 1);
		addLane("Edge_12", 12, 13, 1);
		addLane("Edge_13", 13, 14, 1);
		addLane("Edge_14", 14, 15, 1);
		addLane("Edge_15", 15, 16, 1);
		addLane("Edge_16", 16, 17, 1);
		addLane("Edge_17", 17, 18, 1);
		addLane("Edge_18", 18, 19, 1);
		addLane("Edge_19", 19, 20, 1);
		addLane("Edge_20", 20, 21, 1);
		addLane("Edge_21", 21, 22, 1);
		addLane("Edge_22", 22, 23, 1);
		addLane("Edge_23", 23, 24, 1);	
		addLane("Edge_24", 24, 25, 1);
		addLane("Edge_25", 25, 26, 1);
		addLane("Edge_26", 26, 27, 1);
		addLane("Edge_27", 27, 28, 1);
		addLane("Edge_28", 28, 29, 1);
		addLane("Edge_29", 29, 30, 1);
		addLane("Edge_30", 1, 0, 1);
		addLane("Edge_31", 2, 1, 1);
		addLane("Edge_32", 3, 2, 1);
		addLane("Edge_33", 4, 3, 1);
		addLane("Edge_34", 5, 4, 1);
		addLane("Edge_35", 6, 5, 1);
		addLane("Edge_36", 7, 6, 1);
		addLane("Edge_37", 8, 7, 1);
		addLane("Edge_38", 9, 8, 1);
		addLane("Edge_39", 10, 9, 1);
		addLane("Edge_40", 11, 10, 1);
		addLane("Edge_41", 12, 11, 1);
		addLane("Edge_42", 13, 12, 1);
		addLane("Edge_43", 14, 13, 1);
		addLane("Edge_44", 15, 14, 1);
		addLane("Edge_45", 16, 15, 1);
		addLane("Edge_46", 17, 16, 1);
		addLane("Edge_47", 18, 17, 1);
		addLane("Edge_48", 19, 18, 1);
		addLane("Edge_49", 20, 19, 1);
		addLane("Edge_50", 21, 20, 1);
		addLane("Edge_51", 22, 21, 1);
		addLane("Edge_52", 23, 22, 1);
		addLane("Edge_53", 24, 23, 1);
		addLane("Edge_54", 25, 24, 1);
		addLane("Edge_55", 26, 25, 1);
		addLane("Edge_56", 27, 26, 1);
		addLane("Edge_57", 28, 27, 1);
		addLane("Edge_58", 29, 28, 1);
		addLane("Edge_59", 30, 29, 1);
		
		shortestPathGraph gr = new shortestPathGraph(nodes, edges);
		shortestPath dijkstra = new shortestPath(gr);
		dijkstra.execute(nodes.get(source));
		LinkedList<VertexNodes> path = dijkstra.getPath(nodes.get(Destination));
		return path;
	}
	private void addLane(String laneId, int sourceLocNo, int destLocNo, int duration) 
	{
		Edge lane = new Edge(laneId, nodes.get(sourceLocNo), nodes.get(destLocNo), duration );
		edges.add(lane);
	}
}
