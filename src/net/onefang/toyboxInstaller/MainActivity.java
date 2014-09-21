package net.onefang.toyboxInstaller;

import android.app.*;
import android.os.*;
import android.view.*;
import android.widget.*;
import java.lang.System.*;
import android.speech.*;

public class MainActivity extends Activity implements AdapterView.OnItemSelectedListener
{
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

	TextView version = (TextView) findViewById(R.id.version);
	String   VERSION = getString(R.string.version);
	Spinner  versions = (Spinner) findViewById(R.id.versions);
	ArrayAdapter<CharSequence> VERSIONS = ArrayAdapter.createFromResource(this, R.array.versions, android.R.layout.simple_spinner_item);
	TextView cpu = (TextView) findViewById(R.id.cpu);
	String   CPU = getString(R.string.cpu);
	TextView path = (TextView) findViewById(R.id.path);
	String   PATH = getString(R.string.path);
	Spinner  paths = (Spinner) findViewById(R.id.paths);
	ArrayAdapter<String> PATHS;
	String   pathSep = java.lang.System.getProperty("path.separator");
	TextView folder = (TextView) findViewById(R.id.folder);
	String   FOLDER = getString(R.string.folder);
	TextView source = (TextView) findViewById(R.id.source);
	String   SOURCE = getString(R.string.source);
	TextView destination = (TextView) findViewById(R.id.destination);
	String   DESTINATION = getString(R.string.destination);
				
	version.setText(VERSION + " " + "unknown" + ".\n");
	VERSIONS.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
	versions.setAdapter(VERSIONS);
	versions.setOnItemSelectedListener(this);
	cpu.setText(CPU + " " + java.lang.System.getProperty("os.arch") + ".\n");
	PATHS = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,
				java.lang.System.getenv("PATH").split("\\" + pathSep));
	PATHS.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
	paths.setAdapter(PATHS);
	paths.setOnItemSelectedListener(this);
	folder.setText(FOLDER + " " + "" + "\n");
	source.setText(SOURCE + " " + ""  + "\n");
	destination.setText(DESTINATION + " " + ""  + "\n");
    }

		@Override
		public void onItemSelected(AdapterView<?> parent, View view, int pos, long id)
		{
				String s = (String) parent.getItemAtPosition(pos);

				switch (parent.getId())
				{
						case R.id.versions :
						{
							TextView source = (TextView) findViewById(R.id.source);
							String   SOURCE = getString(R.string.source);
	
							source.setText(SOURCE + " http://landley.net/code/toybox/downloads/binaries/" + s + "/toybox-\n");
							break;
						}
						case R.id.paths:
						{
								TextView destination = (TextView) findViewById(R.id.destination);
								String   DESTINATION = getString(R.string.destination);

								destination.setText(DESTINATION + " " + s + "\n");
						}
				}
		}

		@Override
		public void onNothingSelected(AdapterView<?> parent)
		{
				// TODO: Nothing to do here, maybe?
		}

    public void installToybox(View view)
    {
    }
}
