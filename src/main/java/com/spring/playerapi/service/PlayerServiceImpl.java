package com.spring.playerapi.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.playerapi.dao.PlayerDAO;
import com.spring.playerapi.model.Player;


@Service
public class PlayerServiceImpl implements PlayerService{

	private PlayerDAO playerDao;
	
	@Autowired
	public PlayerServiceImpl(PlayerDAO playerDao) {
		this.playerDao = playerDao;
	}


	@Override
	@Transactional
	public List<Player> allPlayer() {
		return playerDao.getPlayers();
	}


	@Override
	@Transactional
	public void savePlayer(Player player) {
		playerDao.addPlayer(player);
		
	}

	@Override
	@Transactional
	public Player showPlayer(int id) {
		return playerDao.getPlayer(id);
	}


	@Override
	@Transactional
	public void deletePlayer(int id) {
		playerDao.removePlayer(id);
		
	}

}
