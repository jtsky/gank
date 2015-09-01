package com.jin.gank.adapter;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.text.SpannableStringBuilder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jin.gank.R;
import com.jin.gank.WebActivity;
import com.jin.gank.data.GankCategory;
import com.jin.gank.util.StringStyleUtils;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class GankListAdapter extends AnimRecyclerViewAdapter<GankListAdapter.ViewHolder> {

    private List<GankCategory.ResultsEntity> mGankList;

    public GankListAdapter(List<GankCategory.ResultsEntity> gankList) {
        mGankList = gankList;
    }

    @Override public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v =
            LayoutInflater.from(parent.getContext()).inflate(R.layout.item_gank, parent, false);
        return new ViewHolder(v);
    }

    @Override public void onBindViewHolder(ViewHolder holder, int position) {
        GankCategory.ResultsEntity gank = mGankList.get(position);
        if (position == 0) {
            showCategory(holder);
        }
        else {
            boolean doesLastAndThis =
                mGankList.get(position - 1).getType().equals(mGankList.get(position).getType());
            if (!doesLastAndThis) {
                showCategory(holder);
            }
            else if (holder.category.isShown()) holder.category.setVisibility(View.GONE);
        }
        holder.category.setText(gank.getType());
        if (holder.gank.getTag() == null) {
            SpannableStringBuilder builder = new SpannableStringBuilder(gank.getDesc()).append(
                StringStyleUtils.format(holder.gank.getContext(), " (via. " + gank.getWho() + ")",
                        R.style.ViaTextAppearance));
            CharSequence gankText = builder.subSequence(0, builder.length());
            holder.gank.setTag(gankText);
        }
        CharSequence text = (CharSequence) holder.gank.getTag();
        holder.gank.setText(text);
        showItemAnim(holder.gank, position);
    }

    @Override public int getItemCount() {
        return mGankList.size();
    }

    private void showCategory(ViewHolder holder) {
        if (!holder.category.isShown()) holder.category.setVisibility(View.VISIBLE);
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        @Bind(R.id.tv_category) TextView category;
        @Bind(R.id.tv_title) TextView gank;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        @OnClick(R.id.ll_gank_parent) void onGank(View v) {
            GankCategory.ResultsEntity gank = mGankList.get(getLayoutPosition());
            Intent intent = new Intent(v.getContext(), WebActivity.class);
            intent.putExtra(WebActivity.EXTRA_TITLE, gank.getDesc());
            intent.putExtra(WebActivity.EXTRA_URL, gank.getUrl());
            v.getContext().startActivity(intent);
        }
    }
}
