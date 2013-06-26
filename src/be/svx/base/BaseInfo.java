package be.svx.base;

public abstract class BaseInfo {
	private String name;
	private String description;
	
	public BaseInfo(String name){
		this(name, "");
	}
	
	public BaseInfo(String name, String description) {
		super();
		this.name = name;
		this.description = description;
	}
	public String getName() {
		return name;
	}
	public String getDescription() {
		return description;
	}
	
	
}
