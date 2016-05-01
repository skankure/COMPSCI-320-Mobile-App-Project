package com.pandi.hima;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;

public class Search extends AppCompatActivity implements SearchView.OnQueryTextListener {


    /**
     * Shows a list that can be filtered in-place with a SearchView in non-iconified mode.
     */
        private SearchView mSearchView;
        private ListView mListView;

        private final String[] mStrings = Cheeses.sCheeseStrings;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            getWindow().requestFeature(Window.FEATURE_ACTION_BAR);

            setContentView(R.layout.searchview_filter);

            mSearchView = (SearchView) findViewById(R.id.search_view);
            mListView = (ListView) findViewById(R.id.list_view);
            mListView.setAdapter(new ArrayAdapter<String>(this,
                    android.R.layout.simple_list_item_1,
                    mStrings));
            mListView.setTextFilterEnabled(true);
            setupSearchView();
        }

        private void setupSearchView() {
            mSearchView.setIconifiedByDefault(false);
            mSearchView.setOnQueryTextListener(this);
            mSearchView.setSubmitButtonEnabled(true);
            mSearchView.setQueryHint("Search Here");
        }

        public boolean onQueryTextChange(String newText) {
            if (TextUtils.isEmpty(newText)) {
                mListView.clearTextFilter();
            } else {
                mListView.setFilterText(newText.toString());
            }
            return true;
        }

        public boolean onQueryTextSubmit(String query) {
            return false;
        }
    }
