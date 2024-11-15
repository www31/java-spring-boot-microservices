package com.telusko;

import org.h2.tools.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.SQLException;

@SpringBootApplication
public class QuestionServiceApplication
{
    public static void main( String[] args ) throws SQLException {
        Server.createTcpServer().start();
        SpringApplication.run(QuestionServiceApplication.class, args);
    }
}
