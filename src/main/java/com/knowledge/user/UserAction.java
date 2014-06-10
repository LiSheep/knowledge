package com.knowledge.user;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.IOUtils;
import org.apache.struts2.ServletActionContext;

import com.knowledge.arc.KnowledgeAction;
import com.knowledge.common.ObjectToJson;
import com.knowledge.timeline.Timeline;
import com.knowledge.timeline.TimelineAsset;
import com.knowledge.timeline.TimelineAssetServices;
import com.knowledge.timeline.TimelineDate;
import com.knowledge.timeline.TimelineDateServices;
import com.knowledge.timeline.TimelineServices;
import com.opensymphony.xwork2.ActionContext;

public class UserAction extends KnowledgeAction<User> {
	
	//TODO : log must be do
//	private static final Logger logger = Logger.getLogger( UserAction.class.getName() );
	/**
	 * User action for process User do
	 */
	private static final long serialVersionUID = 8335062372139836975L;
	
	public String login() throws Exception {
		User user = userServices.findEntity(getModel());
		
		if (null != user) {
			ActionContext.getContext().getSession().put("user", user);
			
			readTimeline(user.getId());
			
			return SUCCESS;
		}
			
		
		return INPUT;
	}
	
	public String register() {
		if (model.getUsername().length() >= Integer.valueOf(getText("username.length.min")) 
				&& model.getUsername().length() <= Integer.valueOf(getText("username.length.max"))) {
			if (model.getUserpass().length() >= Integer.valueOf(getText("userpass.length.min")) 
					&& model.getUserpass().length() <= Integer.valueOf(getText("userpass.length.max"))) {
				if (1 == userServices.add(getModel())) {
					addTimeline();
					readTimeline(getModel().getId());
					
					User user = userServices.findEntity(getModel());
					ActionContext.getContext().getSession().put("user", user);
					
					return SUCCESS;
				} else {
					return INPUT;
				}
			}
		}
		return INPUT;
	}

	/*
	 * 根据用户的id查询与该用户相关的知识点,并把时间轴相关的信息写入以用户id命名的.json文件
	 */
	private void readTimeline(String id) {
		Timeline timeline = timelineServices.findEntityById(id);
		ObjectToJson<Timeline> toJson = new ObjectToJson<Timeline>();
		String path = ServletActionContext.getServletContext().getRealPath("/json") + "/" + getModel().getId() + ".json";
		
		try {
			IOUtils.write("{ \"timeline\" : " + toJson.convertObjectToJson(timeline) + "}", new FileOutputStream(new File(path)));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/*
	 * 向时间轴添加相关内容,添加的内容是以个人的userkey关联到相关的时间轴内容
	 */
	private void addTimeline() {
		Timeline t = new Timeline();
		t.setHeadline(getModel().getUsername() + " 在今天注册了");
		t.setId(UUID.randomUUID().toString());
		t.setText("<h1>欢迎来到XX学习平台</h1>");
		t.setUserKey(getModel().getId());
		
		TimelineDate date = new TimelineDate();
		date.setId(UUID.randomUUID().toString());
		date.setHeadline(getModel().getUsername() + " begin to learn each other");
		date.setHeadlineKey(t.getId());
		date.setText("The first page for your learn that you are joined !");
//		endDate可以为NULL
//		date.setEndDate("2200-00-00");
		date.setAssetKey(UUID.randomUUID().toString());
		
		TimelineAsset asset = new TimelineAsset();
		asset.setId(date.getAssetKey());
		asset.setCaption("a learning way -> learn by web");
		asset.setCredit("good website");
		//http://localhost:8080/know url
		HttpServletRequest request = ServletActionContext.getRequest();
		String url = request.getScheme() + "://"
				+ request.getServerName() + ":" + request.getServerPort()
				+ request.getContextPath() + "/";
		asset.setMedia(url);
		
		timelineServices.add(t);
		timelineDateServices.add(date);
		timelineAssetServices.add(asset);
	}
	
	private User model;
	
	@Override
	public User getModel() {
		if (null == model) {
			model = new User();
		}
		return model;
	}
	
	private UserServices userServices;

	public UserServices getUserServices() {
		return userServices;
	}

	public void setUserServices(UserServices userServices) {
		this.userServices = userServices;
	}
	
	private TimelineServices timelineServices;

	public TimelineServices getTimelineServices() {
		return timelineServices;
	}

	public void setTimelineServices(TimelineServices timelineServices) {
		this.timelineServices = timelineServices;
	}
	
	private TimelineDateServices timelineDateServices;

	public TimelineDateServices getTimelineDateServices() {
		return timelineDateServices;
	}

	public void setTimelineDateServices(TimelineDateServices timelineDateServices) {
		this.timelineDateServices = timelineDateServices;
	}
	
	private TimelineAssetServices timelineAssetServices;

	public TimelineAssetServices getTimelineAssetServices() {
		return timelineAssetServices;
	}

	public void setTimelineAssetServices(TimelineAssetServices timelineAssetServices) {
		this.timelineAssetServices = timelineAssetServices;
	}
}
