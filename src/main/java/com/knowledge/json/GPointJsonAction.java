package com.knowledge.json;

import java.io.IOException;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.knowledge.arc.KnowledgeAction;
import com.knowledge.common.ObjectToJson;
import com.knowledge.point.GeneralPoint;
import com.knowledge.point.GeneralPointServices;

public class GPointJsonAction extends KnowledgeAction<GeneralPoint>{
	
	/**
	 * 吧GPoint转换成知识点显示结构-->首页
	 */
	private static final long serialVersionUID = -7774313761514551953L;

	// 列出知识体系下的粗知识点,处理ajax请求,根据Complexity
	public void listByTypeCompelxity() {
		ObjectToJson<Charts> toJson = new ObjectToJson<Charts>();
		int type = getModel().getPointType();
		points = generalPointServices.findJsonByComplexityType(type);
		json = toJson.convertListToJson(points);
		System.out.println(json);
		try {
			ServletActionContext.getResponse().getWriter().write(json);
			ServletActionContext.getResponse().getWriter().flush();
			ServletActionContext.getResponse().getWriter().close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	// 列出知识体系下的粗知识点,处理ajax请求,根据Importance
	public void listByTypeImportance() {
		ObjectToJson<Charts> toJson = new ObjectToJson<Charts>();
		int type = getModel().getPointType();
		points = generalPointServices.findJsonByImportanceType(type);
		json = toJson.convertListToJson(points);
		System.out.println(json);
		try {
			ServletActionContext.getResponse().getWriter().write(json);
			ServletActionContext.getResponse().getWriter().flush();
			ServletActionContext.getResponse().getWriter().close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	@Override
	public GeneralPoint getModel() {
		if (this.model == null) {
			this.model = new GeneralPoint();
		}
		
		return this.model;
	}
	private List<Charts> points;
	private GeneralPointServices generalPointServices;
	public List<Charts> getPoints() {
		return points;
	}

	public void setPoints(List<Charts> points) {
		this.points = points;
	}

	public GeneralPointServices getGeneralPointServices() {
		return generalPointServices;
	}

	public void setGeneralPointServices(GeneralPointServices generalPointServices) {
		this.generalPointServices = generalPointServices;
	}
	
	private String json;
	public String getJson() {
		return json;
	}

	public void setJson(String json) {
		this.json = json;
	}
}
