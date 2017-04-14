/**
 * 
 */
package com.be.cloud.service;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.be.cloud.dao.AdjectiveClient;
import com.be.cloud.dao.ArticleClient;
import com.be.cloud.dao.NounClient;
import com.be.cloud.dao.SubjectClient;
import com.be.cloud.dao.VerbClient;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

/**
 * @author bilgin.ertas
 * 14 Nis 2017
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
public class WordServiceImpl implements WordService {

	@Autowired
	private SubjectClient subjectClient;
	@Autowired
	private VerbClient verbClient;
	@Autowired
	private ArticleClient articleClient;
	@Autowired
	private AdjectiveClient adjectiveClient;
	@Autowired
	private NounClient nounClient;

	public String getDefaultFallbackString() {
		return StringUtils.EMPTY;
	}

	/* (non-Javadoc)
	 * @see com.be.cloud.service.WordService#getSubject()
	 */
	@Override
	@HystrixCommand(fallbackMethod = "getFallbackValue4Subject")
	public String getSubject() {
		return subjectClient.getWord();
	}

	private String getFallbackValue4Subject() {
		return "Someone";
	}

	/* (non-Javadoc)
	 * @see com.be.cloud.service.WordService#getVerb()
	 */
	@Override
	public String getVerb() {
		return verbClient.getWord();
	}

	/* (non-Javadoc)
	 * @see com.be.cloud.service.WordService#getArticle()
	 */
	@Override
	public String getArticle() {
		return articleClient.getWord();
	}

	/* (non-Javadoc)
	 * @see com.be.cloud.service.WordService#getAdjective()
	 */
	@Override
	@HystrixCommand(defaultFallback = "getDefaultFallbackString")
	public String getAdjective() {
		return adjectiveClient.getWord();
	}

	/* (non-Javadoc)
	 * @see com.be.cloud.service.WordService#getNoun()
	 */
	@Override
	@HystrixCommand(defaultFallback = "getFallbackValue4Noun")
	public String getNoun() {
		return nounClient.getWord();
	}

	private String getFallbackValue4Noun() {
		return "something";
	}

}
