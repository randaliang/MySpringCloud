package com.superhope;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.superhope.eleclient.EleFeignClient;
import com.superhope.eleclient.EleValueDTO;

@RestController
@RequestMapping("/consumer/")
public class ConsumerController {

    @Autowired
    HelloRemote HelloRemote;
    @Autowired
    EleFeignClient eleFeignClient;
	
    @RequestMapping("/elevalue/{code}")
    public List<EleValueDTO> getelevalues( @PathVariable("code") String code) {
    	List<EleValueDTO> list =  eleFeignClient.getEleValues(code);
    	DateFormat TIME_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    	String s = TIME_FORMAT.format( list.get(0).getCreateDate() );
    	System.out.println( list.get(0).getCreateDate().getClass());
    	list.get(0).setCreateDate(new Date( list.get(0).getCreateDate().getTime() ));
    	list.get(0).setCreate_time(new Date( list.get(0).getCreateDate().getTime() ));
    	
    	return list;
    }
    
  
    
    @RequestMapping("/hello/{code}")
    public List<ElementDTO> index() {
    	 
        return HelloRemote.hello();
    }
     

}