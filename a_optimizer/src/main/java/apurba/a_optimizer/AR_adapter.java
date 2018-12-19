package apurba.a_optimizer;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class AR_adapter extends RecyclerView.Adapter<AR_adapter.ViewHolder> {

    private List<DataItem> mDataset;
    private int mLayoutResId;
    private Map<Integer, Integer> mDataLayoutMap;
    private RecyclerAdapterOnclickListener mListener;

    public AR_adapter(List<DataItem> Dataset
            , int layoutResId
            , Map<Integer, Integer> dataLayoutMap
            , RecyclerAdapterOnclickListener listener) {

        mDataset = Dataset;
        mLayoutResId = layoutResId;
        mDataLayoutMap = dataLayoutMap;
        mListener = listener;
    }

    public void clearData(){
        mDataset = new ArrayList<>();
    }
    public void addAllData(List<DataItem> dataset){
        mDataset = dataset;
    }
    public List<DataItem> getDataset(){
        return mDataset;
    }



    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view =  LayoutInflater.from(parent.getContext()).inflate(mLayoutResId,
                parent,
                false);
        return  new ViewHolder(view, mListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        DataItem currentDataItem = mDataset.get(position);

        for (int id: mDataLayoutMap.keySet()){
            View childView = viewHolder.getView(id);
            if (childView instanceof TextView){
                String text = currentDataItem.switchGetters(mDataLayoutMap.get(id));
                ((TextView) childView).setText(text);
            }
        }
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        View mView;
        RecyclerAdapterOnclickListener mListener;

        ViewHolder(@NonNull View itemView, RecyclerAdapterOnclickListener listener) {
            super(itemView);
            mView = itemView;
            mView.setOnClickListener(this);
            mListener = listener;
        }

        View getView(int viewId){
            return mView.findViewById(viewId);
        }

        @Override
        public void onClick(View v) {
            if (mListener != null){
                mListener.onClick(v, getAdapterPosition());
            }
        }
    }
}
