package com.example.demoudemy.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonVersioningController {

	@GetMapping(value= "/person/param", params= "version=1")
	public Personv1 personv1()
	{
		return new Personv1("Ha Ni");
	}
	
	@GetMapping(value= "/person/param", params= "version=2")
	public Personv2 personv2()
	{
		return new Personv2(new Name("Ha", "Ni"));
	}
	
	@GetMapping(value= "/person/header", headers = "API-VERSION=1")
	public Personv1 headerv1()
	{
		return new Personv1("Ha Ni");
	}
	
	@GetMapping(value= "/person/header", headers= "API-VERSION=2")
	public Personv2 headerv2()
	{
		return new Personv2(new Name("Ha", "Ni"));
	}
	
	@GetMapping(value= "/person/producer", produces = "application/company.app-v1+json")
	public Personv1 producesv1()
	{
		return new Personv1("Ha Ni");
	}
	
	@GetMapping(value= "/person/producer", produces= "application/company.app-v2+json")
	public Personv2 producesv2()
	{
		return new Personv2(new Name("Ha", "Ni"));
	}
}
