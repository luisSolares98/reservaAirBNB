package com.nur.command.publish.get;

import com.nur.exceptions.InvalidDataException;
import com.nur.factories.publication.IPublicationFactory;
import com.nur.factories.publication.PublicationFactory;
import com.nur.model.Publication;
import com.nur.respositories.IPublicationRepository;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

import an.awesome.pipelinr.Command;
import lombok.SneakyThrows;
@Component
public class GetPublishHandler implements Command.Handler<GetPublishCommand, List<Publication>> {
    private final IPublicationRepository publicationRepository;
    private final IPublicationFactory publicationFactory;

    public GetPublishHandler(IPublicationRepository publicationRepository) {
        this.publicationRepository = publicationRepository;
        this.publicationFactory = new PublicationFactory();
    }

    @SneakyThrows
    @Override
    public List<Publication> handle(GetPublishCommand command) {
        try{
            return this.publicationRepository.getByUserID(
                    UUID.fromString(command.getUserID())
            );
        } catch (Exception ex) {
            throw new InvalidDataException(ex.getMessage());
        }
    }

}
