package com.cytogerbers.cytomeapp;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Menu extends ListActivity{
	String[] modes = {"Begin New Experiment", "Review Past Experiments"};


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		MySimpleArrayAdapter adapter = new MySimpleArrayAdapter(this, modes);	
		setListAdapter(adapter);
		//setListAdapter(new ArrayAdapter<String>(Menu.this,android.R.layout.simple_list_item_1, modes));
	}
	
	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		String classString = "com.cytogerbers.cytomeapp.";
		super.onListItemClick(l, v, position, id);
		if(position == 0)
			classString += "Experiment";
		if(position == 1)
			classString += "Review";
			
		Class ourClass = null;
		try {
			ourClass = Class.forName(classString);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		Intent ourIntent = new Intent(Menu.this, ourClass);
		startActivity(ourIntent);
		
	}
	

}
