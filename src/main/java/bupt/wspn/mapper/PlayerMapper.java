package bupt.wspn.mapper;

import java.util.List;

import bupt.wspn.bean.Player;
import bupt.wspn.bean.User;

public interface PlayerMapper {
	public int create(Player player);
	public Player retrieve(int id );
	public List<Player> findAll();
	public int delete(int id);
	public int update(Player player);

}
