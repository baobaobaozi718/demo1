package com.jt.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//默认条件下使用iso-8859-1的编码格式,所以中文乱码
@PropertySource(value = "classpath:/properties/msg.properties",
		encoding="UTF-8")
public class msgController2 {

	/**
	 * 1.之前通过yml配置文件赋值
	 * 2.现在通过pro文件方式赋值
	 */
	@Value("${msg.username2}")
	private String username;
	@Value("${msg.age2}")
	private Integer age;
	
	@RequestMapping("/getMsg2")
	public String getMsg2() {
		return username+":"+age;
	}
}
