package edu.calpoly.idulkin.podcrust.SearchedList;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;

import trikita.anvil.RenderableView;

import static trikita.anvil.BaseDSL.MATCH;
import static trikita.anvil.BaseDSL.dip;
import static trikita.anvil.BaseDSL.padding;
import static trikita.anvil.BaseDSL.size;
import static trikita.anvil.DSL.adapter;
import static trikita.anvil.DSL.itemsCanFocus;
import static trikita.anvil.DSL.linearLayout;
import static trikita.anvil.DSL.listView;
import static trikita.anvil.DSL.onItemClick;
import static trikita.anvil.DSL.orientation;

/**
 * Created by Max on 12/1/2016.
 */

public class SearchListView extends RenderableView {

    private final static String TAG = "SearchListView";
    private final ShowAdapter showAdapter;

    public SearchListView(Context c) {
        super(c);
        showAdapter = new ShowAdapter();
    }

    AdapterView.OnItemClickListener onItemClickListener = new AdapterView.OnItemClickListener() {
        public void onItemClick(AdapterView parent, View v, int pos, long id) {
            Log.d(TAG, "item clicked: " + showAdapter.getItem(pos).title);
        }
    };

    @Override
    public void view() {
        showAdapter.notifyDataSetChanged();

        linearLayout(() -> {
            size(MATCH, MATCH);
            padding(dip(8));
            orientation(LinearLayout.VERTICAL);

            listView(() -> {
                size(MATCH, MATCH);
                itemsCanFocus(true);
                onItemClick(onItemClickListener);
                adapter(showAdapter);
            });
        });
    }
}
