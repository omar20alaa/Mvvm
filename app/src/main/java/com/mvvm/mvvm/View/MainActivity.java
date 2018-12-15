package com.mvvm.mvvm.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.mvvm.mvvm.Adapter.MainAdapter;
import com.mvvm.mvvm.Model.MainModel;
import com.mvvm.mvvm.R;
import com.mvvm.mvvm.ViewModel.MainViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    // bind views

    @Nullable
    @BindView(R.id.recycler_view)
    RecyclerView recycler_view;

    @Nullable
    @BindView(R.id.fab_btn)
    FloatingActionButton fab_btn;

    @Nullable
    @BindView(R.id.progress_bar)
    ProgressBar progress_bar;

    // vars
    MainAdapter adapter;
    MainViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initViewModel();
        initRecyclerView();
    }

    @OnClick(R.id.fab_btn)
    public void showMore()
    {
        viewModel.addNewValue(
                new MainModel("http://blogmedia.dealerfire.com/wp-content/uploads/sites/223/2016/08/android-robot-icon-22.png","New Title")
        );
    }

    private void initViewModel() {

        viewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        viewModel.init();
        viewModel.getNicePlaces().observe(this, new Observer<List<MainModel>>() {
            @Override
            public void onChanged(List<MainModel> mainModels) {
                adapter.notifyDataSetChanged();
            }
        });

        viewModel.getIsUpdating().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                if (aBoolean)
                {
                    showProgressBar();
                }
                else
                {
                    hideProgressBar();
                    recycler_view.smoothScrollToPosition(viewModel.getNicePlaces().getValue().size()-1);
                }
            }
        });

    }

    private void initRecyclerView() {
        recycler_view.setHasFixedSize(true);
        adapter = new MainAdapter(getApplicationContext(), viewModel.getNicePlaces().getValue());
        recycler_view.setLayoutManager(new LinearLayoutManager(this));
        recycler_view.setAdapter(adapter);

    } // initialize recycler view

    private void showProgressBar() {
        progress_bar.setVisibility(View.VISIBLE);
    }

    private void hideProgressBar() {
        progress_bar.setVisibility(View.GONE);
    }
}
