package application;

import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.Label;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Tab;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;

public class MainGUIControl implements Initializable{
	
	@FXML
	public Tab track;
	@FXML
	public TextField track_Id;
	@FXML
	public TextField dateText;
	@FXML
	public TextField act_delText;
	@FXML
	public TableView table;
	@FXML
	private TableColumn date;
	@FXML
	private TableColumn time;
	@FXML
	private TableColumn activity;
	@FXML
	private TableColumn location;
	@FXML
	public TextField track_Num;
	@FXML
	public TextField wt;
	@FXML
	public TextField pieceText;
	@FXML
	private Tab shipping;
	@FXML
	private ComboBox fromCombo;
	@FXML
	private ComboBox toCombo;
	@FXML
	private TextField weight;
	@FXML
	private TextField pieces;
	@FXML
	private Label track_no;
	DataBaseQuery dq;
	ArrayList<String> list;
	static int t_id=86421357;
	setupForTracking sFT;
	setupForTracking c;

	public void initialize(URL location, ResourceBundle resources) {
		setInitial();
		setColumn();
	}
	@SuppressWarnings("unchecked")
	public void setInitial()
	{	
		fromCombo.setItems(FXCollections.observableArrayList(setupForTracking.getCityList()));
		toCombo.setItems(FXCollections.observableArrayList(setupForTracking.getCityList()));
	}	
	@FXML
	public void shipping(Event event)
	{
		weight.clear();
		pieces.clear();
		track_no.setText("");
		fromCombo.getSelectionModel().clearSelection();
		toCombo.getSelectionModel().clearSelection();
		
	}
	@FXML
	public void tracking(Event event)
	{
		table.getItems().clear();
		dateText.setText("");
		act_delText.setText("");
		wt.setText("");
		track_Num.setText("");
		pieceText.setText("");
		track_Id.clear();
	}	
	@FXML
	public void shipButton(Event event)
	{
		sFT=new setupForTracking();
		c=new setupForTracking();
		sFT.setId(t_id);
		track_no.setText(t_id+"");
		sFT.setSource(setupForTracking.getCityList().get(fromCombo.getSelectionModel().getSelectedIndex()));
		sFT.setDestination(setupForTracking.getCityList().get(toCombo.getSelectionModel().getSelectedIndex()));
		sFT.setWeight(weight.getText());
		sFT.setnumberOfPeices(pieces.getText());
		sFT.setLocation(setupForTracking.getCityList().get(fromCombo.getSelectionModel().getSelectedIndex()));
		sFT.setDate(c.getcurrentDate());
		sFT.setTime(c.getcurrentTime());
		sFT.setActivity("Ready for Pickup");
		t_id++;
		dq=new DataBaseQuery(fromCombo.getSelectionModel().getSelectedIndex(),toCombo.getSelectionModel().getSelectedIndex(), sFT);
	}	
	@FXML
	public void trackButton(Event event)
	{
		dq=new DataBaseQuery(Integer.parseInt(track_Id.getText()), MainGUIControl.this);
	}
	@SuppressWarnings("unchecked")
	public void setColumn()
	{
		date.setCellValueFactory(new PropertyValueFactory<>("date"));
		time.setCellValueFactory(new PropertyValueFactory<>("time"));
		activity.setCellValueFactory(new PropertyValueFactory<>("activity"));
		location.setCellValueFactory(new PropertyValueFactory<>("location"));
	}
}