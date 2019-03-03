package assignment;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


import sheffield.EasyReader;
/* Data.java  
 *  
 *  use the https request to get data from the net
 *
 */
public class Data {
	public List<String> getData(String urlString) throws Exception {
	
		String input;
		List<String> data = new ArrayList<String>();
		String [] iLineData;

		//print the url to ensure whether the data is true
		System.out.println("Reading data from " + urlString );

		URL u = new URL(urlString);
		URLConnection connection = u.openConnection();
		
		//the state number
		HttpURLConnection httpURLConnection = (HttpURLConnection) connection;
		int code = httpURLConnection.getResponseCode();
		String message = httpURLConnection.getResponseMessage();
		System.out.println(code + " " + message);
		
		InputStream instream = connection.getInputStream();
		Scanner in = new Scanner(instream);
		
		//use loop save the data to the list
		while(in.hasNextLine()) {
			input = in.nextLine();
			data.add(input);	
		}
		return data;
	}
}
