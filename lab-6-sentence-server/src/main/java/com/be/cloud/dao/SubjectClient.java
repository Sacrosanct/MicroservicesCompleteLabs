/**
 * 
 */
package com.be.cloud.dao;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author bilgin.ertas
 * 13 Nis 2017
 *
 * _ __     _           
 * ( /  )o  //    o      
 *  /--<,  // _, ,  _ _  
 * /___/(_(/_(_)_(_/ / /_
 *            /|         
 *           (/         
 *  
 */
@FeignClient("LAB-4-SUBJECT")
public interface SubjectClient {

	@RequestMapping(method = RequestMethod.GET, value = "/")
	public String getWord();

}
