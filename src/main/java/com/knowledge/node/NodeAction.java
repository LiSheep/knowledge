package com.knowledge.node;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class NodeAction extends ActionSupport implements ModelDriven<NodeCarsness>{

	private static final long serialVersionUID = 1494801211568261336L;
	private NodeCarsness model;
	private NodeServices nodeServices;
	//add the carsness know node
	public String add() {
		int tmp = nodeServices.add(getModel());
		
		if (1 != tmp) {
			return "redirect";
		}
		
		return "add";
	}
	
	@Override
	public NodeCarsness getModel() {
		if (null == model) {
			model = new NodeCarsness();
		}
		return model;
	}

	public NodeServices getNodeServices() {
		return nodeServices;
	}

	public void setNodeServices(NodeServices nodeServices) {
		this.nodeServices = nodeServices;
	}
}
