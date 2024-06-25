package com.stacksimplify.restservices.Hello;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
	
	@Autowired
	private ResourceBundleMessageSource messageResource;
	
	//@RequestMapping(method = RequestMethod.GET, path = "/helloworld")
	@GetMapping("/helloworld")
	public String helloWorld() {
		return "Hello World";
	}
	
	@GetMapping("/helloworld-bean")
	public UserDetails helloWorldBean() {
		return new UserDetails("Armando", "Venegas", "Aguascalientes");
	}
	
	@GetMapping("/hello-int")
	public String getMessagesInI18NFormat(@RequestHeader(name="Accept-Languaje", required=false) String locale) {
		return messageResource.getMessage("label.hello", null, new Locale(locale));
	}
	
	@GetMapping("/hello-int2")
	public String getMessagesInI18NFormat2() {
		return messageResource.getMessage("label.hello", null, LocaleContextHolder.getLocale());
	}
}
