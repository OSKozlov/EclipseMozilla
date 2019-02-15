package com.luxoft.newbrowser;

import java.io.File;

import org.eclipse.swt.SWT;
import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class Newbrowser {
	
    public static void main(String a[]) {
        Display display = new Display();
        Shell shell = new Shell(display);
        /* Composite controls = new Composite(shell, SWT.NONE); */
        shell.setText("Browser");
        String pathToXulrunner = "C://Program Files (x86)/Mozilla XULRunner/";

        System.setProperty("org.eclipse.swt.browser.XULRunnerPath", pathToXulrunner);

        System.setProperty("org.eclipse.swt.browser.MOZ_PROFILE_PATH", new File("").getAbsolutePath());
        Browser browser = new Browser(shell, SWT.MOZILLA);
        shell.setLayout(new FillLayout());
        shell.open();

        FormData data = new FormData();

        data.top = new FormAttachment(0, 0);
        data.bottom = new FormAttachment(100, 0);
        data.left = new FormAttachment(0, 0);
        data.right = new FormAttachment(100, 0);
        browser.setLayoutData(data);
        browser.setUrl("www.google.com");

        // Set up the event loop.

        while (!shell.isDisposed()) {
            if (!display.readAndDispatch()) {
                // If no more entries in the event queue
                display.sleep();
            }
        }
        display.dispose();
    }
}