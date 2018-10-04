package com.superhope;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	
    @RequestMapping("/hello")
    public List<PayType> getList() {
    	PayType p = new PayType();
    	p.setCode("code");
    	p.setName("name");
    	p.setPayType("001");
    	List list = new ArrayList();
    	list.add(p);
    	return list;
    }
}