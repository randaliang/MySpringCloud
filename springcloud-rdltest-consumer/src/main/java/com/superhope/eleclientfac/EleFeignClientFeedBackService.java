package com.superhope.eleclientfac;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.superhope.eleclient.EleFeignClient;
import com.superhope.eleclient.EleValueDTO;

@Component
public class EleFeignClientFeedBackService implements EleFeignClientFac{

	@Override
	public List<EleValueDTO> getEleValues(String code) {
		List<EleValueDTO> l = new ArrayList<EleValueDTO>();
		EleValueDTO dto = new EleValueDTO();
		dto.setCode("EleFeignClientFeedBackService");
		dto.setName("没有值");
		dto.setElename(code);
		dto.setCreateDate(new Date( System.currentTimeMillis() ));
		l.add(dto);
		return l;
	}

}
