package com.nur.command.checkin.create;

import an.awesome.pipelinr.Command;
import com.nur.core.BussinessRuleValidationException;
import com.nur.dtos.CheckInDTO;
import com.nur.exceptions.InvalidDataException;
import com.nur.factories.checkin.CheckInFactory;
import com.nur.factories.checkin.ICheckInFactory;
import com.nur.model.CheckIn;
import com.nur.respositories.ICheckInRepository;
import com.nur.util.CheckInMapper;
import lombok.SneakyThrows;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class CreateCheckInHandler implements Command.Handler<CreateCheckInCommand, CheckInDTO> {


    private final ICheckInRepository checkInRepository;
    private final ICheckInFactory checkInFactory;


    public CreateCheckInHandler(ICheckInRepository reserveRepository) {
        this.checkInRepository = reserveRepository;
        this.checkInFactory = new CheckInFactory();
    }


    @Override
    public CheckInDTO handle(CreateCheckInCommand createCheckInCommand) {
        CheckIn checkIn = null;
        try {
            checkIn = checkInFactory.create(createCheckInCommand.checkInDTO.getDateTimeCheckIn(), createCheckInCommand.checkInDTO.getTypeCheckIn(), UUID.fromString(createCheckInCommand.checkInDTO.getReserveId()));

            checkInRepository.update(checkIn);
            return CheckInMapper.from(checkIn);
        } catch (Exception ex) {
            throw new InvalidDataException(ex.getMessage());
        }
    }

}
