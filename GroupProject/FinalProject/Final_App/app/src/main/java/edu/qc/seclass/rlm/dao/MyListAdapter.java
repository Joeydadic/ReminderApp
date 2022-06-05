package edu.qc.seclass.rlm.dao;
import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
import java.util.function.Consumer;

import edu.qc.seclass.rlm.AppDatabase;
import edu.qc.seclass.rlm.R;
import edu.qc.seclass.rlm.entity.Reminder;

public class MyListAdapter extends RecyclerView.Adapter<MyListAdapter.ViewHolder> {
    private List<Reminder> listdata;
    private Consumer<Integer> function;
    private Consumer<Integer> function2;
    private AppDatabase db;
    private Context context;

    public MyListAdapter(List<Reminder> listdata, Consumer<Integer> function, Consumer<Integer> function2, AppDatabase db, Context context) {
        this.listdata = listdata;
        this.function = function;
        this.function2 = function2;
        this.db = db;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.list_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final Reminder myListData = listdata.get(position);
        holder.textView.setText(listdata.get(position).reminderName);
        //holder.imageView.setImageResource(listdata[position].getImgId());
        holder.relativeLayout.setOnClickListener(view -> Toast.makeText(view.getContext(), "Click on item: " + myListData.reminderName, Toast.LENGTH_LONG).show());
        holder.delete.setOnClickListener(v -> {
            db.reminderDao().delete(myListData);
            function.accept(0);
        });
        holder.edit.setOnClickListener(v -> {
            function2.accept(myListData.id);
        });
    }

    @Override
    public int getItemCount() {
        return listdata.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView imageView;
        public TextView textView;
        public RelativeLayout relativeLayout;
        public Button delete;
        public Button edit;

        public ViewHolder(View itemView) {
            super(itemView);
            this.imageView = itemView.findViewById(R.id.imageView);
            this.textView = itemView.findViewById(R.id.textView);
            relativeLayout = itemView.findViewById(R.id.relativeLayout);
            delete = itemView.findViewById(R.id.button7);
            edit = itemView.findViewById(R.id.button8);
        }
    }
}