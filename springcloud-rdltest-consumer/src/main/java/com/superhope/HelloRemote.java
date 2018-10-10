package com.superhope;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name= "eleserver")
public interface HelloRemote {
    @RequestMapping(value = "/hello")
    public List<ElementDTO> hello();
}