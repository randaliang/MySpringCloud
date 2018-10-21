package com.superhope.eleclientfac;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.superhope.eleclient.EleFeignClient;

import feign.hystrix.FallbackFactory;
@Component
public class EleFeignClientFactory  implements FallbackFactory<EleFeignClientFac>{

	@Resource EleFeignClientFeedBackService ele;
	
	@Override
	public EleFeignClientFac create(Throwable cause) {
		cause.printStackTrace();
		return ele;
	}

}
