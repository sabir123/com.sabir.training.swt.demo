package com.sabir.training.swt.demo.examples;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FontDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class FontDialogExample {

  Display d;

  Shell s;

  FontDialogExample() {
    d = new Display();
    s = new Shell(d);
    s.setSize(400, 400);
    
    s.setText("A FontDialog Example");
    s.setLayout(new FillLayout(SWT.VERTICAL));
    final Text t = new Text(s, SWT.BORDER | SWT.MULTI);
    t.setText("Press Change font to see this change");
    final Button b = new Button(s, SWT.PUSH | SWT.BORDER);
    b.setText("Change Font");
    b.addSelectionListener(new SelectionAdapter() {
      public void widgetSelected(SelectionEvent e) {
        FontDialog fd = new FontDialog(s, SWT.NONE);
        fd.setText("Select Font");
        fd.setRGB(new RGB(0, 0, 255));
        FontData defaultFont = new FontData("Courier", 10, SWT.BOLD);
        fd.setFontData(defaultFont);
        FontData newFont = fd.open();
        if (newFont == null)
          return;
        t.setFont(new Font(d, newFont));
        t.setForeground(new Color(d, fd.getRGB()));
      }
    });
    s.open();

    while (!s.isDisposed()) {
      if (!d.readAndDispatch())
        d.sleep();
    }
    d.dispose();
  }

  public static void main(String[] argv) {
    new FontDialogExample();
  }

}
