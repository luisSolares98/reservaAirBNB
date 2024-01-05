package com.nur.command.checkin.get;

import an.awesome.pipelinr.Command;
import com.nur.dtos.CheckInDTO;
import lombok.Getter;

@Getter
public class GetCheckInCommand implements Command<CheckInDTO> {

	String checkInID;

	public GetCheckInCommand(String checkInID) {
		this.checkInID = checkInID;
	}

}
