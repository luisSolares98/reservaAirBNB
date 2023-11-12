package com.nur.command.publish.get;

import an.awesome.pipelinr.Command;
import com.nur.dtos.PublishDTO;
import com.nur.dtos.ReserveDTO;
import com.nur.model.Publication;
import lombok.Getter;

import java.util.List;

@Getter
public class GetPublishCommand implements Command<List<Publication>> {
    String userID;

    public GetPublishCommand(String userID) {
        this.userID = userID;
    }
}
