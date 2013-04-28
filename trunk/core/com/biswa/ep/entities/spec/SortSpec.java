package com.biswa.ep.entities.spec;

import java.util.LinkedHashMap;

import com.biswa.ep.entities.Attribute;
import com.biswa.ep.entities.ContainerListener;
import com.biswa.ep.entities.PivotContainer;

public class SortSpec extends Spec {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1617921625061798475L;
	private LinkedHashMap<Attribute,Boolean> sortorder = new LinkedHashMap<Attribute,Boolean>();
	public SortSpec(String sinkName){
		super(sinkName);
	}
	public void addSortOrder(Attribute attribute,Boolean order){
		sortorder.put(attribute,order);
	}
	
	@Override
	public void apply(ContainerListener listener) {
		PivotContainer abs = (PivotContainer) listener;
		abs.getFilterAgent(getSinkName()).applySort(sortorder);
	}

}
