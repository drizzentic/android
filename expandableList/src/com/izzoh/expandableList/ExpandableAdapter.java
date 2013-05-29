package com.izzoh.expandableList;

import android.content.Context;
import android.graphics.Typeface;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

public class ExpandableAdapter extends BaseExpandableListAdapter {
	private Context mContext;
	private String[][] mContents;
	private String[] mTitles;
	
	public ExpandableAdapter(Context context,String[] titles,String[][] contents){
		super();
		if (titles.length != contents.length){
			throw new IllegalArgumentException ("Titles and Contents must be the same size");
		
		}
		mContext = context;
		mContents = contents;
		mTitles = titles;
	}
//returns a child item
	@Override
	public String getChild(int groupPosition, int childPosition) {
		// TODO Auto-generated method stub
		
		return mContents[groupPosition][childPosition];
	}
//returns an items id
	@Override
	public long getChildId(int groupPosition, int childPosition) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView,
			ViewGroup parent) {
		// TODO Auto-generated method stub
		TextView row = (TextView)convertView;
		if (row ==null){
			row = new TextView(mContext);
		}
		row.setText(mContents[groupPosition][childPosition]);
		return row;
	}

	@Override
	public int getChildrenCount(int groupPosition) {
		// TODO Auto-generated method stub
		
		return mContents[groupPosition].length;
	}
//return selections
	@Override
	public String[] getGroup(int groupPosition) {
		// TODO Auto-generated method stub
		return mContents[groupPosition];
	}
//return number of sections
	@Override
	public int getGroupCount() {
		// TODO Auto-generated method stub
		return mContents.length;
	}
//return a section's id
	@Override
	public long getGroupId(int groupPosition) {
		// TODO Auto-generated method stub
		return 0;
	}
//return a view for each section header
	@Override
	public View getGroupView(int groupPosition, boolean isExpandable, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		TextView row = (TextView) convertView;
		if (row == null){
			row = new TextView(mContext);
		}
		row.setTypeface(Typeface.DEFAULT_BOLD);
		row.setText(mTitles[groupPosition]);
		return row;
	}

	@Override
	public boolean hasStableIds() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isChildSelectable(int groupPosition, int childPosition) {
		// TODO Auto-generated method stub
		return true;
	}

}
