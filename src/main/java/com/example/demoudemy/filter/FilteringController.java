package com.example.demoudemy.filter;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
public class FilteringController {

	@GetMapping("/filtering")
	public SomeBean retrieveSomeBean()
	{
		return new SomeBean("Value1","Value2", "Value3");
	}
	
	@GetMapping("/filtering-list")
	public List<SomeBean> retrieveListOfSomeBean()
	{
		return Arrays.asList(new SomeBean("Value1","Value2", "Value3"),
				new SomeBean("Value12","Value22", "Value32"));
	}
	
	@GetMapping("/filtering-d")
	public MappingJacksonValue retrieveSomeBeanDynamic()
	{
		SomeBean someBean = new SomeBean("Value1","Value2", "Value3");
		SimpleBeanPropertyFilter filter =
				SimpleBeanPropertyFilter.filterOutAllExcept("field1","field2");
		FilterProvider filters = new SimpleFilterProvider()
				.addFilter("SomeBeanFilter", filter);
		MappingJacksonValue mapping = new MappingJacksonValue(someBean);
		mapping.setFilters(filters);
		return mapping;
	}
	
	@GetMapping("/filtering-list-d")
	public MappingJacksonValue retrieveListOfSomeBeanDynamic()
	{
		List<SomeBean> list = Arrays.asList(new SomeBean("Value1","Value2", "Value3"),
				new SomeBean("Value12","Value22", "Value32"));
		SimpleBeanPropertyFilter filter =
				SimpleBeanPropertyFilter.filterOutAllExcept("field3","field2");
		FilterProvider filters = new SimpleFilterProvider()
				.addFilter("SomeBeanFilter", filter);
		MappingJacksonValue mapping = new MappingJacksonValue(list);
		mapping.setFilters(filters);
		return mapping;
	}
}
