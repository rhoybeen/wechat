package bupt.wspn.bean;

public class Player {
	private int id;
	private String name;
	private int point;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "\nPlayer "+this.getName()+" id:"+this.getId()+" point:"+Integer.toString(this.getPoint());
	}
	
}
