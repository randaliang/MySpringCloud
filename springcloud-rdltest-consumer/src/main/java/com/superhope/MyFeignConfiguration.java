package com.superhope;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.web.HttpMessageConverters;
import org.springframework.cloud.netflix.feign.FeignAutoConfiguration;
import org.springframework.cloud.netflix.feign.FeignClientsConfiguration;
import org.springframework.cloud.netflix.feign.support.ResponseEntityDecoder;
import org.springframework.cloud.netflix.feign.support.SpringDecoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import feign.Feign;
import feign.codec.Decoder;
import okhttp3.ConnectionPool;

@Configuration
@ConditionalOnClass(Feign.class)
@AutoConfigureBefore(FeignAutoConfiguration.class)
public class MyFeignConfiguration {

	@Autowired
	private ObjectFactory<HttpMessageConverters> messageConverters;

	@Bean
	public Decoder feignDecoder() {
		return new ResponseEntityDecoder(new MyDecoder(this.messageConverters));
	}

	@Bean
	public okhttp3.OkHttpClient okHttpClient() {
		return new okhttp3.OkHttpClient.Builder().readTimeout(60, TimeUnit.SECONDS).connectTimeout(60, TimeUnit.SECONDS)
				.writeTimeout(120, TimeUnit.SECONDS).connectionPool(new ConnectionPool())
				// .addInterceptor();
				.build();
	}

}
