package bupt.wspn.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.naming.spi.DirStateFactory.Result;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.javassist.bytecode.stackmap.BasicBlock.Catch;
import org.apache.ibatis.javassist.expr.NewArray;
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
		switch(action){
			case "query":
				List<Player> list = playerMapper.findAll();
				System.out.println("db request");
				return list;
			case "del":
				System.out.println("delete user");
				try{
					playerMapper.delete(Integer.valueOf(request.getParameter("mem_id")));
				}catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
					return null;
				}
				return new ArrayList<>();
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
}
