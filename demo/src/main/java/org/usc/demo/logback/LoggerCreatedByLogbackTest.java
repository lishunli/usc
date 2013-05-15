package org.usc.demo.logback;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.encoder.PatternLayoutEncoder;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.rolling.RollingFileAppender;
import ch.qos.logback.core.rolling.TimeBasedRollingPolicy;

public class LoggerCreatedByLogbackTest {
    public static void main(String[] args) {
        String loggerName = "test";

        Logger logger = LoggerFactory.getLogger(loggerName);
        LoggerContext loggerContext = (LoggerContext) LoggerFactory.getILoggerFactory();

        ch.qos.logback.classic.Logger newLogger = (ch.qos.logback.classic.Logger) logger;
        newLogger.detachAndStopAllAppenders();

        // define appender
        RollingFileAppender<ILoggingEvent> appender = new RollingFileAppender<ILoggingEvent>();

        // policy
        TimeBasedRollingPolicy<ILoggingEvent> policy = new TimeBasedRollingPolicy<ILoggingEvent>();
        policy.setContext(loggerContext);
        policy.setMaxHistory(5);
        policy.setFileNamePattern("/home/lionbule/%d{yyyy-MM-dd}.log");
        policy.setParent(appender);
        policy.start();

        // encoder
        PatternLayoutEncoder encoder = new PatternLayoutEncoder();
        encoder.setContext(loggerContext);
        encoder.setPattern("%message%n");
        encoder.start();

        // start appender
        appender.setRollingPolicy(policy);
        appender.setContext(loggerContext);
        appender.setEncoder(encoder);
        appender.setPrudent(true); // support that multiple JVMs can safely write to the same file.
        appender.start();

        newLogger.addAppender(appender);

        // setup level
        newLogger.setLevel(Level.WARN);
        // remove the appenders that inherited 'ROOT'.
        newLogger.setAdditive(false);
    }

}
