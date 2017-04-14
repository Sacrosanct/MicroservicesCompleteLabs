/**
 * 
 */
package com.be.cloud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.be.cloud.dao.AdjectiveClient;
import com.be.cloud.dao.ArticleClient;
import com.be.cloud.dao.NounClient;
import com.be.cloud.dao.SubjectClient;
import com.be.cloud.dao.VerbClient;

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

	private SubjectClient subjectClient;
	private VerbClient verbClient;
	private ArticleClient articleClient;
	private AdjectiveClient adjectiveClient;
	private NounClient nounClient;

	/* (non-Javadoc)
	 * @see com.be.cloud.service.ISentenceService#buildSentence()
	 */
	@Override
	public String buildSentence() {

		String sentence = "Sentence could not be built!";

		sentence = String.format("%s %s %s %s %s.", subjectClient.getWord(), verbClient.getWord(), articleClient.getWord(), adjectiveClient.getWord(), nounClient.getWord());

		return sentence;
	}

	@Autowired
	public void setSubjectClient(SubjectClient subjectClient) {
		this.subjectClient = subjectClient;
	}

	@Autowired
	public void setVerbClient(VerbClient verbClient) {
		this.verbClient = verbClient;
	}

	@Autowired
	public void setArticleClient(ArticleClient articleClient) {
		this.articleClient = articleClient;
	}

	@Autowired
	public void setAdjectiveClient(AdjectiveClient adjectiveClient) {
		this.adjectiveClient = adjectiveClient;
	}

	@Autowired
	public void setNounClient(NounClient nounClient) {
		this.nounClient = nounClient;
	}

}
