package bupt.wspn.controller;

import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import bupt.wspn.bean.MatchWeek;
import bupt.wspn.bean.Player;
import bupt.wspn.mapper.MatchMapper;
import bupt.wspn.mapper.PlayerMapper;

@Controller
@RequestMapping("/signIn")
public class SignInController {

	@Autowired
	PlayerMapper playerMapper;
	
	@Autowired
	MatchMapper matchMapper;
	
	@RequestMapping(method=RequestMethod.GET)
	public String signIn(HttpServletRequest request, HttpServletResponse response) throws IOException{
//		System.out.println("收到get的signIn请求");
		return "signIn/signIn";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> signInOperate(HttpServletRequest request, HttpServletResponse response) throws IOException{
		
		ModelAndView modelAndView = new ModelAndView();
		String playerId = request.getParameter("playerId");
//		System.out.println("收到post的signIn请求"+playerId);
		Map<String, Object> map = new HashMap<>();
		if(playerId!=null){
			MatchWeek matchWeek = new MatchWeek();
			
			SimpleDateFormat formater=new SimpleDateFormat("yyyyMMdd");
			Calendar calendar = Calendar.getInstance();
			calendar.setFirstDayOfWeek(Calendar.MONDAY);
			calendar.set(Calendar.DAY_OF_WEEK,calendar.getFirstDayOfWeek());
			Date date = new Date(calendar.getTime().getTime());
			
			matchWeek.setWeek_id(formater.format(date));
			
			try {
				if(playerMapper.retrieve(Integer.valueOf(playerId))!=null){
					MatchWeek matchWeek2 = matchMapper.retrieveMatchWeek(matchWeek.getWeek_id());
					if(matchWeek2 != null){
						String tmp = matchWeek2.getPlayer_pool();
						tmp = tmp.substring(1, tmp.length()-1);
						List playerList = new ArrayList<>(Arrays.asList(tmp.split(",")));
						if(playerList.contains(playerId)){
							//already signin
							map.put("status", "已经报名，请勿重复提交");
						}else {
							playerList.add(playerId);
							matchWeek.setPlayer_pool(playerList.toString());
							matchMapper.updateMatchWeek(matchWeek);
							map.put("status", "成功报名");
						}
					}else{
						List<String> playerList = new ArrayList<>();
						playerList.add(playerId);
						matchWeek.setPlayer_pool(playerList.toString());
						matchMapper.createMatchWeek(matchWeek);
						map.put("status", "成功报名，你是第一个哟");
					}

				}else {
					map.put("status", "该用户不存在，请确认ID");
				}
				

			} catch (Exception e) {
				// TODO: handle exception
				map.put("status", "报名失败");
			}
		}

 		return map;
	}
}
