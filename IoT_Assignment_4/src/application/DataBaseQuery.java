package application;

import java.sql.*;
import java.util.*;
import java.text.*;
import javafx.collections.FXCollections;

public class DataBaseQuery implements Runnable{

	Thread t;
	testSP ta=new testSP();
	LinkedList<VertexNodes> list=new LinkedList<>();
	int temp;
	Statement statement=null;
	PreparedStatement preparedStatement=null;
	DataBaseConnection dc=new DataBaseConnection();
	ResultSet resultSet=null;
	Scanner sc=new Scanner(System.in);
	int id,source,dest;
	setupForTracking sFT;
	static MainGUIControl controls;
	ArrayList<setupForTracking> dlist;
	
	public DataBaseQuery(int source,int dest,setupForTracking sFT) {
		temp=1;
		this.source=source;
		this.dest=dest;
		this.sFT= sFT;
		start();
	}
	
	public DataBaseQuery(int id,MainGUIControl controls) {
		temp=2;
		this.id=id;
		DataBaseQuery.controls = controls;
		dlist=new ArrayList<>();
		start();
	}
	
	public void run() {
		if(temp==1)
		{
			try
			{
				String insert="insert into package values (?,?,?,?,?,?,?,?,?);";
				preparedStatement = (PreparedStatement) dc.getConnected().prepareStatement(insert);
				preparedStatement.setInt(1, sFT.getId());
				preparedStatement.setString(2, sFT.getSource());
				preparedStatement.setString(3, sFT.getDestination());
				preparedStatement.setString(4, sFT.getcurrentDate());
				preparedStatement.setString(5, sFT.getcurrentTime());
				preparedStatement.setString(6, sFT.getLocation());
				preparedStatement.setString(7, sFT.getWeight());
				preparedStatement.setString(8, sFT.getnumberOfPeices());
				preparedStatement.setString(9, sFT.getActivity());
				preparedStatement.executeUpdate();
				preparedStatement=null; 
				dc.closeConnection();
				list=ta.Testing(source, dest);

				for(VertexNodes v: list)
				{
					//System.out.println(v);
					Thread.sleep(3000);
					insert(v);
				}			
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		else if(temp==2)
		{
			try
			{
				dc.getConnected();
				String search="Select * from package where "+setupForTracking.Tracking_Number+"= ?";
				preparedStatement=(PreparedStatement) dc.getConnected().prepareStatement(search);
				preparedStatement.setInt(1,id);
				resultSet=preparedStatement.executeQuery();
				
				while(resultSet.next())
				{
					sFT=new setupForTracking();
					sFT.setId(resultSet.getInt(1));
					sFT.setSource(resultSet.getString(2));
					sFT.setDestination(resultSet.getString(3));
					sFT.setDate(resultSet.getString(4));
					sFT.setTime(resultSet.getString(5));
					sFT.setLocation(resultSet.getString(6));
					sFT.setWeight(resultSet.getString(7));
					sFT.setnumberOfPeices(resultSet.getString(8));
					sFT.setActivity(resultSet.getString(9));
					
					dlist.add(sFT);
				}
				setUI();
			} 
			catch (Exception e)
			{
				e.printStackTrace();
			}
			dc.closeConnection();
		}
	}

	public void start () {
//		System.out.println("Starting thread " );
		if (t == null) {
			t = new Thread (this);
			t.start ();
		}
	}

	public void insert(VertexNodes v) 
	{
		try {
			String insert="insert into package values (?,?,?,?,?,?,?,?,?);";
			preparedStatement=(PreparedStatement) dc.getConnected().prepareStatement(insert);
			preparedStatement.setInt(1, sFT.getId());
			preparedStatement.setString(2, sFT.getSource());
			preparedStatement.setString(3, sFT.getDestination());
			preparedStatement.setString(4, sFT.getcurrentDate());
			preparedStatement.setString(5, sFT.getcurrentTime());
			preparedStatement.setString(6, setupForTracking.getCityList().get(Integer.parseInt(v+"")));
			preparedStatement.setString(7, sFT.getWeight());
			preparedStatement.setString(8, sFT.getnumberOfPeices());
			if(dest==Integer.parseInt(v+""))
			{
				preparedStatement.setString(9, "Delivered");
			}
			else
			{
				preparedStatement.setString(9, "Shipped");
			}
			preparedStatement.executeUpdate();
			preparedStatement=null;
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		dc.closeConnection();
	}
	@SuppressWarnings("unchecked")
	public void setUI()
	{
		controls.table.setItems(FXCollections.observableArrayList(dlist));
		controls.dateText.setText(dlist.get(0).getcurrentDate());
		controls.track_Num.setText(dlist.get(0).getId()+"");
		controls.wt.setText(dlist.get(0).getWeight());
		controls.pieceText.setText(dlist.get(0).getnumberOfPeices());
		if(dlist.get(dlist.size()-1).getActivity().equals("Delivered"))
		{
			controls.act_delText.setText(dlist.get(dlist.size()-1).getDate()+ " "+dlist.get(dlist.size()-1).getTime());
		}
	}
}