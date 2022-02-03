package com.spring.playerapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.playerapi.model.Player;
import com.spring.playerapi.service.PlayerService;

@RestController
@RequestMapping(value = "/api")
public class PlayerController {
	
	@Autowired
	private PlayerService palyerService;
	
	@GetMapping(value = "/data")
	//http://localhost:8088/playerapi/api/data
	public String getData() {
		return "myData";
	}
	
	// add mapping for GET/ players
    @GetMapping("/players")
    public List<Player> getPlayers(){

        return palyerService.allPlayer();

    }
    
 // add mapping for GET/ customers
    @GetMapping("/players/{playerId}")
    public Player getPlayerId(@PathVariable int playerId){

    	Player player =  palyerService.showPlayer(playerId);

        return player;
    }
}
