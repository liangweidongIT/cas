package com.demo.cas.controler;

import lombok.extern.slf4j.Slf4j;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

import org.aspectj.weaver.NewConstructorTypeMunger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEvent;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.demo.cas.annotation.MyAnnotation;
import com.demo.cas.event.MessageEvent;
import com.demo.cas.pojo.Store;
import com.demo.cas.pojo.Store.StoreBuilder;
import com.demo.cas.service.AsyncService;

@RestController
@Api(description = "首页接口")
@Slf4j
public class IndexControler {
	
	@Autowired
	private AsyncService asyncService;
	
	@Autowired
	private ApplicationContext applicationContext;
	
	@GetMapping("index/{name}")
	@MyAnnotation
	@ApiOperation(value="首页", notes="根据url的id来获取用户详细信息")
	@ApiImplicitParam(name = "name", value = "用户name", required = true, dataType = "String", paramType = "path")
	public String index(@PathVariable(value = "name")String name) {
		System.out.println("name：" + name);
		int value = Integer.parseInt(name);
		System.out.println("内部方法：" + value);
		String[] strs = new String[]{"1","2"};
		log.info(strs[6]);
		return "hello:" + name;
	}
	
	@GetMapping("success/{p}")
	public String success(@PathVariable(value="p") String p) {
		long start = System.currentTimeMillis();
		log.info("success:{}","成功方法");
		Store store = Store.builder().build();
		store.setStoreId("s123");
		store.setStoreName("store_new");
		log.info("store:{}" + store.toString());
		
		applicationContext.publishEvent(new MessageEvent(this,"事件:" + p ,"8077@163.com"));
		long end = System.currentTimeMillis();
		log.info("执行时间:" + (end - start));
		return "执行事件:" + (end - start);
	}
	
}
