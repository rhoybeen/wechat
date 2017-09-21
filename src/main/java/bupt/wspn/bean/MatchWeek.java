package bupt.wspn.bean;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

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
	
	public static String getCurrentWeekId(){
		SimpleDateFormat formater=new SimpleDateFormat("yyyyMMdd");
		Calendar calendar = Calendar.getInstance();
		calendar.setFirstDayOfWeek(Calendar.MONDAY);
		calendar.set(Calendar.DAY_OF_WEEK,calendar.getFirstDayOfWeek());
		Date date = new Date(calendar.getTime().getTime());
		return formater.format(date);
	}
	
}
