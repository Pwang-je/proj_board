package com.proj_board.commons.exception;

import java.util.logging.Logger;
import org.apache.tools.ant.taskdefs.Execute;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class CommonExceptionAdvice {
  private static final Logger logger = (Logger) LoggerFactory.getLogger(CommonExceptionAdvice.class);

  @ExceptionHandler(Exception.class)
  public ModelAndView commonException(Execute e) {
    logger.info(e.toString());
    ModelAndView andView = new ModelAndView();
    andView.addObject("exception", e);
    andView.setViewName("/commons/common_error");

    return andView;
  }
}
