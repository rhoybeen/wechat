package bupt.wspn.bean;

import java.util.ArrayList;

public class MatchWeek {
	private String week_id;
	private String player_pool;
	public String getWeek_id() {
		return week_id;
	}
	public void setWeek_id(String week_id) {
		this.week_id = week_id;
	}
	public String getPlayer_pool() {
		return player_pool;
	}
	public void setPlayer_pool(String player_pool) {
		this.player_pool = player_pool;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "WEEK:"+week_id+"  PLAYERS:"+player_pool;
	}
	
}
