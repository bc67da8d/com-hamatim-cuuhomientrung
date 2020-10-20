package com.hamatim.cuuhomientrung.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.hamatim.cuuhomientrung.ui.viewholder.VHBase;
import java.util.ArrayList;
import java.util.List;

public abstract class AdapterBase<M, V extends VHBase> extends RecyclerView.Adapter<V> {

    private List<M> mList;
    private Context mContext;

    public AdapterBase(Context mContext) {
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public V onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View root = LayoutInflater.from(mContext).inflate(getLayoutResId(), parent, false);
        return onCreateViewHolder(root);
    }

    protected abstract V onCreateViewHolder(View root);

    protected M getItem(int position){
        return mList.get(position);
    }

    protected abstract int getLayoutResId();

    @Override
    public int getItemCount() {
        return getmList().size();
    }

    public List<M> getmList() {
        if (mList == null){
            mList = new ArrayList<>();
        }
        return mList;
    }

    public void setmList(List<M> mList) {
        this.mList = mList;
    }

    public Context getContext(){
        return mContext;
    }

}
