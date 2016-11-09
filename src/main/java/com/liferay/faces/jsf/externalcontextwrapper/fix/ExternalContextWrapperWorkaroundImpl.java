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
import javax.faces.context.ExternalContextWrapper;


/**
 * @author  Kyle Stiemann
 */
public class ExternalContextWrapperWorkaroundImpl extends ExternalContextWrapper {

	private ExternalContext externalContext;

	public ExternalContextWrapperWorkaroundImpl(ExternalContext externalContext) {
		this.externalContext = externalContext;
	}

	@Override
	public int getSessionMaxInactiveInterval() {

		UnsupportedOperationException savedUnsupportedOperationException;

		try {
			return super.getSessionMaxInactiveInterval();
		}
		catch (UnsupportedOperationException e) {
			savedUnsupportedOperationException = e;
		}

		try {
			return externalContext.getSessionMaxInactiveInterval();
		}
		catch (UnsupportedOperationException e) {
			savedUnsupportedOperationException = e;
		}

		ExternalContext tempExternalContext = externalContext;

		while (tempExternalContext instanceof ExternalContextWrapper) {

			tempExternalContext = ((ExternalContextWrapper) tempExternalContext).getWrapped();

			try {
				return tempExternalContext.getSessionMaxInactiveInterval();
			}
			catch (UnsupportedOperationException e) {
				savedUnsupportedOperationException = e;
			}
		}

		throw savedUnsupportedOperationException;
	}

	@Override
	public ExternalContext getWrapped() {
		return externalContext;
	}

	@Override
	public boolean isSecure() {

		UnsupportedOperationException savedUnsupportedOperationException;

		try {
			return super.isSecure();
		}
		catch (UnsupportedOperationException e) {
			savedUnsupportedOperationException = e;
		}

		try {
			return externalContext.isSecure();
		}
		catch (UnsupportedOperationException e) {
			savedUnsupportedOperationException = e;
		}

		ExternalContext tempExternalContext = externalContext;

		while (tempExternalContext instanceof ExternalContextWrapper) {

			tempExternalContext = ((ExternalContextWrapper) tempExternalContext).getWrapped();

			try {
				return tempExternalContext.isSecure();
			}
			catch (UnsupportedOperationException e) {
				savedUnsupportedOperationException = e;
			}
		}

		throw savedUnsupportedOperationException;
	}

	@Override
	public void setSessionMaxInactiveInterval(int i) {

		UnsupportedOperationException savedUnsupportedOperationException;

		try {
			super.setSessionMaxInactiveInterval(i);

			return;
		}
		catch (UnsupportedOperationException e) {
			savedUnsupportedOperationException = e;
		}

		try {
			externalContext.setSessionMaxInactiveInterval(i);

			return;
		}
		catch (UnsupportedOperationException e) {
			savedUnsupportedOperationException = e;
		}

		ExternalContext tempExternalContext = externalContext;

		while (tempExternalContext instanceof ExternalContextWrapper) {

			tempExternalContext = ((ExternalContextWrapper) tempExternalContext).getWrapped();

			try {
				tempExternalContext.setSessionMaxInactiveInterval(i);

				return;
			}
			catch (UnsupportedOperationException e) {
				savedUnsupportedOperationException = e;
			}
		}

		throw savedUnsupportedOperationException;
	}
}
