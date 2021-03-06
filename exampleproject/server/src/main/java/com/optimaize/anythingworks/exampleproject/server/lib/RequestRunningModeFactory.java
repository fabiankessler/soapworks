package com.optimaize.anythingworks.exampleproject.server.lib;

import com.optimaize.command4j.Mode;
import com.optimaize.command4j.ext.extensions.exception.exceptiontranslation.ExceptionTranslationExtension;
import com.optimaize.command4j.ext.extensions.logging.customlogging.CommandExecutionLoggerFactoryImpl;
import com.optimaize.command4j.ext.extensions.logging.customlogging.CustomLoggingExtension;
import com.optimaize.command4j.ext.extensions.timeout.configurabletimeout.TimeoutExtension;
import com.optimaize.command4j.lang.Duration;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * Provides Mode instances for running commands.
 *
 * @author Fabian Kessler
 */
@Service
public class RequestRunningModeFactory {

    protected static final Logger logger = LoggerFactory.getLogger(RequestRunningModeFactory.class);

    @NotNull
    public Mode soapDefaultMode() {
        return Mode.create()
                .with(TimeoutExtension.TIMEOUT, Duration.millis(5000))
                .with(ExceptionTranslationExtension.TRANSLATOR, new SoapDefaultServerExceptionTranslator())
                .with(CustomLoggingExtension.LOGGER, new CommandExecutionLoggerFactoryImpl(logger))
        ;
    }

    @NotNull
    public Mode restDefaultMode() {
        return Mode.create()
                .with(TimeoutExtension.TIMEOUT, Duration.millis(5000))
                .with(ExceptionTranslationExtension.TRANSLATOR, new RestDefaultServerExceptionTranslator())
                .with(CustomLoggingExtension.LOGGER, new CommandExecutionLoggerFactoryImpl(logger))
        ;
    }

}
