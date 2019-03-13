package application;

public class Edge {
	
		public final String id;
		public final VertexNodes packetSource;
		public final VertexNodes packetDestination;
		public final int packetWeight;

		public Edge(String id, VertexNodes packetSource, VertexNodes packetDestination, int packetWeight) {
			this.id = id;
			this.packetSource = packetSource;
			this.packetDestination = packetDestination;
			this.packetWeight = packetWeight;
		}
		public String getId() {
			return id;
		}
		public VertexNodes getSource() {
			return packetSource;
		}
		public VertexNodes getDestination() {
			return packetDestination;
		}
		public int getpacketWeight() {
			return packetWeight;
		}
		public String toString() {
			return packetSource + " " + packetDestination;
		}
	}
