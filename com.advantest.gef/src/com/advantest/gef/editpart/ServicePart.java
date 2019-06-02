package com.advantest.gef.editpart;

import java.util.List;

import org.eclipse.draw2d.IFigure;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.editparts.AbstractGraphicalEditPart;

import com.advantest.gef.editpolicies.AppEditLayoutPolicy;
import com.advantest.gef.figure.ServiceFigure;
import com.advantest.gef.model.Service;

public class ServicePart extends AbstractGraphicalEditPart {

	@Override
	protected IFigure createFigure() {
		ServiceFigure figure = new ServiceFigure();
		return figure;	
	}

	@Override
	protected void createEditPolicies() {
		installEditPolicy(EditPolicy.LAYOUT_ROLE, new AppEditLayoutPolicy());
	}
	
	@Override
	protected void refreshVisuals() {
		ServiceFigure figure = (ServiceFigure)getFigure();
		Service model = (Service)getModel();
		
		figure.setName(model.getName());
		figure.setEtage(model.getEtage());
		figure.setLayout(model.getRectangle());
		
		super.refreshVisuals();
	}
	
	@Override
	protected List getModelChildren() {
		return ((Service)getModel()).getChildren();
	}

}
