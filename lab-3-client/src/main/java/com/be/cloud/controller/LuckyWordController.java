/**
 * 
 */
package com.be.cloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author bilgin.ertas
 * 24 Şub 2017
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
public class LuckyWordController {

	@Value("${lucky-word}")
	String luckyWord;

	@RequestMapping("/get-lw")
	public String showLuckWord() {
		return "The lucky word is: " + this.luckyWord;
	}

}
