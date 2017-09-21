package bupt.wspn.bean;

public class Record {

	private int mem_id;
	private String week_id;
	private String match_id;
	private boolean match_status = false;
	private int points = 0;

	public int getMem_id() {
		return mem_id;
	}
	public void setMem_id(int mem_id) {
		this.mem_id = mem_id;
	}
	public String getWeek_id() {
		return week_id;
	}
	public void setWeek_id(String week_id) {
		this.week_id = week_id;
	}
	public String getMatch_id() {
		return match_id;
	}
	public void setMatch_id(String match_id) {
		this.match_id = match_id;
	}
	public boolean isMatch_status() {
		return match_status;
	}
	public void setMatch_status(boolean match_status) {
		this.match_status = match_status;
	}
	public int getPoints() {
		return points;
	}
	public void setPoints(int points) {
		this.points = points;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "PlayerID:" + Integer.toString(mem_id)+"  MatchID:"+match_id+"  Result:" + match_status +"  Points:" + Integer.toString(points);
	}
}
