package com.knowledge.page;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import com.knowledge.arc.KnowledgeEntity;

@SuppressWarnings("serial")
public class PageTag<T extends KnowledgeEntity> extends TagSupport {
	private String url;
	private Page<T> page;
	private PageComponent<T> component;
	
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
	public Page<T> getPage() {
		return page;
	}

	public void setPage(Page<T> page) {
		this.page = page;
	}

	@SuppressWarnings("unchecked")
	@Override
	public int doStartTag() throws JspException {
		try {
			HttpServletRequest request = (HttpServletRequest)pageContext.getRequest();
			String url = request.getContextPath() + this.url;
			
//			component = new PageComponent<T>((Page<T>)request.getAttribute("page"));
			component = new PageComponent<T>(getPage());
			component.setUrl(url);
			
			pageContext.getOut().print(component.getPageHTML());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return SKIP_BODY;
	}
}
