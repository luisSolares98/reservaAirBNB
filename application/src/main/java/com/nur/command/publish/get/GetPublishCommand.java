package com.nur.command.publish.get;

import com.nur.model.Publication;

import java.util.List;

import an.awesome.pipelinr.Command;
import lombok.Getter;

@Getter
public class GetPublishCommand implements Command<List<Publication>> {
    String userID;

    public GetPublishCommand(String userID) {
        this.userID = userID;
    }
}
