package com.superhope.eleclientfac;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.superhope.MyFeignConfiguration;
import com.superhope.eleclient.EleFeignClientFeedBack;
import com.superhope.eleclient.EleValueDTO;

@FeignClient( name="eleserver",path="/elevalue",
configuration=MyFeignConfiguration.class,
fallbackFactory = EleFeignClientFactory.class)
public interface EleFeignClientFac {
	  @RequestMapping(value = "/{code}",method=RequestMethod.GET)
	    public List<EleValueDTO> getEleValues(@PathVariable("code") String code);
}
