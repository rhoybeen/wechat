package bupt.wspn.bean;

import java.sql.Date;

public class Match {
	private static enum GAME_RESULT{
		win,fail,un
	}
	
	private String week_id;
	private String match_id;
	private int mem_id;
	private int team;
	private GAME_RESULT result;
	private int point;
	
	
	public GAME_RESULT getResult() {
		return result;
	}
	public void setResult(GAME_RESULT result) {
		this.result = result;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
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

	public int getMem_id() {
		return mem_id;
	}
	public void setMem_id(int mem_id) {
		this.mem_id = mem_id;
	}
	public int getTeam() {
		return team;
	}
	public void setTeam(int team) {
		this.team = team;
	}
	
	
}
