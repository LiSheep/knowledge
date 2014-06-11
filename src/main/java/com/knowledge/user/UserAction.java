package com.knowledge.user;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.IOUtils;
import org.apache.struts2.ServletActionContext;

import com.knowledge.arc.KnowledgeAction;
import com.knowledge.common.ErrorInfo;
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
	
	HashMap<String, String> myerrors;

	public HashMap<String, String> getMyerrors() {
		if(myerrors == null){
			myerrors = new HashMap<String, String>();
		}
		return myerrors;
	}

	public void setMyerrors(HashMap<String, String> myerrors) {
		this.myerrors = myerrors;
	}

	public String login() throws Exception {
		
		User hadLoginUser = userServices.findUserSession();
		if(hadLoginUser != null){	//已登录
			return SUCCESS;
		}
		User user = userServices.findEntity(getModel());
		if (null != user) {
			ActionContext.getContext().getSession().put("user", user);
			readTimeline(user.getId());
			return SUCCESS;
		}
			
		getMyerrors().put("login", "您未注册或用户名、密码错误。");
		return INPUT;
	}
	
	public String register() {
		if(getModel().getUsername().length() < Integer.valueOf(getText("username.length.min"))
				|| getModel().getUsername().length() > Integer.valueOf(getText("username.length.max")) ) {
			//用户名不符合要求。
			getMyerrors().put("register", "用户名需要大于 " + Integer.valueOf(getText("username.length.min")) + " 个字符");
			return INPUT;
		}
		if(getModel().getUserpass().length() < Integer.valueOf(getText("userpass.length.min")) 
				|| getModel().getUsername().length() > Integer.valueOf(getText("username.length.max"))){
			//密码不符合要求
			getMyerrors().put("register", "密码需要大于 " + Integer.valueOf(getText("userpass.length.min")) + " 个字符");
			return INPUT;
		}
		if(userServices.add(getModel()) != 1){		//注册失败
			getMyerrors().put("register", "用户名已存在");
			return INPUT;
		}
		//注册成功,写入session
		ActionContext.getContext().getSession().put("user", getModel());
		//添加时间轴
		addTimeline();
		readTimeline(getModel().getId());
		
		return SUCCESS;
		
//		
//		if (model.getUsername().length() >= Integer.valueOf(getText("username.length.min")) 
//				&& model.getUsername().length() <= Integer.valueOf(getText("username.length.max"))) {
//			
//			if (model.getUserpass().length() >= Integer.valueOf(getText("userpass.length.min")) 
//					&& model.getUserpass().length() <= Integer.valueOf(getText("userpass.length.max"))) {
//				
//				if (1 == userServices.add(getModel())) {
//					addTimeline();
//					readTimeline(getModel().getId());
//					
//					User user = userServices.findEntity(getModel());
//					ActionContext.getContext().getSession().put("user", user);
//					
//					return SUCCESS;
//				} else {
//					if(model.getUsername().length() < Integer.valueOf(getText("username.length.min"))){
//						myerrors.put("register", "用户名需要大于 " + Integer.valueOf(getText("username.length.min")) + " 个字符"); 
//					}
//					if(model.getUserpass().length() < Integer.valueOf(getText("userpass.length.min"))){
//						myerrors.put("register", "密码需要大于 " + Integer.valueOf(getText("userpass.length.min")) + " 个字符");
//					}
//					return INPUT;
//				}
//			}
//		}
//		return INPUT;
	}

	/*
	 * 根据用户的id查询与该用户相关的知识点,并把时间轴相关的信息写入以用户id命名的.json文件
	 */
	private void readTimeline(String id) {
		Timeline timeline = timelineServices.findEntityById(id);
		ObjectToJson<Timeline> toJson = new ObjectToJson<Timeline>();
		String path = ServletActionContext.getServletContext().getRealPath("/json") + "/" + id + ".json";
		
		try {
			File tmpFile = new File(path);
			if (tmpFile.exists() && tmpFile.isFile()) {
				tmpFile.delete();
			}
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
		t.setText("<h3>知识学习和过程评价系统欢迎您！</h3>");
		t.setUserKey(getModel().getId());
		
		TimelineDate date = new TimelineDate();
		date.setId(UUID.randomUUID().toString());
		date.setHeadline(getModel().getUsername() + " 从今天开始学习吧！");
		date.setHeadlineKey(t.getId());
		date.setText("体验新的学习方式!");
//		endDate可以为NULL
//		date.setEndDate("2200-00-00");
		date.setAssetKey(UUID.randomUUID().toString());
		
		TimelineAsset asset = new TimelineAsset();
		asset.setId(date.getAssetKey());
		asset.setCaption("");
		asset.setCredit("知识学习和过程评价系统");
		//http://localhost:8080/know url
		HttpServletRequest request = ServletActionContext.getRequest();
		String url = request.getScheme() + "://"
				+ request.getServerName() + ":" + request.getServerPort()
				+ request.getContextPath() + "/plguin/know/image/index.png";
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
