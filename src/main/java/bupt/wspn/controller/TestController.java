package bupt.wspn.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.naming.spi.DirStateFactory.Result;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.javassist.bytecode.stackmap.BasicBlock.Catch;
import org.apache.ibatis.javassist.expr.NewArray;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyEmitterReturnValueHandler;

import bupt.wspn.bean.Match;
import bupt.wspn.bean.MatchLog;
import bupt.wspn.bean.MatchWeek;
import bupt.wspn.bean.Player;
import bupt.wspn.bean.Record;
import bupt.wspn.mapper.MatchMapper;
import bupt.wspn.mapper.PlayerMapper;
import bupt.wspn.mapper.UserMapper;

@Controller
public class TestController {
	
	@Autowired
	PlayerMapper playerMapper;
	
	@Autowired
	MatchMapper matchMapper;
	
	@Autowired
	SqlSessionFactory sqlSessionFactory;


	@RequestMapping("/index")
	public String hello(HttpServletRequest request, HttpServletResponse response) throws IOException{
		
		return "index";
	}
	
	@RequestMapping("/welcome")
	public String welcome(HttpServletRequest request, HttpServletResponse response) throws IOException{
		
		return "welcome";
	}
	
	@RequestMapping("/user")
	public String registe(HttpServletRequest request, HttpServletResponse response) throws IOException{
		
		return "userinfo";
	}
	
	@RequestMapping("/pvp")
	public String pvp(Map<String, Object> model) throws IOException{
		
		List<Player> list = playerMapper.findAll();
		model.put("playerList", list);
		
		System.out.println("list all players");
		//System.out.println("player"+player.getName());
		return "pvp";
	}

	@RequestMapping("/ocrad")
	public String ocrad(HttpServletRequest request, HttpServletResponse response) throws IOException{
		return "ocrad";
	}
	
	@RequestMapping("/video")
	public String video(HttpServletRequest request, HttpServletResponse response) throws IOException{
		return "video";
	}
	
	@RequestMapping("db")
	@ResponseBody
	public List<Player> dbOperate(HttpServletRequest request, HttpServletResponse response) throws IOException{
		
		String action = request.getParameter("action");
		String method = request.getParameter("method");

		switch(action){
			case "query":
				switch (method) {
				case "":
					List<Player> list = playerMapper.findAll();
					System.out.println("db request for player list");
					return list;
				case "1":
					List<Player> list1 = playerMapper.findSignedPlayer(MatchWeek.getCurrentWeekId());
					System.out.println("db request for sign-in player list"+list1.toString()+MatchWeek.getCurrentWeekId());
					return list1;
				default:
					System.out.println("db request for nothing");
					break;
				}

			case "del":
				switch (method) {
				case "":
					System.out.println("delete user");
					try{
						playerMapper.delete(Integer.valueOf(request.getParameter("mem_id")));
					}catch (Exception e) {
						// TODO: handle exception
						e.printStackTrace();
						return null;
					}
					return new ArrayList<>();
				case "1":
					System.out.println("delete sign-in log");
					try{
						matchMapper.deletePlayerLog(MatchWeek.getCurrentWeekId(), Integer.valueOf(request.getParameter("mem_id")));
					}catch (Exception e) {
						// TODO: handle exception
						e.printStackTrace();
						return null;
					}
					return new ArrayList<>();

				default:
					break;
				}

			case "alter":
				System.out.println("alter user");
				try{
					int id = Integer.valueOf(request.getParameter("mem_id"));
					Player player = playerMapper.retrieve(id);
					if(player!=null){
						player.setPoint(Integer.valueOf(request.getParameter("point")));
						playerMapper.update(player);
					}else{
						return null;
					}
				}catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
					return null;
				}
				return new ArrayList<>();
			default: return null;
		}
		//System.out.println("player"+player.getName());
	}
	// for testing
	@RequestMapping("dbt")
	@ResponseBody
	public List<Player> dbOperate1(HttpServletRequest request, HttpServletResponse response) throws IOException{
		Match match = new Match();
		match.setMatch_id("2017082801");
		match.setWeek_id("20170828");
		match.setMem_id(14);
		matchMapper.signIn(match);
		return null;
		//System.out.println("player"+player.getName());
	}
	@RequestMapping("match")
	public String match(HttpServletRequest request, HttpServletResponse response) throws IOException{
		return "weekMatch";
	}
	
	public void draw(){
		
		String week_id = MatchWeek.getCurrentWeekId();
		List<Match> matchs = matchMapper.retrieveAllByWeekTrimed(week_id);
		List<Integer> pList = new ArrayList<>();
		for (Match match : matchs) {
			pList.add(match.getMem_id());
		}
        //报名人数
        int signUpNum = matchs.size();
        //获得比赛资格人数
        int teamNum = signUpNum/5;
        int playerNum = teamNum*5;
        
        

        List list = new ArrayList<Integer>();
        List list_res = new ArrayList<Integer>();
        for (int i = 0; i < signUpNum; i++)
            list.add(i+1);
        Collections.shuffle(list);

        list_res = list.subList(playerNum,list.size());
        list = list.subList(0,playerNum);

        System.out.println("成功参赛选手编号："+list.toString());
        System.out.println("选手池内编号："+list_res.toString());

        for(int i=0; i<teamNum;i++){
            System.out.println("第"+Integer.toString(i+1)+"组:");
            for(int j=0;j<5;j++){
                System.out.print(list.get(i * 5 + j).toString()+" ");
            }
            System.out.println();
        }
	}
}
