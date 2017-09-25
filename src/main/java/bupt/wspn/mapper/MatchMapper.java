package bupt.wspn.mapper;

import java.sql.Date;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.codehaus.jackson.annotate.JsonTypeInfo.Id;

import bupt.wspn.bean.Match;
import bupt.wspn.bean.MatchLog;
import bupt.wspn.bean.MatchWeek;
import bupt.wspn.bean.Record;

public interface MatchMapper {


	
	boolean signIn(Match match);
	Match retrieveByPlayerLog(@Param(value="match_id") String match_id, @Param(value="mem_id") int mem_id);
	List<Match> retrieveAllByWeek(String week_id);
	List<Match> retrieveAllByPlayer(int mem_id);
	List<Match> retrieveAllByTeam(@Param(value="match_id") String match_id, @Param(value="team") int team);
	boolean updatePlayerLogPoint(Match match);
	boolean updatePlayerLogTeam(Match match);
	boolean updatePlayerLogResult(Match match);
	boolean updatePlayerLog(Match match);
	boolean deletePlayerLog(@Param(value="match_id") String match_id, @Param(value="mem_id") int mem_id);
	boolean deletePlayerLogByWeek(String week_id);
	
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
	List<Record> retrieveRecordByMatch(String match_id);
	Record retrieveRecordByMemberMatch(@Param(value="match_id") String match_id, @Param(value="mem_id") int mem_id);
	
	
}
