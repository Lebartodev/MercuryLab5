package com.lebartodev.mercurylab5;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class GalleryFragment extends Fragment {
    private ImageAdapter adapter;
    private List<String> images = new ArrayList<>();


    public GalleryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.f_gallery, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        RecyclerView galleryList = (RecyclerView) getActivity().findViewById(R.id.gallery_list);
        galleryList.setLayoutManager(new GridLayoutManager(getActivity(), 2));


        if (adapter == null) {
            adapter = new ImageAdapter(getActivity(), images);

        } else adapter.setContext(getActivity());
        galleryList.setAdapter(adapter);

    }
}
