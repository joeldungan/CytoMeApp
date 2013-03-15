package com.cytogerbers.cytomeapp;

import android.R.color;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MySimpleArrayAdapter extends ArrayAdapter<String>{
	private final Context context;
	private final String[] menuOptions;
	
	public MySimpleArrayAdapter(Context context, String[] values){
		super(context, R.layout.rowlayout, values);
		this.context=context;
		this.menuOptions=values;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View rowView = inflater.inflate(R.layout.rowlayout, parent, false);
		//rowView.setBackgroundColor(Color.BLACK);
		TextView textView = (TextView) rowView.findViewById(R.id.menuitem);
		ImageView imageView = (ImageView) rowView.findViewById(R.id.icon);
		//Set text in array to text view
		textView.setText(menuOptions[position]);
		//textView.setTextColor(Color.rgb(153, 204, 255));
		//Assign icons to various menu items
		String selectedMenuItem = menuOptions[position];
		if(selectedMenuItem.startsWith("Begin"))
				imageView.setImageResource(R.drawable.newibegin);
		else{
			imageView.setImageResource(R.drawable.newireview);
		}
		
		return rowView;	
	}
	
	

}
