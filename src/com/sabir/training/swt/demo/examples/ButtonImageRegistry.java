package com.sabir.training.swt.demo.examples;

/*
 * Provide text that will be spoken for an image Button.
 *
 * For a list of all SWT example snippets see
 * http://www.eclipse.org/swt/snippets/
 */
import org.eclipse.swt.*;
import org.eclipse.swt.accessibility.*;
import org.eclipse.swt.graphics.*;
import org.eclipse.swt.layout.*;
import org.eclipse.swt.widgets.*;

public class ButtonImageRegistry {

public static void main (String[] args) {
	Display display = new Display( );
	Shell shell = new Shell (display);
	shell.setText("Button Image Registry Example");
	shell.setLayout (new GridLayout ());
	Image image = new Image (display, ButtonImageRegistry.class.getResourceAsStream ("eclipse16.png"));

	Button button1 = new Button (shell, SWT.PUSH);
	button1.setText ("&Typical button");

	Button button2 = new Button (shell, SWT.PUSH);
	button2.setImage (image);
	button2.getAccessible ().addAccessibleListener (new AccessibleAdapter() {
		@Override
		public void getName (AccessibleEvent e) {
			e.result = "Eclipse logo";
		}
	});

	shell.pack ();
	shell.open ();
	while (!shell.isDisposed ()) {
		if (!display.readAndDispatch ()) display.sleep ();
	}
	image.dispose ();
	display.dispose ();
}
}
