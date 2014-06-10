package net.onefang.toyboxInstaller;

import android.app.*;
import android.os.*;
import android.view.*;
import android.widget.*;
import java.lang.System.*;

public class MainActivity extends Activity
{
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

	TextView version = (TextView) findViewById(R.id.version);
	String   VERSION = getString(R.string.version);
	TextView cpu = (TextView) findViewById(R.id.cpu);
	String   CPU = getString(R.string.cpu);
	TextView path = (TextView) findViewById(R.id.path);
	String   PATH = getString(R.string.path);
	String   pathSep = java.lang.System.getProperty("path.separator");
	TextView folder = (TextView) findViewById(R.id.folder);
	String   FOLDER = getString(R.string.folder);

	version.setText(VERSION + " " + "unknown" + ".\n");
	cpu.setText(CPU + " " + java.lang.System.getProperty("os.arch") + ".\n");
	path.setText(PATH + " " + java.lang.System.getenv("PATH") + "\n");
	folder.setText(FOLDER + " " + "" + "\n");
    }

    public void installToybox(View view)
    {
    }
}
