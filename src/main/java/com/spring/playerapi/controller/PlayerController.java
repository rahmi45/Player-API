package com.spring.playerapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.playerapi.exception.PlayerNotFoundException;
import com.spring.playerapi.model.Player;
import com.spring.playerapi.service.PlayerService;

@RestController
@RequestMapping(value = "/api")
public class PlayerController {
	
	@Autowired
	private PlayerService playerService;
	
	@GetMapping(value = "/data")
	//http://localhost:8088/playerapi/api/data
	public String getData() {
		return "myData";
	}
	
	// add mapping for GET/ players
    @GetMapping("/players")
    public List<Player> getPlayers(){

        return playerService.allPlayer();

    }
    
 // add mapping for GET/ players
    @GetMapping("/players/{playerId}")
    public Player getPlayerId(@PathVariable int playerId){

    	Player player =  playerService.showPlayer(playerId);
    	if(player == null){
            throw new PlayerNotFoundException("Player with the following id does not exist in the database. id : " + playerId);
    	}
        return player;
    }
    
 // add mapping for POST/ players - add a new player
    @PostMapping("/players")
    public Player addPlayer(@RequestBody Player player){

        // set the id of the player id to 0
        // this will force to make an insert instead of update
    	player.setId(0);
    	playerService.savePlayer(player);
        return player;
    }
}
