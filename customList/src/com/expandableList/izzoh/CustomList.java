package com.expandableList.izzoh;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.TextView;

public class CustomList extends Activity {
	private ArrayList<String> groups;
	private ArrayList<ArrayList<ArrayList<String>>> childs;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        ExpandableListView elv = (ExpandableListView)findViewById(R.id.ExpandableListView01);
        loadData();
        myExpandableAdapter adapter = new myExpandableAdapter(this,groups,childs);
        elv.setAdapter(adapter);
        
    }
    public class myExpandableAdapter extends BaseExpandableListAdapter {
    	private ArrayList<String> groups;
    	private ArrayList<ArrayList<ArrayList<String>>> children;
    	private Context context;
    	
    	public myExpandableAdapter(Context context, ArrayList<String> groups,ArrayList<ArrayList<ArrayList<String>>> children){
    		this.context = context;
    		this.groups = groups;
    		this.children = childs; 
    	}

		@Override
		public ArrayList<String> getChild(int groupPosition, int childPosition) {
			// TODO Auto-generated method stub
			return children.get(groupPosition).get(childPosition);
		}

		@Override
		public long getChildId(int groupPosition, int childPosition) {
			// TODO Auto-generated method stub
			return childPosition;
		}

		@Override
		public View getChildView(int groupPosition, int childPosition,
				boolean isLastChild, View convertView, ViewGroup parent) {
			// TODO Auto-generated method stub
			String child = (String) ((ArrayList<String>)getChild(groupPosition,childPosition)).get(0);
			if (convertView == null){
				LayoutInflater infalInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
				convertView = infalInflater.inflate(R.layout.expandablelistview_child, null);
				
			}
			TextView childtxt = (TextView) convertView.findViewById(R.id.TextViewChild01);
			childtxt.setText(child);
			return convertView;
		}
		@Override
		public boolean areAllItemsEnabled(){
			return true;
		}

		@Override
		public int getChildrenCount(int groupPosition) {
			// TODO Auto-generated method stub
			return children.get(groupPosition).size();
		}

		@Override
		public String getGroup(int groupPosition) {
			// TODO Auto-generated method stub
			return groups.get(groupPosition);
		}

		@Override
		public int getGroupCount() {
			// TODO Auto-generated method stub
			return groups.size();
		}

		@Override
		public long getGroupId(int groupPosition) {
			// TODO Auto-generated method stub
			return groupPosition;
		}

		@Override
		public View getGroupView(int groupPosition, boolean isExpanded,
				View convertView, ViewGroup parent) {
			// TODO Auto-generated method stub
			String group = (String) getGroup(groupPosition);
			if (convertView == null){
				LayoutInflater infalInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
				convertView = infalInflater.inflate(R.layout.expandablelistview_group, null);
			}
			TextView grouptxt = (TextView) convertView.findViewById(R.id.TextViewGroup);
			grouptxt.setText(group);
			return convertView;
		}

		@Override
		public boolean hasStableIds() {
			// TODO Auto-generated method stub
			return true;
		}

		@Override
		public boolean isChildSelectable(int groupPosition, int childPosition) {
			// TODO Auto-generated method stub
			return true;
		}
    	
    }
    private void loadData(){
    	groups = new ArrayList<String>();
    	childs = new ArrayList<ArrayList<ArrayList<String>>>();
    	
    	groups.add("Group 1");
    	groups.add("Group 2");
    	groups.add("Group 3");
    	
    	childs.add(new ArrayList<ArrayList<String>>());
    	childs.get(0).add(new ArrayList<String>());
    	childs.get(0).get(0).add("Child 1 group 1");
    	childs.get(0).add(new ArrayList<String>());
    	childs.get(0).get(1).add("Child 2 group 1");
    	childs.get(0).add(new ArrayList<String>());
    	childs.get(0).get(2).add("Child 3 group 1");
    	
    	childs.add(new ArrayList<ArrayList<String>>());
    	childs.get(1).add(new ArrayList<String>());
    	childs.get(1).get(0).add("Child 1 group 2");
    	childs.get(1).add(new ArrayList<String>());
    	childs.get(1).get(1).add("Child 2 group 2");
    	childs.get(1).add(new ArrayList<String>());
    	childs.get(1).get(2).add("Child 3 group 2");
    	
    	childs.add(new ArrayList<ArrayList<String>>());
    	childs.get(2).add(new ArrayList<String>());
    	childs.get(2).get(0).add("Child 1 group 3");
    	childs.get(2).add(new ArrayList<String>());
    	childs.get(2).get(1).add("Child 2 group 3");
    	childs.get(2).add(new ArrayList<String>());
    	childs.get(2).get(2).add("Child 3 group 3");
    }
}