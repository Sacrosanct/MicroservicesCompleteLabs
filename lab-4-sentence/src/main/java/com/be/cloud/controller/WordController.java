/**
 * 
 */
package com.be.cloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author bilgin.ertas
 * 7 Mar 2017
 *
 * _ __     _           
 * ( /  )o  //    o      
 *  /--<,  // _, ,  _ _  
 * /___/(_(/_(_)_(_/ / /_
 *            /|         
 *           (/         
 *  
 */
@RestController
public class WordController {

	//@Autowired
	//DiscoveryClient client;

	@Autowired
	LoadBalancerClient loadBalancerClient;

	private String getWord(String service) {
		String word = null;

		//List<ServiceInstance> servicesList = client.getInstances(service);
		ServiceInstance instance = loadBalancerClient.choose(service);

		if (instance != null && instance.getUri() != null) {

			word = new RestTemplate().getForObject(instance.getUri(), String.class);
		}

		return word;

	}

	@RequestMapping("/sentence")
	public @ResponseBody String getSentence() {
		return getWord("LAB-4-SUBJECT") + " " + getWord("LAB-4-VERB") + " " + getWord("LAB-4-ARTICLE") + " " + getWord("LAB-4-ADJECTIVE") + " " + getWord("LAB-4-NOUN") + ".";
	}

}
