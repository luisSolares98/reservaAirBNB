package com.nur.controller;

import an.awesome.pipelinr.Pipeline;
import com.nur.command.checkin.create.CreateCheckInCommand;
import com.nur.command.checkin.get.GetCheckInCommand;
import com.nur.dtos.CheckInDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/checkIn")
public class CheckInController {

    final Pipeline pipeline;
    @Autowired
    public CheckInController(Pipeline pipeline) {
        this.pipeline = pipeline;
    }

    @PostMapping("/")
    public CheckInDTO createReserve(@RequestBody CheckInDTO checkInDto) {
        CreateCheckInCommand assignSeatCommand = new CreateCheckInCommand(checkInDto);
        return assignSeatCommand.execute(pipeline);
    }
    @GetMapping("/{idCheckIn}")
    public CheckInDTO getReserve(@PathVariable String idCheckIn) {
        GetCheckInCommand assignSeatCommand = new GetCheckInCommand(idCheckIn);
        return assignSeatCommand.execute(pipeline);
    }
}
