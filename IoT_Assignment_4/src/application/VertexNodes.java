package application;

public class VertexNodes {
	public String Identification = "";
	public String nodeName = "";
	
	public VertexNodes (String Identification, String nodeName)
	{
		this.Identification = Identification;
		this.nodeName = nodeName;		
	}
	public String getIdentification() 
	{
		return Identification;
	}
	public String getNodeName() 
	{
		return nodeName;
	}
	
	public String toString() {
		return nodeName;
	}
	public int hashCode() 
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Identification == null) ? 0 : Identification.hashCode());
		return result;
	}
	public boolean equals(Object o) {
		if (this == o)
			return true;
		else if (o == null)
		{
			return false;
		}
		if (getClass() != o.getClass())
			return false;
		VertexNodes other = (VertexNodes) o;
		if (Identification == null) {
			if (other.Identification != null)
				return false;
		} else if (!Identification.equals(other.Identification)) {
			return false;
		}
		return true;
	}
}