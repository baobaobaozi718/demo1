package com.jt.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@RestController
@ConfigurationProperties(prefix = "msg")
@Data
@Accessors(chain=true)//开启链式加载
@AllArgsConstructor
@NoArgsConstructor
public class MsgController {

	//有时可能会通过配置文件的形式为属性动态的赋值
	/**
	 * @value 表示从spring容器中动态获取数据
	 * 通过spel表达式动态取值
	 */
	/*
	 * @Value("${msg.username}") private String username;
	 * 
	 * @Value("${msg.age}") private Integer age;
	 */
	
	/**
	 * 批量为属性赋值,必须配合set方法才能赋值
	 * @return
	 */
	private String username;
	private Integer age;
	
	@RequestMapping("/getMsg")
	public String getMes() {
		
		MsgController controller=new MsgController();
		controller.setUsername("asdfasdfsa").setAge(56);
		
		return "返回值结果:"+username+":"+age;
	}
}
