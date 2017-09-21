package bupt.wspn.bean;


public class MatchLog {
	private String week_id;
	private String match_id;
	private String player_list=null;
	private String winner_list=null;
	private int winner_points=0;
	private int loser_points=0;
	private int mvp=0;
	private int best_dps=0;
	private int best_tank=0;
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

	public String getPlayer_list() {
		return player_list;
	}
	public void setPlayer_list(String player_list) {
		this.player_list = player_list;
	}
	public String getWinner_list() {
		return winner_list;
	}
	public void setWinner_list(String winner_list) {
		this.winner_list = winner_list;
	}
	public int getWinner_points() {
		return winner_points;
	}
	public void setWinner_points(int winner_points) {
		this.winner_points = winner_points;
	}
	public int getLoser_points() {
		return loser_points;
	}
	public void setLoser_points(int loser_points) {
		this.loser_points = loser_points;
	}
	public int getMvp() {
		return mvp;
	}
	public void setMvp(int mvp) {
		this.mvp = mvp;
	}
	public int getBest_dps() {
		return best_dps;
	}
	public void setBest_dps(int best_dps) {
		this.best_dps = best_dps;
	}
	public int getBest_tank() {
		return best_tank;
	}
	public void setBest_tank(int best_tank) {
		this.best_tank = best_tank;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "matchID:"+match_id+"   playerList:"+player_list;
	}
}
