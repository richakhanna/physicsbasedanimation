//package com.richdroid.physicsbasedanimation.ui.adapter;
//
//import android.content.Context;
//import android.graphics.drawable.Drawable;
//import android.support.v7.widget.RecyclerView;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.ImageView;
//
//import java.util.List;
//
///**
// * Created by richakhanna on 29/08/17.
// */
//
//public class SpringRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
//
//    private static Context mContext;
//    private static List<Drawable> mDatasetList;
//    // Allows to remember the last item shown on screen
//    private int lastAnimatedItemPosition = -1;
//    private boolean mTwoPane;
//
//
//    // Provide a suitable constructor (depends on the kind of dataset)
//    public SpringRecyclerViewAdapter(Context context, List<Drawable> datasetList) {
//        mContext = context;
//        mDatasetList = datasetList;
//    }
//
//    // Provide a reference to the views for each data item
//    // Complex data items may need more than one view per item, and
//    // you provide access to all the views for a data item in a view holder
//    public class SpringViewHolder extends RecyclerView.ViewHolder {
//
//        ImageView mIVThumbNail;
//
//
//        public SpringViewHolder(View view) {
//            super(view);
//
//            //mIVThumbNail = view.findViewById(R.id.)
//            this.mIVThumbNail.setOnClickListener(this);
//        }
//    }
//
//
//    // Create new views (invoked by the layout manager)
//    @Override
//    public SpringViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        // create a new view
//        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_item_view, parent, false);
//        return new SpringViewHolder(view);
//    }
//
//    // Replace the contents of a view (invoked by the layout manager)
//    @Override
//    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
//        // - get element from your dataset at this position
//        // - replace the contents of the view with that element
//        SpringViewHolder cusHolder = (SpringViewHolder) holder;
//
//        cusHolder.mIVThumbNail.setVisibility(View.VISIBLE);
//
//    }
//
//    // Return the size of your dataset (invoked by the layout manager)
//    @Override
//    public int getItemCount() {
//        return mDatasetList.size();
//    }
//
//}
