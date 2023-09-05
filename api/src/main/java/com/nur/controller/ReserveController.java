package com.nur.controller;

import an.awesome.pipelinr.Pipeline;
import com.nur.command.reserve.create.CreateReserveCommand;
import com.nur.command.reserve.get.GetReserveCommand;
import com.nur.dtos.ReserveDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/reserve")
public class ReserveController {

    final Pipeline pipeline;
    @Autowired
    public ReserveController(Pipeline pipeline) {
        this.pipeline = pipeline;
    }

    @PostMapping("/")
    public ReserveDTO createReserve(@RequestBody ReserveDTO reserveDTO) {
        CreateReserveCommand assignSeatCommand = new CreateReserveCommand(reserveDTO);
        return assignSeatCommand.execute(pipeline);
    }
    @GetMapping("/{idReserve}")
    public ReserveDTO getReserve(@PathVariable String idReserve) {
        GetReserveCommand assignSeatCommand = new GetReserveCommand(idReserve);
        return assignSeatCommand.execute(pipeline);
    }
}
