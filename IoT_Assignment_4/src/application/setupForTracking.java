package application;

import java.util.*;
import java.text.*;

public class setupForTracking {
	
	public static String Packet_Origin = "Source";
	public static String Packet_Target = "Destination";
	public static String Tracking_Number = "Id";
	public static String Current_Location = "Location";
	public static String Packet_Weight = "Weight";
	public static String numberofPacketPeices = "Peices";
	public static String Current_Time = "Time";
	public static String Current_Date = "Date";
	String[] currdate;
	
	String Source = "";
	public String getSource() {
		return Source;
	}
	public void setSource(String Source) {
		this.Source = Source;
	}
	String Destination = "";
	public String getDestination() {
		return Destination;
	}
	public void setDestination(String Destination) {
		this.Destination = Destination;
	}
	int Id = 0;
	public int getId() {
		return Id;
	}
	public void setId(int Id) {
		this.Id = Id;
	}
	String Activity = "";
	public String getActivity() {
		return Activity;
	}
	public void setActivity(String Activity) {
		this.Activity = Activity;
	}
	String Weight = "";
	public String getWeight() {
		return Weight;
	}
	public void setWeight(String Weight) {
		this.Weight = Weight;
	}
	String numberOfPeices = "";
	public String getnumberOfPeices() {
		return numberOfPeices;
	}
	public void setnumberOfPeices(String numberOfPeices) {
		this.numberOfPeices = numberOfPeices;
	}
	String Location = "";
	public String getLocation() {
		return Location;
	}
	public void setLocation(String Location) {
		this.Location = Location; 
	}
	String Date = "";
	public String getDate() {
		return Date;
	}
	public void setDate(String Date) {
		this.Date = Date; 
	}
	String Time = "";
	public String getTime() {
		return Time;
	}
	public void setTime(String Time) {
		this.Time = Time; 
	}
	public String getcurrentDate()
	{
		String pattern = "yyyy-MM-dd";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

		String date = simpleDateFormat.format(new Date());
		return date;
	}
	public String getcurrentTime()
	{
		DateFormat df = new SimpleDateFormat ("yyyy/MM/dd HH:mm:ss");
		Date today = new Date();
		String[] dt = df.format(today).split(" ");
		return dt[1];
	}

	static ArrayList <String> CityList = new ArrayList <>();
	public static ArrayList<String> getCityList()
	{
		CityList.add("Northborough, MA");
		CityList.add("Edison, NJ");
		CityList.add("Pittsburgh, PA");
		CityList.add("Allentown, PABD Strap Endlinksth");
		CityList.add("Martinsburg, WV");
		CityList.add("Charlotte, NC");
		CityList.add("Atlanta, GA");
		CityList.add("Orlando, FL");
		CityList.add("Memphis, TN");
		CityList.add("Grove City, OH");
		CityList.add("Indianapolis, IN");
		CityList.add("Detroit, MI");
		CityList.add("New Berlin, WI");
		CityList.add("Minneapolis, MN");
		CityList.add("St. Louis, MO");
		CityList.add("Kansas, KS");
		CityList.add("Dallas, TX");
		CityList.add("Houston, TX");
		CityList.add("Denver, CO");
		CityList.add("Salt Lake City, UT");
		CityList.add("Pittsburgh, PA");
		CityList.add("Phoenix, AZ");
		CityList.add("Los Angeles, CA");
		CityList.add("Chino, CA");
		CityList.add("Sacramento, CA");
		CityList.add("Seattle, WA");	
		return CityList;
	}
}
