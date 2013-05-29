package com.signs.izzoh;

import android.app.Activity;
import android.app.ExpandableListActivity;
import android.content.Context;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.CheckBox;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.ExpandableListContextMenuInfo;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class signA extends ExpandableListActivity implements ExpandableListView.OnChildClickListener {
    ExpandableListAdapter mAdapter;
    Context mContext;   
    static final String groups[] = { "Chats", "Contacts (289)",
        "Group Chat (7)", "e-Card  (137)", "Pending  (37)",
        "Bookmarks" };

static final String children[][] = {
        { "ListofChats" },
        { "Group", "groupt01", "groupt02", "groupt03" },
        { "Groupd 01", "", "Group  02", "", "Group  03", "" },
        { "E-Card-01", "", "E-Card-02", "",
                "Business Card Received", "" },
        { " Req", "", " Req", "", " Req", "" } };

private static final String TAG = "Hookup";
	//XMPPConnection connection = SignInMainActivity.connection;

@Override
public void onCreate(Bundle savedInstanceState) {       
        super.onCreate(savedInstanceState);                 
    mAdapter = (ExpandableListAdapter) new MyExpandableListAdapter(this);
    setListAdapter(mAdapter);
    registerForContextMenu(getExpandableListView());        
}
@Override
public boolean onChildClick(ExpandableListView parent, View v,
        int groupPosition, int childPosition, long id) {
    // TODO Auto-generated method stub
    System.out.println("Insidded onContextItemSelected");
    return super.onChildClick(parent, v, groupPosition, childPosition, id);
}

@Override
public void onCreateContextMenu(ContextMenu menu, View v,
        ContextMenuInfo menuInfo) {
    menu.setHeaderTitle("Hookup Menu");
    menu.add(0, 0, 0, R.string.hello);
}

public boolean onContextItemSelected(MenuItem item) {
    System.out.println("Insidded onContextItemSelected");

    Log.i(TAG, "onContextItemSelected");
    ExpandableListContextMenuInfo info = (ExpandableListContextMenuInfo) item
            .getMenuInfo();

    String title = ((TextView) info.targetView).getText().toString();
    int type = ExpandableListView
            .getPackedPositionType(info.packedPosition);

    if (type == ExpandableListView.PACKED_POSITION_TYPE_CHILD) {
        int groupPos = ExpandableListView
                .getPackedPositionGroup(info.packedPosition);
        int childPos = ExpandableListView
                .getPackedPositionChild(info.packedPosition);
        Toast.makeText(this,title + ": Child " + childPos + " clicked in                    group " + groupPos, Toast.LENGTH_SHORT).show();
        return true;
    } else if (type == ExpandableListView.PACKED_POSITION_TYPE_GROUP) {
        int groupPos = ExpandableListView
                .getPackedPositionGroup(info.packedPosition);
        Toast.makeText(this, title + ": Group " + groupPos + " clicked",
                Toast.LENGTH_SHORT).show();
        return true;
    }
    return false;
}

public class MyExpandableListAdapter extends BaseExpandableListAdapter {
    Context mContext;

    public MyExpandableListAdapter() {
        // TODO Auto-generated constructor stub
    }

    public MyExpandableListAdapter(Context context) {
        mContext = context;

    }

    public Object getChild(int groupPosition, int childPosition) {
        Log.i(TAG, "getChild");
        return children[groupPosition][childPosition];
    }

    public long getChildId(int groupPosition, int childPosition) {
        Log.i(TAG, "getChildId");
        return childPosition;
    }

    public int getChildrenCount(int groupPosition) {
        Log.i(TAG, "getChildId");
        return children[groupPosition].length;
    }

    public View getChildView1(int groupPosition, int childPosition,
            boolean isLastChild, View convertView, ViewGroup parent) {
        Log.i(TAG, "getChildView");

        LayoutInflater layoutInflater = (LayoutInflater) mContext
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = null;

        TextView tt = null;
        if (groupPosition == 4) {
           // v = layoutInflater.inflate(R.layout.button_group, null);
        } else {
            //v = layoutInflater.inflate(R.layout.album_row, null);
            tt = (TextView) v.findViewById(R.id.text1);

            String myText = this.getChild(groupPosition, childPosition)
                    .toString();

            tt.setText(myText);
            CheckBox cb = (CheckBox) v.findViewById(R.id.checkbox);
            cb.setVisibility(View.VISIBLE);

            if (groupPosition == 0) {
                ImageView icon = (ImageView) v.findViewById(R.id.rowicon);
                //icon.setImageResource(R.drawable.add_picture);
            } else {
                ImageView icon = (ImageView) v.findViewById(R.id.rowicon);
               // icon.setImageResource(R.drawable.add_picture);

            }
        }

                    return v;
    }

    public Object getGroup(int groupPosition) {
        Log.i(TAG, "getGroup");
        return groups[groupPosition];
    }

    public int getGroupCount() {
        Log.i(TAG, "getGroupCount");
        return groups.length;
    }

    public long getGroupId(int groupPosition) {
    	
        Log.i(TAG, "getGroupId");
        return groupPosition;
    }

    public View getGroupView1(int groupPosition, boolean isExpanded,
            View convertView, ViewGroup parent) {
        TextView groupTitle = null;
        ImageView imgDot;
        LayoutInflater layoutInflater = (LayoutInflater) mContext
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = null;
        //v = layoutInflater.inflate(R.layout.button_group, null);
        //groupTitle = (TextView) v.findViewById(R.id.TextView01);
        String myText = this.getGroup(groupPosition).toString();
        groupTitle.setText(myText);
        //imgDot = (ImageView) v.findViewById(R.id.ImageView01);
        //imgDot.setVisibility(View.VISIBLE);
        return v;
    }
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        Log.i(TAG, "isChildSelectable");
        return true;
    }
    public boolean hasStableIds() {
        Log.i(TAG, "hasStableIds");
        return true;
    }
    public void registerDataSetObserver(DataSetObserver observer) {
    }

	@Override
	public View getChildView(int groupPosition, int childPosition,
			boolean isLastChild, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public View getGroupView(int groupPosition, boolean isExpanded,
			View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		return null;
	}
} // closing of MyExpandableListAdapter 
} // closing of MyExpadableListActivity {
    