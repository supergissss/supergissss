package com.wftech.service.common;

import com.wftech.domain.common.RegisterInfo;

/**
 * @author ws
 *
 */
public interface IRegisterFacade {

	/**
	 *�Ƿ�ע��ɹ�
	 * @author Daoliang Li
	 * @param registerInfo ע����Ϣ
	 * @return �Ƿ�ע��ɹ�
	 */
	public boolean isRegisterSuccess(RegisterInfo registerInfo);
	
}
