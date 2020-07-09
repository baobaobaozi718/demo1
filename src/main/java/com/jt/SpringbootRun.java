package com.jt;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.beans.factory.BeanClassLoaderAware;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.AutoConfigurationExcludeFilter;
import org.springframework.boot.autoconfigure.AutoConfigurationImportSelector;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.TypeExcludeFilter;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.DeferredImportSelector;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.core.Ordered;

@SpringBootApplication//springboot最为重要的入口注解
public class SpringbootRun {
 /**
  * 程序执行的过程
  * 1.利用main方法执行springboot启动程序
  * 2.程序加载@springbootapplication
  * 3.@Target(ElementType.TYPE) 当前注解对类有效
     @Retention(RetentionPolicy.RUNTIME) 在运行期该注解有效
    @Documented 相关文档信息
     @Inherited 可以被继承
	上述的注解是元注解

    @SpringBootConfiguration springboot的主启动类就是一个配置类
    @EnableAutoConfiguration 开箱即用:只要导入了指定的jar包文件,则可以自动的实现配置
  		    @AutoConfigurationPackage //定义包扫描额路径信息 主启动类的包路径 以后写代码最少同包及子包中
           @Import(AutoConfigurationImportSelector.class) 实现了开箱即用的功能
           总结:springboot中选择器的配置,扫描pom.xml文件中的jar包的文件
           之后将jar包文件中的配置予以执行
           AutoConfigurationImportSelector implements DeferredImportSelector, BeanClassLoaderAware,
		      ResourceLoaderAware, BeanFactoryAware, EnvironmentAware, Ordered 
		   说明:Aware是spring框架从项目的启动-到项目的销毁的各个时期的接口
		
	了解:加载第三方的类信息	   
     @ComponentScan(excludeFilters = { @Filter(type = FilterType.CUSTOM, classes = TypeExcludeFilter.class),
	@Filter(type = FilterType.CUSTOM, classes = AutoConfigurationExcludeFilter.class) })
	
   @param args
  */
	public static void main(String[] args) {
		SpringApplication.run(SpringbootRun.class, args);
	}

}
