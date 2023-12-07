package com.nur.controller;

import an.awesome.pipelinr.Pipeline;
import com.nur.command.checkout.create.CreateCheckOutCommand;
import com.nur.command.checkout.get.GetCheckOutCommand;
import com.nur.dtos.CheckOutDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/checkOut")
public class CheckOutController {

	final Pipeline pipeline;

	@Autowired
	public CheckOutController(Pipeline pipeline) {
		this.pipeline = pipeline;
	}

	@PostMapping("/")
	public CheckOutDTO create(@RequestBody CheckOutDTO check) {
		CreateCheckOutCommand assignSeatCommand = new CreateCheckOutCommand(check);
		return assignSeatCommand.execute(pipeline);
	}

	@GetMapping("/{idCheck}")
	public CheckOutDTO get(@PathVariable String idCheck) {
		GetCheckOutCommand assignSeatCommand = new GetCheckOutCommand(idCheck);
		return assignSeatCommand.execute(pipeline);
	}

}
