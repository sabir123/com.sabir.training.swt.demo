package com.sabir.training.swt.demo.examples;

import static org.eclipse.swt.events.SelectionListener.widgetSelectedAdapter;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.RowData;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class LabelExample {

	public static void main(String[] args) {

		Display display = new Display ();
		Shell shell = new Shell (display);
		shell.setText("Label");
		Label label = new Label(shell, SWT.SHADOW_OUT);
		label.setText("Sabir");


		
		Label labelSeperator = new Label(shell, SWT.SEPARATOR);
		labelSeperator.setLayoutData(new RowData (100, SWT.DEFAULT));
		Button ok = new Button (shell, SWT.PUSH);
		ok.setText ("OK");
		ok.addSelectionListener(widgetSelectedAdapter(e -> System.out.println(label.getText())));
		Button cancel = new Button (shell, SWT.PUSH);
		cancel.setText ("Cancel");
		cancel.addSelectionListener(widgetSelectedAdapter(e -> System.out.println("Cancel")));
		shell.setDefaultButton (cancel);
		shell.setLayout (new RowLayout ());
		shell.pack ();
		shell.open ();
		while (!shell.isDisposed ()) {
			if (!display.readAndDispatch ()) display.sleep ();
		}
		display.dispose ();
	}

}
