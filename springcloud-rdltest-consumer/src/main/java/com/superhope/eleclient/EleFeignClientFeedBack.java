package com.superhope.eleclient;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;


@Component
public class EleFeignClientFeedBack implements EleFeignClient {

	@Override
	public List<EleValueDTO> getEleValues(String code) {
		List<EleValueDTO> l = new ArrayList<EleValueDTO>();
		EleValueDTO dto = new EleValueDTO();
		dto.setCode("001");
		dto.setName("没有值");
		dto.setElename(code);
		dto.setCreateDate(new Date( System.currentTimeMillis() ));
		l.add(dto);
		return l;
	}

}
