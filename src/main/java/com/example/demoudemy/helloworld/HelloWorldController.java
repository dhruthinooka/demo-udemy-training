package com.example.demoudemy.helloworld;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

	@Autowired
	private MessageSource messageSource;
	
	@GetMapping("/helloworld")
	public String helloWorld()
	{
		return "Hello World!!!";
	}
	
	@GetMapping("/helloworld-bean")
	public HelloWorldBean helloWorldBean()
	{
		return new HelloWorldBean("Hello World as a bean!!!");
	}
	
	@GetMapping("/helloworld-bean/{name}")
	public HelloWorldBean helloWorldBeanPathVar(@PathVariable String name)
	{
		return new HelloWorldBean(String.format("Hello, :) %s", name));
	}
	
	@GetMapping("/helloworld-internationalized")
	public String helloWorldIn18()
	{
		return messageSource.getMessage("good.morning.message",null,
				LocaleContextHolder.getLocale());
	}
	
	
}