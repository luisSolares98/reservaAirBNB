package com.nur.command.checkin.get;

import com.nur.dtos.CheckInDTO;
import com.nur.exceptions.InvalidDataException;
import com.nur.factories.checkin.CheckInFactory;
import com.nur.factories.checkin.ICheckInFactory;
import com.nur.model.CheckIn;
import com.nur.respositories.ICheckInRepository;
import com.nur.util.CheckInMapper;

import org.springframework.stereotype.Component;

import java.util.UUID;

import an.awesome.pipelinr.Command;

@Component
public class GetCheckInHandler implements Command.Handler<GetCheckInCommand, CheckInDTO> {
    private final ICheckInRepository checkInRepository;
    private final ICheckInFactory checkInFactory;

    public GetCheckInHandler(ICheckInRepository checkInRepository) {
        this.checkInRepository = checkInRepository;
        this.checkInFactory = new CheckInFactory();
    }

    @Override
    public CheckInDTO handle(GetCheckInCommand checkInCommand) {
       try {
            CheckIn reserve = checkInRepository.getById(UUID.fromString(checkInCommand.getCheckInID()));
            return CheckInMapper.from(reserve);
        } catch (Exception ex) {
           throw new InvalidDataException(ex.getMessage());
        }
    }

}
