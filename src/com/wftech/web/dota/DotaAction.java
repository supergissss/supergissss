package com.wftech.web.dota;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.http.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.wftech.common.DataTable;
import com.wftech.common.DataTableColumn;
import com.wftech.common.TableUtils;
import com.wftech.common.TypeUtils;
import com.wftech.domain.common.Theme;
import com.wftech.service.common.IGetTableFacade;
import com.wftech.service.common.IGetThemeFacade;

/**
 * @author ws
 *
 */
@Controller
@RequestMapping("dota")
public class DotaAction implements EnvironmentAware{
	
	@Autowired
	IGetTableFacade getTableFacade;
	
	@Autowired
	IGetThemeFacade getThemeFacade;
	
	Environment env;
	
	@RequestMapping("index")
	public String index(HttpServletRequest request,Model model){
		Object obj= request.getParameter("page");
		if(obj!=null){
			model.addAttribute("page",obj);
		}
		return "dota/dota";
	}
	
	/**
	 *获取DataTable
	 * @author Daoliang Li
	 * @param request 请求
	 * @param response 相应
	 * @param dataTable datable数据
	 * @return 页面
	 */
	@RequestMapping("getDotaTable")
	public String getDotaTable(HttpServletRequest request,HttpServletResponse response,DataTable dataTable){
		//String[][] value = {{"主题1","丽丽","8/10","liu 2012/12"},{"主题2","天天","1/3","liu 2012/12"}};
		String[][] value = getTableFacade.getTableData(TableUtils.THEME,TypeUtils.DOTA,dataTable.getLength(),dataTable.getStart());
		int length = getTableFacade.getTableDataNum(TableUtils.THEME,TypeUtils.DOTA);
		String[] column = DataTableColumn.getColumn(TableUtils.THEME,TypeUtils.DOTA);
		dataTable.getTable(request,response,column,value,length);
		return "dota/dota";
	}
	
	@RequestMapping("theme")
	public String theme(HttpServletRequest request,Theme theme,Model model){
		int themeid = theme.getThemeid();
		boolean tag = getThemeFacade.hasTheme(themeid);
		model.addAttribute("themeid",themeid);
		model.addAttribute("page",request.getParameter("page"));
		if(tag){
		    return "common/theme";
		}else{
			return "common/themenotexist";
		}
	}
	
	@RequestMapping("getTheme")
	public String getTheme(HttpServletRequest request,HttpServletResponse response,DataTable dataTable,Theme theme,Model model){
		int themeid = theme.getThemeid();
		String[][] value = getTableFacade.getTableData(TableUtils.POSTANDUSER,themeid,dataTable.getLength(),dataTable.getStart());
		int length = getTableFacade.getTableDataNum(TableUtils.POST,themeid);
		String[] column = DataTableColumn.getColumn(TableUtils.POSTANDUSER, TypeUtils.DOTA);
		dataTable.getTable(request,response,column,value,length);
		return "common/theme";
	}
	
	@Override
	public void setEnvironment(Environment env) {
		// TODO Auto-generated method stub
		this.env = env;
	}
	
	@RequestMapping("forbid")
	public String forbid(){
		return "dota/forbid";
	}
}
