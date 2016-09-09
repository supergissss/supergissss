package com.wftech.web.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wftech.domain.common.Post;
import com.wftech.service.common.IPostFacade;

/**
 * @author ws
 *
 */
@Controller
public class ReplayAction {
	
	@Autowired
	IPostFacade postFacade;
	
	@RequestMapping("replay")
	public @ResponseBody String replay(Post post){
		postFacade.post(post);
		return "success";
	}
	
}
