package com.maxicorrea.springbootinternationalization.controller;

import java.util.Locale;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("locale")
public class LocaleController {

  private final MessageSource messageSource;

  public LocaleController(
      final MessageSource messageSource) {
    this.messageSource = messageSource;
  }

  @GetMapping("/hello")
  public String sayHello(
      @RequestHeader(name = "Accept-Language", required=false) Locale locale) {
    return messageSource.getMessage("common.hello", null, LocaleContextHolder.getLocale());
  }

}
