package com.nur.command.checkout.create;

import an.awesome.pipelinr.Command;
import com.nur.core.BussinessRuleValidationException;
import com.nur.dtos.CheckOutDTO;
import com.nur.exceptions.InvalidDataException;
import com.nur.factories.checkout.CheckOutFactory;
import com.nur.factories.checkout.ICheckOutFactory;
import com.nur.model.CheckOut;
import com.nur.respositories.ICheckOutRepository;
import com.nur.util.CheckOutMapper;
import org.springframework.stereotype.Component;
import java.util.UUID;

@Component
public class CreateCheckOutHandler implements Command.Handler<CreateCheckOutCommand, CheckOutDTO> {


    private final ICheckOutRepository checkOutRepository;
    private final ICheckOutFactory checkOutFactory;


    public CreateCheckOutHandler(ICheckOutRepository reserveRepository) {
        this.checkOutRepository = reserveRepository;
        this.checkOutFactory = new CheckOutFactory();
    }


    @Override
    public CheckOutDTO handle(CreateCheckOutCommand createCheckOutCommand) {
        CheckOut checkOut = null;
        try {
            checkOut = checkOutFactory.create(createCheckOutCommand.checkOutDTO.getDateTimeCheckOut(), createCheckOutCommand.checkOutDTO.getTypeCheckOut(), UUID.fromString(createCheckOutCommand.checkOutDTO.getReserveId()));
            checkOutRepository.update(checkOut);
            return CheckOutMapper.from(checkOut);
        } catch (Exception ex) {
            throw new InvalidDataException("Datos Null");
        }
    }

}
