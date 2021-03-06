package com.sabir.training.swt.demo.examples;

import org.eclipse.swt.SWT;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.DragSource;
import org.eclipse.swt.dnd.DragSourceAdapter;
import org.eclipse.swt.dnd.DragSourceEvent;
import org.eclipse.swt.dnd.DropTarget;
import org.eclipse.swt.dnd.DropTargetAdapter;
import org.eclipse.swt.dnd.DropTargetEvent;
import org.eclipse.swt.dnd.TextTransfer;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;

public class DragAndDropExample {
    public static void main(String[] args) {

    Display display = new Display();
    final Shell shell = new Shell(display);
    shell.setLayout(new FillLayout());
	shell.setText("Drag and Drop");
    final Tree tree = new Tree(shell, SWT.BORDER);
    TreeItem item1 = new TreeItem(tree, SWT.NONE);
    item1.setText("Hello 1");
    TreeItem item2 = new TreeItem(tree, SWT.NONE);
    item2.setText("Hello 2");
    TreeItem item3 = new TreeItem(tree, SWT.NONE);
    item3.setText("Hello 3");
    TreeItem item4 = new TreeItem(tree, SWT.NONE);
    item4.setText("Hello 4");

    DragSource ds = new DragSource(tree, DND.DROP_MOVE);
    ds.setTransfer(new Transfer[] { TextTransfer.getInstance() });
    ds.addDragListener(new DragSourceAdapter() {
    public void dragSetData(DragSourceEvent event) {
    event.data = tree.getSelection()[0].getText();
      }
    });
    final Text text = new Text(shell, SWT.BORDER);
    DropTarget dt = new DropTarget(text, DND.DROP_MOVE);
    
    dt.setTransfer(new Transfer[] { TextTransfer.getInstance() });
    dt.addDropListener(new DropTargetAdapter() {
      public void drop(DropTargetEvent event) {
      text.setText((String) event.data);
      }
    });
    shell.setSize(250, 100);
    shell.open();
    while (!shell.isDisposed()) {
      if (!display.readAndDispatch())
        display.sleep();
    }
    display.dispose();
  }
}



 
   