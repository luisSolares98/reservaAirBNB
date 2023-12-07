package com.nur.controller;

import an.awesome.pipelinr.Pipeline;
import com.nur.command.publish.get.GetPublishCommand;
import com.nur.model.Publication;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/publish")
public class PublishController {

	final Pipeline pipeline;

	@Autowired
	public PublishController(Pipeline pipeline) {
		this.pipeline = pipeline;
	}

	@GetMapping("/users/{userId}")
	public List<Publication> getPublish(@Valid @PathVariable String userId) {
		GetPublishCommand assignSeatCommand = new GetPublishCommand(userId);
		return assignSeatCommand.execute(pipeline);
	}

}
