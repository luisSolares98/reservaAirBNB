package com.nur.command.checkin.get;

import an.awesome.pipelinr.Command;
import com.nur.dtos.CheckInDTO;
import com.nur.factories.checkin.CheckInFactory;
import com.nur.factories.checkin.ICheckInFactory;
import com.nur.model.CheckIn;
import com.nur.respositories.ICheckInRepository;
import com.nur.util.CheckInMapper;
import lombok.SneakyThrows;
import org.springframework.stereotype.Component;
import java.util.UUID;

@Component
public class GetCheckInHandler implements Command.Handler<GetCheckInCommand, CheckInDTO> {
    private final ICheckInRepository checkInRepository;
    private final ICheckInFactory checkInFactory;

    public GetCheckInHandler(ICheckInRepository checkInRepository) {
        this.checkInRepository = checkInRepository;
        this.checkInFactory = new CheckInFactory();
    }

    @SneakyThrows
    @Override
    public CheckInDTO handle(GetCheckInCommand checkInCommand) {
        CheckIn reserve = checkInRepository.getById(UUID.fromString(checkInCommand.checkInID));
        if (reserve == null) {
            return null;
        }
        return CheckInMapper.from(reserve);
    }

}
