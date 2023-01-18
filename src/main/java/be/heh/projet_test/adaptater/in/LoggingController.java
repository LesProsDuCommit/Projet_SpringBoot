package be.heh.projet_test.adaptater.in;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoggingController {

    // creating a logger
    Logger logger = LoggerFactory.getLogger(LoggingController.class);

    @RequestMapping("/log") public String log()
    {
        // Logging various log level messages
        logger.trace("Log level: TRACE");
        logger.info("Log level: INFO");
        logger.debug("Log level: DEBUG");
        logger.error("Log level: ERROR");
        logger.warn("Log level: WARN");

        return "Hey! You can check the output in the logs";
    }
}