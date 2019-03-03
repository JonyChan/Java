package assignment;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.*;
/* ComponentFrame.java  
 *  
 *  creates some panels with text rendering and so on 
 *
 *  this is a most important class, this class contains all stages of this project
 *  first one is the frame, the listener of the frame，the listener is most important,
 *  it includes process data and show data
 *
 */
class ComponentFrame extends JFrame implements ActionListener {

	private JButton button,button1,button2,button3;
	private JLabel label1, label2, label3, label4, label5, label6, label7;
	private JComboBox box1,box2,box3,box4,box5,box6,box7;
	String urlString,ticker,startYear,endYear,startMonth,startDay,endMonth,endDay;
	Data data = new Data();
	List<String> allData = new ArrayList<String>();
	List<String> date = new ArrayList<String>();
	List<Double> openData = new ArrayList<Double>();
	List<Double> highData = new ArrayList<Double>();
	List<Double> lowData = new ArrayList<Double>();
	List<Double> closeData = new ArrayList<Double>();
	List<Double> volumnData = new ArrayList<Double>();
	String [] iLineData= null;	
	//construct the constructor
	public ComponentFrame() {
		// TODO Auto-generated constructor stub
		
		//set some basic properties
		setTitle("Select page");
		setSize(350, 200);
		setLayout(new GridLayout(5, 1));
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension dim = tk.getScreenSize();
		setSize(dim.width/4, dim.height/4);
		setLocation(new Point(dim.width/4, dim.height/4));
		
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				dispose();
				System.exit(0);
			}
		} ); 
		//construct one container object, then add others on it
		Container contentPane = getContentPane();
		
		//the first drop down box to select the ticker symbol
		JPanel p = new JPanel();
		label1 = new JLabel("Ticker Symbol:");
		String s1[] = {"enter value","AAPL","BABA","BIDU"};
		box1 = addJComboBox(p, s1, this);
		p.add(label1);
		p.add(box1);
		contentPane.add(p);
		
		//the next six drop down box to select the date	
		p = new JPanel(new GridLayout(1, 4));
		label2 = new JLabel("Year From:");
		String s2[] = {"enter value","2016","2017","2018","2019"};
		box2 = addJComboBox(p, s2, this);
		p.add(label2);
		p.add(box2);
		label3 = new JLabel("Year To:");
		String s3[] = {"enter value","2016","2017","2018","2019"};
		box3 = addJComboBox(p, s3, this);
		p.add(label3);
		p.add(box3);
		contentPane.add(p);
		
		p = new JPanel(new GridLayout(1, 4));
		label4 = new JLabel("Month From:");
		String s4[] = {"enter value","1","2","3","4","5","6","7","8","9","10","11","12"};
		box4 = addJComboBox(p,s4,this);
		p.add(label4);
		p.add(box4);
		label5 = new JLabel("Day From:");
		String s5[] = {"enter value","1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
		box5 = addJComboBox(p,s5,this);
		p.add(label5);
		p.add(box5);
		contentPane.add(p);
		
		p = new JPanel(new GridLayout(1, 4));
		label6 = new JLabel("Month To:");
		String s6[] = {"enter value","1","2","3","4","5","6","7","8","9","10","11","12"};
		box6 = addJComboBox(p,s6,this);
		p.add(label6);
		p.add(box6);
		label7 = new JLabel("Day To:");
		String s7[] = {"enter value","1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
		box7 = addJComboBox(p,s7,this);
		p.add(label7);
		p.add(box7);
		contentPane.add(p);
		
		//make some button
		p = new JPanel(new GridLayout(1, 4));
		button = addButton(p,"Retrive O&C",this);
		button1 = addButton(p,"Retrive H&L",this);
		button2 = addButton(p,"Retrive V",this);
		button3 = addButton(p,"Exit",this);
		p.add(button);
		p.add(button1);
		p.add(button2);
		p.add(button3);
		contentPane.add(p);
	}
	
	//make the function to add the action listener and name of the drop down box 
	//when add it
	private JComboBox addJComboBox(JPanel p, String s[], ActionListener a) {
		JComboBox jcb = new JComboBox(s);
		jcb.addActionListener(a);
		p.add(jcb);
		return jcb;
	}
	
	//make the function to add the action listener and name of the button 
	//when add it
	private JButton addButton(JPanel p, String s, ActionListener a) {
		JButton b = new JButton(s);
		b.addActionListener(a);
		p.add(b);
		return b;
	}
	
	//the action event
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object source = e.getSource();
		//get data from the input
		if(source == box1) {
			ticker = (String)box1.getSelectedItem();
		} else if(source == box2) {
			startYear = (String)box2.getSelectedItem();
		} else if(source == box3) {
			endYear = (String)box3.getSelectedItem();
		} else if(source == box4) {
			startMonth = (String)box4.getSelectedItem();
		} else if(source == box5) {
			startDay = (String)box5.getSelectedItem();
		} else if(source == box6) {
			endMonth = (String)box6.getSelectedItem();
		} else if(source == box7) {
			endDay = (String)box7.getSelectedItem();
		} else if(source == button) {
			urlString = "https://quotes.wsj.com/" + ticker + "/historical-prices/download?MOD_VIEW=page&num_rows=300&startDate=" + startMonth + "/" + startDay + "/" + startYear + "&endDate=" + endMonth + "/" + endDay + "/" + endYear;
			try {
				allData = data.getData(urlString);
				//remove the first line which is the introduction
				allData.remove(0);
				
				//loop to change the string type to double
				for(String i:allData) {	
					iLineData = i.split(",");
					date.add(iLineData[0]);
					openData.add(Double.valueOf(iLineData[1]));
					highData.add(Double.valueOf(iLineData[2]));
					lowData.add(Double.valueOf(iLineData[3]));
					closeData.add(Double.valueOf(iLineData[4]));
					volumnData.add(Double.valueOf(iLineData[5]));
				}
				//call other function and class to draw
				DrawMultiGraph2JavaFX dmoc = new DrawMultiGraph2JavaFX(date, openData,closeData);
				dmoc.main(iLineData);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} else if(source == button1) {
			DrawMultiGraphJavaFX dm = new DrawMultiGraphJavaFX(date,highData, lowData);
			dm.main(iLineData);
		} else if(source == button2) {
			DrawGraphJavaFX dm = new DrawGraphJavaFX(date,volumnData);
			dm.main(iLineData);
		}else if(source == button3) {
			System.exit(0);
		}	
	}
}
