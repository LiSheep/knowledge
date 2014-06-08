package com.knowledge.compute;

import com.knowledge.arc.KnowledgeAction;

public class ComputeAction extends KnowledgeAction<Compute> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2127606941201251302L;

	public String compute() {
		computeServices.compute();
		
		return SUCCESS;
	}
	@Override
	public Compute getModel() {
		if (null == model) {
			model = new Compute();
		}
		
		return model;
	}
	
	private ComputeServices computeServices;

	public ComputeServices getComputeServices() {
		return computeServices;
	}

	public void setComputeServices(ComputeServices computeServices) {
		this.computeServices = computeServices;
	}
}
