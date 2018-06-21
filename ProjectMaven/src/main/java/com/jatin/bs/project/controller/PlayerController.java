package com.jatin.bs.project.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.jatin.bs.project.BO.PlayerBO;
import com.jatin.bs.project.VO.CommitPlayerRequest;
import com.jatin.bs.project.VO.CommitPlayerResponse;
import com.jatin.bs.project.VO.ViewPlayerResponse;
import com.jatin.bs.project.exception.PlayerNotFoundException;
import com.jatin.bs.project.service.PlayerService;

@RestController
@RequestMapping(value = "/player")
public class PlayerController {

	@Autowired
	private PlayerService playerService;
	
	// Retrieve all players
	@GetMapping("/players")
	public List<PlayerBO> retrieveAllStudents() {
		return playerService.viewAllPlayers();
	}
	
	//Retrieve player by playerid
	@GetMapping("/players/{playerid}")
	public ViewPlayerResponse retrieveStudent(@PathVariable("playerid") long playerid) {
		Optional<PlayerBO> player = playerService.viewPlayerById(playerid);
		if (!player.isPresent())
			throw new PlayerNotFoundException("id-" + playerid);

		ViewPlayerResponse response = new ViewPlayerResponse();
		response.getPlayers().add(player.get()); 
		return response;
	}
	
	// Delete player by playerid
	@DeleteMapping("/players/{playerid}")
	public void deleteStudent(@PathVariable long playerid) {
		playerService.deletePlayerById(playerid);
	}
	
	@ResponseBody
	@RequestMapping(method = RequestMethod.POST, produces="application/json", consumes="text/html")
	 public CommitPlayerResponse addPlayer(@RequestBody CommitPlayerRequest request) {
		CommitPlayerResponse response = null;
		return response;
	}
	
	// Create a new player
	@PostMapping("/players")
	public CommitPlayerResponse createStudent(@RequestBody CommitPlayerRequest request) {
		CommitPlayerResponse response = new CommitPlayerResponse();
		PlayerBO savedStudent = playerService.addPlayer(request);
		if(null != savedStudent.getPlayerId()) {
			response.setSuccess(true);
		}
		return response;
	}
	
}
