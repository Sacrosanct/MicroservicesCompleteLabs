/**
 * 
 */
package com.be.cloud.controller;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.be.cloud.service.ISentenceService;

/**
 * @author bilgin.ertas
 * 12 Nis 2017
 *
 * _ __     _           
 * ( /  )o  //    o      
 *  /--<,  // _, ,  _ _  
 * /___/(_(/_(_)_(_/ / /_
 *            /|         
 *           (/         
 *  
 */
@Controller
public class SentenceController {

	@Autowired
	ISentenceService sentenceService;

	@RequestMapping("/sentence")
	public @ResponseBody String getSentences() {

		String sentence = StringUtils.EMPTY;

		sentence = sentenceService.buildSentence();

		return sentence;
	}

}
