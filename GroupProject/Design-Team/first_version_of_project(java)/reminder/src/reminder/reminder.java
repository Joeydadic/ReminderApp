package reminder;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.JPanel;
import javax.swing.JTextArea;

public class reminder {

	public static window a;
	public static List<String> input_txt = new ArrayList<>();
	public static List<customer> customer_List = new ArrayList<>();
	public static JTextArea customer_result = new JTextArea();

	public static void createWindow() {
		
		a = new window();
		
		a.initWindow();

		JPanel test = new JPanel();

		test.setLocation(100,30);
		a.add(test);
		
		test.add(customer_result);
	}
	
	public static List<String> readInFile(String filename){
	     
		List<String> input = new ArrayList<>();
	    try (Scanner sin = new Scanner(new FileReader(filename))){
	       while (sin.hasNextLine()){
	    	   input.add(sin.nextLine());
	       }
	    } catch (FileNotFoundException e){
	    	e.printStackTrace();
	    }
	    return input;
	}
	
	public static void GetInput() {
		
		input_txt = readInFile("reminder.txt");
		
	}
	
	public static void main(String[] args) {
		
		createWindow();
		GetInput();
		Sort_information(input_txt);
		Show_customerList();
		
	}
	
	private static void Show_customerList() {

		for(customer a:customer_List) {
			customer_result.append("\n\r"+a.id);
			customer_result.append("\n\r"+a.people);
			if(a.people==1) customer_result.append("\n\r"+a.name);
			customer_result.append("\n\r"+a.place);
			customer_result.append("\n\r"+a.event);
			customer_result.append("\n\r");
		}
		
	}

	private static void Sort_information(List<String> nmList) {
		int i,id,people;
		String event;
		String [] strArray;
		List<String> names =  new ArrayList<>();
		for(String str:nmList) {
	   		event="";
			strArray = str.split(" ");
		   	id = Integer.parseInt(strArray[0]);
		   	people = Integer.parseInt(strArray[1]);
		   	if(people>1) {
		   		for(i=6+people-1;i<strArray.length;i++) event += strArray[i]+' ';
		   		for(i=2;i<1+people;i++) {
		   			names.add(strArray[i]);
		   		}
				customer ab = new customer(id,people,names,strArray[2+people],strArray[3+people],event);
				customer_List.add(ab);
		   	}
		   	else {
		   		for(i=6;i<strArray.length;i++) event += strArray[i]+' ';
				customer ab = new customer(id,people,strArray[2],strArray[3],strArray[4],event);
				customer_List.add(ab);
		   	}
	   }
	}
}
