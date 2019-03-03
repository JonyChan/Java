package assignment;


import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

/* DrawMultiGraph2JavaFX.java  
 *  
 * this is a function which use JavaFX library to draw the graph to show
 *
 *  
 *
 */
public class DrawMultiGraphJavaFX{

	
	static List<String> a = new ArrayList<String>();
	static List<Double> b = new ArrayList<Double>();
	static List<Double> c = new ArrayList<Double>();

	public DrawMultiGraphJavaFX(List<String> a, List<Double> b, List<Double> c) {
		this.a = a;
		this.b = b;
		this.c = c;	
	}
  public static void initFX(JFXPanel p,List<String> a, List<Double> b, List<Double> c){
	final CategoryAxis xAxis = new CategoryAxis();
    final NumberAxis yAxis = new NumberAxis();
    xAxis.setLabel("Date");
    final LineChart<String, Number> lineChart = new LineChart<String, Number>(xAxis, yAxis); 

    lineChart.setTitle("Line Chart");
    XYChart.Series<String, Number> aseries = new XYChart.Series<String, Number>();
    XYChart.Series<String, Number> bseries = new XYChart.Series<String, Number>();
    aseries.setName("highData");
    bseries.setName("lowData");
    // populating the series with data
    for(int i = 0;i<a.size();i++) {
    	aseries.getData().add(new XYChart.Data<String, Number>(a.get(i),b.get(i)));
    	bseries.getData().add(new XYChart.Data<String, Number>(a.get(i),c.get(i)));	
    }
    Scene scene = new Scene(lineChart, 800, 600);
    lineChart.getData().addAll(aseries,bseries);

    p.setScene(scene);
 
  }
  
  private static void initAndShowGUI(List<String> a, List<Double> b, List<Double> c) {
      // This method is invoked on Swing thread
      JFrame frame = new JFrame("FX");
      frame.setSize(400, 400);
      Toolkit tk = Toolkit.getDefaultToolkit();
      Dimension dim = tk.getScreenSize();
//      frame.setSize(dim.width/4, dim.height/4);
      frame.setLocation(new Point(dim.width/2, dim.height*3/4));
		
      final JFXPanel fxPanel = new JFXPanel();
      frame.add(fxPanel);
      frame.setVisible(true);

      Platform.runLater(new Runnable() {
          @Override
          public void run() {
              initFX(fxPanel,a,b,c);
          }
      });
  }
 
  public static void main(String [] args) {
	  SwingUtilities.invokeLater(new Runnable() {
          @Override
          public void run() {
              initAndShowGUI(a,b,c);
          }
      });	
  }
}