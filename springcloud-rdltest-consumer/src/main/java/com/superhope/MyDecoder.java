package com.superhope;

import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.Arrays;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.boot.autoconfigure.web.HttpMessageConverters;
import org.springframework.cloud.netflix.feign.support.SpringDecoder;
import org.springframework.web.client.HttpMessageConverterExtractor;

import com.google.inject.internal.MoreTypes.ParameterizedTypeImpl;
import com.superhope.eleclient.PayType;

import feign.FeignException;
import feign.Response;
import feign.codec.DecodeException;
import feign.codec.Decoder;

public class MyDecoder extends SpringDecoder {

	private final static String eleValue = "/elevalue/";
	
	private final static String PAYTYPE = "PAYTYPE";
	
	public MyDecoder(ObjectFactory<HttpMessageConverters> messageConverters) {
		super(messageConverters);
	}

	@Override
	public Object decode(final Response response, Type type)
			throws IOException, FeignException{
		if( type instanceof ParameterizedType ){
			String url = response.request().url();
		
			if( url.indexOf(eleValue)>=0){
				int i = url.lastIndexOf(eleValue)+eleValue.length();
				String s = url.substring(i);
				if( PAYTYPE.equals(s) ){
					ParameterizedType p = new ParameterizedTypeImpl(((ParameterizedType) type).getOwnerType(), ((ParameterizedType) type).getRawType(),
							PayType.class);
					return super.decode(response, p);
				}
			}
		}
		return super.decode(response, type);
	}
}




