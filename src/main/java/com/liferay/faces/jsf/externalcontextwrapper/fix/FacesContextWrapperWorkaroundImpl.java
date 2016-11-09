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

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.context.FacesContextWrapper;


/**
 * @author  Kyle Stiemann
 */
public class FacesContextWrapperWorkaroundImpl extends FacesContextWrapper {

	private FacesContext facesContext;
	private ExternalContext externalContext;

	public FacesContextWrapperWorkaroundImpl(FacesContext facesContext) {
		this.facesContext = facesContext;
	}

	@Override
	public ExternalContext getExternalContext() {

		if (externalContext == null) {
			externalContext = new ExternalContextWrapperWorkaroundImpl(facesContext.getExternalContext());
		}

		return externalContext;
	}

	@Override
	public FacesContext getWrapped() {
		return facesContext;
	}

	@Override
	public void release() {

		externalContext = null;
		super.release();
	}
}
