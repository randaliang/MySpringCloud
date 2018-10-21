package com.superhope.eleclient;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.superhope.MyFeignConfiguration;

            
@FeignClient( name="eleserver",path="/elevalue",
	configuration=MyFeignConfiguration.class,
	fallback = EleFeignClientFeedBack.class)
public interface EleFeignClient {
	
    @RequestMapping(value = "/{code}",method=RequestMethod.GET)
    public List<EleValueDTO> getEleValues(@PathVariable("code") String code);
}
