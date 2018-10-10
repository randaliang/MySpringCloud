package com.superhope;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.ser.std.DateSerializer;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

/**
 * json日期转换
 * 
 * @author hui
 *
 */
public class CustomObjectMapper extends ObjectMapper {
	
	/**
     * 
     */
    private static final long serialVersionUID = 1725608671662296536L;
	private static final DateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");
	private static final DateFormat TIME_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public CustomObjectMapper() {
		super();
		configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
		
		
		//parser是否允许单引号来包住属性名称和字符串值。
		configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true);
		setDateFormat(DATE_FORMAT);
		SimpleModule simpleModule = new SimpleModule();
		simpleModule.addSerializer(Date.class, new DateSerializer(false, TIME_FORMAT));
		simpleModule.addSerializer(Long.class, ToStringSerializer.instance);
        simpleModule.addSerializer(Long.TYPE, ToStringSerializer.instance);
        
//      也可以添加反序列化选项
//      simpleModule.addDeserializer(type, deser)
        
		this.registerModule(simpleModule);
		this.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));//设置时区
	}
}
