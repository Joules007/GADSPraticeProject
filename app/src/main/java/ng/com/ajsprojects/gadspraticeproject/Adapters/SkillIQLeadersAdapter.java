package ng.com.ajsprojects.gadspraticeproject.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import ng.com.ajsprojects.gadspraticeproject.LeadersViewHolder;
import ng.com.ajsprojects.gadspraticeproject.Models.SkillIQLeaders;
import ng.com.ajsprojects.gadspraticeproject.R;

public class SkillIQLeadersAdapter extends RecyclerView.Adapter<LeadersViewHolder> {
    private List<SkillIQLeaders> mSkillIQLeaders;
    private Context mContext;

    public SkillIQLeadersAdapter(List<SkillIQLeaders> skillIQLeaders, Context context) {
        mSkillIQLeaders = skillIQLeaders;
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
        SkillIQLeaders currentLeader = mSkillIQLeaders.get(position);
        holder.bind(currentLeader);
    }

    @Override
    public int getItemCount() {
        return mSkillIQLeaders.size();
    }
}