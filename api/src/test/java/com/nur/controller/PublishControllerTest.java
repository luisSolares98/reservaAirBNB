package com.nur.controller;

import an.awesome.pipelinr.Pipeline;
import com.nur.command.publish.get.GetPublishCommand;
import com.nur.controller.model.PublishDTOFixture;
import com.nur.dtos.PublishDTO;
import com.nur.model.Publication;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.text.ParseException;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
class PublishControllerTest {

	@Mock
	Pipeline pipeline;

	@Mock
	PublishController controller;

	@BeforeEach
	void setUp() {
		controller = new PublishController(pipeline);
	}

	@Test
	void getPublish() throws ParseException {
		List<Publication> expect = PublishDTOFixture.withDefault();
		Mockito.when(pipeline.send(any(GetPublishCommand.class))).thenReturn(expect);
		List<Publication> response = controller.getPublish("effa368e-2f33-49c7-94e4-a4dfb3be2c27");
		Assertions.assertEquals(response, expect);
	}

}