package com.nur;

import com.nur.repositories.checkin.CheckInJpaRepository;
import com.nur.repositories.checkout.CheckOutJpaRepository;
import com.nur.repositories.payment.PaymentJpaRepository;
import com.nur.repositories.publication.PublicationJpaRepository;
import com.nur.repositories.reserve.ReserveJpaRepository;
import com.nur.respositories.ICheckInRepository;
import com.nur.respositories.ICheckOutRepository;
import com.nur.respositories.IPaymentRepository;
import com.nur.respositories.IPublicationRepository;
import com.nur.respositories.IReserveRepository;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.Arrays;

import an.awesome.pipelinr.Command;
import an.awesome.pipelinr.Notification;
import an.awesome.pipelinr.Pipeline;
import an.awesome.pipelinr.Pipelinr;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication()
@EnableJpaRepositories(basePackages = { "com.nur.repositories" })
@OpenAPIDefinition(info = @Info(title = "Domain", version = "1.0.0"))
@EntityScan(basePackages = {"com.nur.model"})
public class Main {

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Bean(name = "reserveRepository")
    public IReserveRepository reserveRepository() {
        return new ReserveJpaRepository();
    }

    @Primary
    @Bean(name = "publishRepository")
    public IPublicationRepository publishRepository() {
        return new PublicationJpaRepository();
    }

    @Primary
    @Bean(name = "checkInRepository")
    public ICheckInRepository checkInRepository() {
        return new CheckInJpaRepository();
    }

    @Primary
    @Bean(name = "checkOutRepository")
    public ICheckOutRepository checkOutRepository() {
        return new CheckOutJpaRepository();
    }
    @Primary
    @Bean(name = "paymentRepository")
    public IPaymentRepository paymentRepository() {
        return new PaymentJpaRepository();
    }
    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return args -> {
            String[] beanNames = ctx.getBeanDefinitionNames();
            Arrays.sort(beanNames);
            for (String beanName : beanNames) {
                /// System.out.println(beanName);
            }
        };
    }
    @Bean
    Pipeline pipeline(
            ObjectProvider<Command.Handler> commandHandlers,
            ObjectProvider<Notification.Handler> notificationHandlers,
            ObjectProvider<Command.Middleware> middlewares
    ) {
        return new Pipelinr()
                .with(commandHandlers::stream)
                .with(notificationHandlers::stream)
                .with(middlewares::orderedStream);
    }
}