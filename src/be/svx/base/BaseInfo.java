package be.svx.base;

public abstract class BaseInfo {
	
	private static int nextID = 1;
	
	private static int getNextID(){
		return nextID++;
	}
	
	private String name;
	private String description;
	private int id;
	
	public BaseInfo(String name){
		this(name, "");
	}
	
	public BaseInfo(String name, String description) {
		super();
		this.id = getNextID();
		this.name = name;
		this.description = description;
	}
	public String getName() {
		return name;
	}
	public String getDescription() {
		return description;
	}
	
	public int getId(){
		return id;
	}
	
	@Override
	public String toString(){
		return "State-" + id + ": " + name; 
	}
	
	
}
