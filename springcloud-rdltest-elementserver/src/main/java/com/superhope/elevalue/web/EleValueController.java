package com.superhope.elevalue.web;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.superhope.elevalue.dto.EleValueDTO;

@RestController
@RequestMapping(value="/elevalue", produces="application/json")  
public class EleValueController {

	@GetMapping("/{code}")
	public List<EleValueDTO> getEleValues( String code ){
		if(true){
			throw new RuntimeException("代码错了！");
		}
//		try {
//			Thread.sleep(1000L);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		List<EleValueDTO> l = new ArrayList<EleValueDTO>();
		EleValueDTO dto = new EleValueDTO();
		dto.setCode("001");
		dto.setName("直接支付");
		dto.setElename(code);
		dto.setCreateDate(new Date( System.currentTimeMillis() ));
		l.add(dto);
		EleValueDTO dto1 = new EleValueDTO();
		dto1.setCode("002");
		dto1.setName("授权支付");
		dto1.setElename(code);
		dto1.setCreateDate(new Date( System.currentTimeMillis() ));
		l.add(dto1);
		return l;
	}
	
	@GetMapping("/{elecode}/{elevaluecode}")
	public EleValueDTO getEleValue( @PathVariable String elecode,@PathVariable String elevaluecode){
		EleValueDTO dto = new EleValueDTO();
		dto.setCode(elevaluecode);
		dto.setName("直接支付");
		dto.setElename(elecode);
		dto.setCreateDate(new Date( System.currentTimeMillis() ));
		return dto;
	}
	
	@GetMapping("/{elecode}/{elevaluecode}/paratest")
	public EleValueDTO getEleValue( @PathVariable String elecode, @PathVariable String elevaluecode,
			@RequestParam String paraname){
		EleValueDTO dto = new EleValueDTO();
		dto.setCode(elevaluecode);
		dto.setName(paraname);
		dto.setElename(elecode);
		dto.setCreateDate(new Date( System.currentTimeMillis() ));
		return dto;
	}
	
}
