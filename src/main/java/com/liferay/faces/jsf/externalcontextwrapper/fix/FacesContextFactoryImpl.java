/**
 * Copyright (c) 2000-2016 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */
package com.liferay.faces.jsf.externalcontextwrapper.fix;

import javax.faces.FacesException;
import javax.faces.context.FacesContext;
import javax.faces.context.FacesContextFactory;
import javax.faces.lifecycle.Lifecycle;


/**
 * @author  Kyle Stiemann
 */
public class FacesContextFactoryImpl extends FacesContextFactory {

	private FacesContextFactory facesContextFactory;

	public FacesContextFactoryImpl(FacesContextFactory facesContextFactory) {
		this.facesContextFactory = facesContextFactory;
	}

	@Override
	public FacesContext getFacesContext(Object context, Object request, Object response, Lifecycle lifecycle)
		throws FacesException {
		return new FacesContextWrapperWorkaroundImpl(facesContextFactory.getFacesContext(context, request, response,
					lifecycle));
	}

	@Override
	public FacesContextFactory getWrapped() {
		return facesContextFactory;
	}
}
