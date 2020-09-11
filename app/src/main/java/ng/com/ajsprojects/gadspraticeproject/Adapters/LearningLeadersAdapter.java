package ng.com.ajsprojects.gadspraticeproject.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import ng.com.ajsprojects.gadspraticeproject.LeadersViewHolder;
import ng.com.ajsprojects.gadspraticeproject.Models.LearningLeaders;
import ng.com.ajsprojects.gadspraticeproject.R;

public class LearningLeadersAdapter extends RecyclerView.Adapter<LeadersViewHolder> {
    private List<LearningLeaders> mLearningLeadersList;
    private Context mContext;

    public LearningLeadersAdapter(List<LearningLeaders> learningLeadersList, Context context) {
        mLearningLeadersList = learningLeadersList;
        mContext = context;
    }

    @NonNull
    @Override
    public LeadersViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new LeadersViewHolder(
                LayoutInflater
                        .from(mContext)
                        .inflate(R.layout.item_leaders_list, parent, false)
        );
    }

    @Override
    public void onBindViewHolder(@NonNull LeadersViewHolder holder, int position) {
        LearningLeaders currentLeaderPerHour = mLearningLeadersList.get(position);
        holder.bind(currentLeaderPerHour);
    }

    @Override
    public int getItemCount() {
        return mLearningLeadersList.size();
    }
}