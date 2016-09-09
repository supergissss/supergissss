package com.wftech.service.common;

import com.wftech.domain.common.RegisterInfo;

/**
 * @author ws
 *
 */
public interface IRegisterFacade {

	/**
	 *是否注册成功
	 * @author Daoliang Li
	 * @param registerInfo 注册信息
	 * @return 是否注册成功
	 */
	public boolean isRegisterSuccess(RegisterInfo registerInfo);
	
}
