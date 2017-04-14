/**
 * 
 */
package com.be.cloud.service;

import javax.validation.constraints.NotNull;

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
public interface ISentenceService {

	public @NotNull String buildSentence();

}
