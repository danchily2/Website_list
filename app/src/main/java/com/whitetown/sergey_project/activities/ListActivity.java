package com.whitetown.sergey_project.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.whitetown.sergey_project.R;
import com.whitetown.sergey_project.adapters.WebItemAdapter;
import com.whitetown.sergey_project.model.WebItem;

import java.util.ArrayList;
import java.util.List;

public class ListActivity extends AppCompatActivity
{

    public static final String INTENT_PARAM_WEB_ITEM = "INTENT_PARAM_WEB_ITEM";
    private List<WebItem> myDatasetList = new ArrayList<>();

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_activity);
        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);

        Toolbar mActionBarToolbar = (Toolbar) findViewById(R.id.toolbar);
        mActionBarToolbar.setTitle(getString(R.string.app_name));
        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.addItemDecoration(new DividerItemDecoration(mRecyclerView.getContext(), DividerItemDecoration.VERTICAL));

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        this.populateDataSet();
        // specify an adapter (see also next example)
        WebItem[] myDataset = new WebItem[myDatasetList.size()];
        myDataset = myDatasetList.toArray(myDataset);
        mAdapter = new WebItemAdapter(myDataset, new WebItemAdapter.OnItemClickListener()
        {
            @Override
            public void onItemClick(WebItem item)
            {
                openDetailsActivity(item);
            }
        });
        mRecyclerView.setAdapter(mAdapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    void openDetailsActivity(WebItem item)
    {
        Intent intent = new Intent(ListActivity.this, DetailsActivity.class);
        intent.putExtra(INTENT_PARAM_WEB_ITEM, item); //Your id
        startActivity(intent);
    }

    void populateDataSet()
    {
        myDatasetList.add(new WebItem("Website 1", "https://www.whitetown.com/", android.R.drawable.btn_star));
        myDatasetList.add(new WebItem("Website 2", "https://www.whitetown.com/", android.R.drawable.btn_star));
        myDatasetList.add(new WebItem("Website 3", "https://www.whitetown.com/", android.R.drawable.btn_star));
        myDatasetList.add(new WebItem("Website 4", "https://www.whitetown.com/", android.R.drawable.btn_star));
        myDatasetList.add(new WebItem("Website 5", "https://www.whitetown.com/", android.R.drawable.btn_star));
        myDatasetList.add(new WebItem("Website 6", "https://www.whitetown.com/", android.R.drawable.btn_star));
        myDatasetList.add(new WebItem("Website 7", "https://www.whitetown.com/", android.R.drawable.btn_star));
        myDatasetList.add(new WebItem("Website 8", "https://www.whitetown.com/", android.R.drawable.btn_star));
        myDatasetList.add(new WebItem("Website 9", "https://www.whitetown.com/", android.R.drawable.btn_star));
        myDatasetList.add(new WebItem("Website 10", "https://www.whitetown.com/", android.R.drawable.btn_star));
        myDatasetList.add(new WebItem("Website 11", "https://www.google.com/", android.R.drawable.btn_star));
    }


}
