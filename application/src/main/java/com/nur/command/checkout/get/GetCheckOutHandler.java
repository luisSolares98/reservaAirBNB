package com.nur.command.checkout.get;

import an.awesome.pipelinr.Command;
import com.nur.dtos.CheckOutDTO;
import com.nur.exceptions.InvalidDataException;
import com.nur.factories.checkout.CheckOutFactory;
import com.nur.factories.checkout.ICheckOutFactory;
import com.nur.model.CheckOut;
import com.nur.respositories.ICheckOutRepository;
import com.nur.util.CheckOutMapper;
import lombok.SneakyThrows;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class GetCheckOutHandler implements Command.Handler<GetCheckOutCommand, CheckOutDTO> {
    private final ICheckOutRepository checkOutRepository;
    private final ICheckOutFactory checkOutFactory;

    public GetCheckOutHandler(ICheckOutRepository checkOutRepository) {
        this.checkOutRepository = checkOutRepository;
        this.checkOutFactory = new CheckOutFactory();
    }

    @SneakyThrows
    @Override
    public CheckOutDTO handle(GetCheckOutCommand getCheckOutCommand) {
        try{
            CheckOut check = checkOutRepository.getById(UUID.fromString(getCheckOutCommand.getCheck()));
            return CheckOutMapper.from(check);
        } catch (Exception ex) {
            throw new InvalidDataException(ex.getMessage());
        }
    }

}
