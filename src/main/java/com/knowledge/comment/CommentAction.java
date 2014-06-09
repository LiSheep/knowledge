package com.knowledge.comment;

import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ExecutionException;

import org.apache.struts2.ServletActionContext;

import com.knowledge.arc.KnowledgeAction;
import com.knowledge.dictionary.Dictionary;
import com.knowledge.dictionary.DictionaryServices;
import com.knowledge.point.GeneralPoint;
import com.knowledge.point.GeneralPointServices;
import com.knowledge.timeline.Timeline;
import com.knowledge.timeline.TimelineAsset;
import com.knowledge.timeline.TimelineAssetServices;
import com.knowledge.timeline.TimelineDate;
import com.knowledge.timeline.TimelineDateServices;
import com.knowledge.timeline.TimelineServices;
import com.knowledge.user.User;
import com.knowledge.user.UserServices;
import com.opensymphony.xwork2.ActionContext;

/*
 * Comment Action: 2014/06/08
 */
public class CommentAction extends KnowledgeAction<Comment>{

	private static final long serialVersionUID = 8588855865774891306L;
	private CommentServices commentServices;
	private GeneralPointServices generalPointServices;
	private DictionaryServices dictionaryServices;
	private UserServices userServices;
	
	private TimelineServices timelineServices;
	private TimelineDateServices timelineDateServices;
	private TimelineAssetServices timelineAssetServices;
	
	public CommentAction(){
		super();
	}
	
	//显示General Point的list
	public String listGPoint(){
		GeneralPoint gPoint = generalPointServices.findEntityById(getKey());		//key为generalPoint
		if(gPoint == null)
			return "tomain";
		getModel().setGeneralPoint(gPoint);
		commentServices.listByGeneralPointId(getPage(), getKey());
		return "list";
	}

	public String input(){
		setSessions();
		return "input";
	}
	
	public String add(){	//TODO:还需要添加防止重复提交功能
		commentServices.add(getModel());
		return "list";
	}
	
	private void insertOrUpdateComment(){
		if(getModel().getId() == null || getModel().getId().equals("") ){
			commentServices.add(getModel());
		}
		else {
			commentServices.updateNote(getModel());
		}
	}
	
	//提交学习笔记表单 
	public String subLearn(){
//		GeneralPoint gPoint = generalPointServices.findEntityById(getModel().getGeneralPoint().getId());
//		if(gPoint == null){
//			return "tolist";
//		}
//		getModel().setGeneralPoint(gPoint);
		User user = (User)ActionContext.getContext().getSession().get("user");
		getModel().setUser(user);
		
		insertOrUpdateComment();
		return "tolearn";
	}
	 
	//学习笔记单击完成后，进入评论页面
	public String finishLearn(){
		setSessions();	//TODO:如果函数改了，记得改这哦	ltc:2014/06/07
		
		User user = (User)ActionContext.getContext().getSession().get("user");
		getModel().setUser(user);
		insertOrUpdateComment();	//保存更改
		
		this.model = commentServices.findEntityById(getModel().getId());
		if(this.model == null){
			return "error";
		}
//		if(getModel().getComment() == null || getModel().getComment().equals(""))	//评论为空才添加timline，因为那说明他第一次完成了知识点
//			addTimeline();	
		return "tofinish";
	}
	
	public String submit(){
		if(commentServices.updateComment(getModel()) == 0){
			return "error";
		}
		return "tolist";
	}
	
	public String showNote(){
		String commentId = getKey();	//comment id
		//TODO;	感觉将key强制定为该action的id， 其他的则全部用model传值会好点。		-ltc: 2014/06/08
		if(commentId == null || commentId.equals("")){
			return "error";
		}
		this.model = commentServices.findEntityById(getKey());
		if(this.model == null)
			return "error";
		getModel().setUser((User)ActionContext.getContext().getSession().get("user"));
		return "shownote";
	}
	
	public String toLearn(){
		User user = (User)ActionContext.getContext().getSession().get("user");
		this.model = commentServices.findEntityByGPointIdAndUserId(getKey(), user.getId());	//key为general point
		
		getModel().setGeneralPoint(generalPointServices.findEntityById(getKey()));
		getModel().setUser((User)ActionContext.getContext().getSession().get("user"));
		//TODO: sql 语句用太多啦。到时候再改吧。。。 -ltc 2014-06-07
		return "note";
	}
	
	private void addTimeline() {
		Timeline t = new Timeline();
		User user = (User)ActionContext.getContext().getSession().get("user");
		t.setHeadline(user.getUsername() + " 完成了新知识点");
		t.setId(UUID.randomUUID().toString());
		t.setText("<h1>完成了一个新知识点</h1>");
		t.setUserKey(getModel().getId());
		
		TimelineDate date = new TimelineDate();
		date.setId(UUID.randomUUID().toString());
		date.setHeadline(user.getUsername() + " 喵了个咪");
		date.setHeadlineKey(t.getId());
		date.setText("喵喵喵！");
		date.setEndDate(new Date().toString());
		date.setAssetKey(UUID.randomUUID().toString());
		
		TimelineAsset asset = new TimelineAsset();
		asset.setId(date.getAssetKey());
		asset.setCaption("a learning way -> learn by web");
		asset.setCredit("good website");
		asset.setMedia(ServletActionContext.getRequest().getContextPath() + "showNoteComment?key=" + getModel().getId());
		
		timelineServices.add(t);
		timelineDateServices.add(date);
		timelineAssetServices.add(asset);
	}
	
	//get & set method
	public CommentServices getCommentServices() {
		return commentServices;
	}

	public void setCommentServices(CommentServices commentServices) {
		this.commentServices = commentServices;
	}

	public DictionaryServices getDictionaryServices() {
		return dictionaryServices;
	}

	public void setDictionaryServices(DictionaryServices dictionaryServices) {
		this.dictionaryServices = dictionaryServices;
	}
	
	@Override
	public Comment getModel() {
		if (null == model) {
			model = new Comment();
		}
		return model;
	}
	
	public GeneralPointServices getGeneralPointServices() {
		return generalPointServices;
	}

	public void setGeneralPointServices(GeneralPointServices generalPointServices) {
		this.generalPointServices = generalPointServices;
	}

	public UserServices getUserServices() {
		return userServices;
	}

	public void setUserServices(UserServices userServices) {
		this.userServices = userServices;
	}
	
	public TimelineServices getTimelineServices() {
		return timelineServices;
	}

	public void setTimelineServices(TimelineServices timelineServices) {
		this.timelineServices = timelineServices;
	}

	public TimelineDateServices getTimelineDateServices() {
		return timelineDateServices;
	}

	public void setTimelineDateServices(TimelineDateServices timelineDateServices) {
		this.timelineDateServices = timelineDateServices;
	}

	public TimelineAssetServices getTimelineAssetServices() {
		return timelineAssetServices;
	}

	public void setTimelineAssetServices(TimelineAssetServices timelineAssetServices) {
		this.timelineAssetServices = timelineAssetServices;
	}

	public void setSessions() {
		List<Dictionary> dicImportance = null;
		List<Dictionary> dicComplexity = null;
		try {
//			dicImportance = dictionaryServices.findLabels(Integer.valueOf(getText("FieldImportance.fieldCode")));
//			dicComplexity = dictionaryServices.findLabels(Integer.valueOf(getText("FieldComplexity.fieldCode")));
			dicImportance = dictionaryServices.findLabels(Integer.valueOf(3));
			dicComplexity = dictionaryServices.findLabels(Integer.valueOf(4));
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ActionContext.getContext().getSession().put("pointImportance", dicImportance);
		ActionContext.getContext().getSession().put("pointComplexity", dicComplexity);
	}
}
