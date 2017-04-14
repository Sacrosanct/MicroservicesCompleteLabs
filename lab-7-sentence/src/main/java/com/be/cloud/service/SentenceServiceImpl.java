/**
 * 
 */
package com.be.cloud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
@Service
public class SentenceServiceImpl implements ISentenceService {

	@Autowired
	private WordService wordService;

	/* (non-Javadoc)
	 * @see com.be.cloud.service.ISentenceService#buildSentence()
	 */
	@Override
	public String buildSentence() {

		String sentence = "Sentence could not be built!";

		sentence = String.format("%s %s %s %s %s.", wordService.getSubject(), wordService.getVerb(), wordService.getArticle(), wordService.getAdjective(), wordService.getNoun());

		return sentence;
	}

}
