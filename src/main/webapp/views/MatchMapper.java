package bupt.wspn.mapper;

import java.sql.Date;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.codehaus.jackson.annotate.JsonTypeInfo.Id;

import bupt.wspn.bean.Match;
import bupt.wspn.bean.MatchLog;
import bupt.wspn.bean.MatchWeek;
import bupt.wspn.bean.Record;

public interface MatchMapper {
	boolean signInMacth(Match match);
	Match retrieveByPlayer(Match match);
	List<Match> retrieveAllByWeek(Date date);
	List<Match> retrieveAllByPlayer(int id);
	List<Match> retrieveAllByTeam(int team);
	boolean updatePoint(Match match);
	boolean updateTeam(Match match);
	boolean updateResult(Match match);
	boolean delete(Match match);
	
	boolean createMatchWeek(MatchWeek matchWeek);
	MatchWeek retrieveMatchWeek(String week_id);
	boolean deleteMatchWeek(String week_id);
	boolean updateMatchWeek(MatchWeek matchWeek);
	
	boolean insertMatchLog(MatchLog matchLog);
	MatchLog retrieveLogByMatch(String match_id);
	List<MatchLog> retrieveLogByWeek(String week_id);
	boolean updateMatchLog(MatchLog matchLog);
	boolean deleteLogByMatch(String match_id);
	boolean deleteLogByWeek(String week_id);
	
	boolean insertRecord(Record record);
	boolean deleteRecordByWeek(String week_id);
	boolean deleteRecordByMatch(String match_id);
	List<Record> retrieveRecordByMember(int mem_id);
	List<Record> retrieveRecordByWeek(String week_id);
	Record retrieveRecordByMatch(String match_id);
	
	
}
