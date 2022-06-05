package reminder;

import java.util.List;

public class customer {

	public int id;
	public int people; 
	public List<String> names; 
	public String name; 
	public String time; 
	public String place; 
	public String event; 
	
	public customer(int id, int people,List<String> names,String time,String place,String event) {
        super();
        this.id = id;
        this.people = people;
        this.names = names;
        this.time = time;
        this.place = place;
        this.event = event;
    }

	public customer(int id, int people, String name,String time,String place,String event) {
		this.id = id;
		this.people = people;
		this.name = name;
        this.time = time;
        this.place = place;
        this.event = event;
	}
	
}
