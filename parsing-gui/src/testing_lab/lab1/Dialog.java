package testing_lab.lab1;

/*******************************************************************************
 * Copyright (c) 2000, 2004 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
//package org.eclipse.swt.snippets;

/*
 * create a dialog Shell and prompt for a text string
 *
 * For a list of all SWT example snippets see
 * http://www.eclipse.org/swt/snippets/
 */
import org.eclipse.swt.*;
import org.eclipse.swt.events.*;
import org.eclipse.swt.layout.*;
import org.eclipse.swt.widgets.*;

public class Dialog {

public static void main (String [] args) {
	Display display = new Display ();
	final Shell shell = new Shell (display);
	shell.setText("Shell");
	FillLayout fillLayout = new FillLayout();
	fillLayout.marginWidth = 10;
	fillLayout.marginHeight = 10;
	shell.setLayout(fillLayout);

	Button open = new Button (shell, SWT.PUSH);
	open.setText ("Prompt for a String");
	open.addSelectionListener (new SelectionAdapter () {
		public void widgetSelected (SelectionEvent e) {
			final Shell dialog = new Shell (shell, SWT.DIALOG_TRIM | SWT.APPLICATION_MODAL);
			dialog.setText("Dialog Shell");
			FormLayout formLayout = new FormLayout ();
			formLayout.marginWidth = 10;
			formLayout.marginHeight = 10;
			formLayout.spacing = 10;
			dialog.setLayout (formLayout);

			Label label = new Label (dialog, SWT.NONE);
			label.setText ("Type a String:");
			FormData data = new FormData ();
			label.setLayoutData (data);

			Button cancel = new Button (dialog, SWT.PUSH);
			cancel.setText ("Cancel");
			data = new FormData ();
			data.width = 60;
			data.right = new FormAttachment (100, 0);
			data.bottom = new FormAttachment (100, 0);
			cancel.setLayoutData (data);
			cancel.addSelectionListener (new SelectionAdapter () {
				public void widgetSelected (SelectionEvent e) {
					System.out.println("User cancelled dialog");
					dialog.close ();
				}
			});

			final Text text = new Text (dialog, SWT.BORDER);
			data = new FormData ();
			data.width = 200;
			data.left = new FormAttachment (label, 0, SWT.DEFAULT);
			data.right = new FormAttachment (100, 0);
			data.top = new FormAttachment (label, 0, SWT.CENTER);
			data.bottom = new FormAttachment (cancel, 0, SWT.DEFAULT);
			text.setLayoutData (data);

			Button ok = new Button (dialog, SWT.PUSH);
			ok.setText ("OK");
			data = new FormData ();
			data.width = 60;
			data.right = new FormAttachment (cancel, 0, SWT.DEFAULT);
			data.bottom = new FormAttachment (100, 0);
			ok.setLayoutData (data);
			ok.addSelectionListener (new SelectionAdapter () {
				public void widgetSelected (SelectionEvent e) {
					System.out.println ("User typed: " + text.getText ());
					dialog.close ();
				}
			});

			dialog.setDefaultButton (ok);
			dialog.pack ();
			dialog.open ();
		}
	});
	shell.pack ();
	shell.open ();
	
	while (!shell.isDisposed ()) {
		if (!display.readAndDispatch ()) display.sleep ();
	}
	display.dispose ();
}
} 


