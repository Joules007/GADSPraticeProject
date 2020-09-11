package ng.com.ajsprojects.gadspraticeproject.Fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import ng.com.ajsprojects.gadspraticeproject.Models.SkillIQLeaders;
import ng.com.ajsprojects.gadspraticeproject.R;
import ng.com.ajsprojects.gadspraticeproject.Adapters.SkillIQLeadersAdapter;
import ng.com.ajsprojects.gadspraticeproject.Utilities;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SkillIQLeadersFragment extends Fragment {
    private Context mContext;
    private RecyclerView mSkillIQLeaderList;
    private List<SkillIQLeaders> mSkillIQLeaders;
    private SkillIQLeadersAdapter mAdapter;

    public SkillIQLeadersFragment(Context context) {
        this.mContext = context;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_skill_iq_leaders, container, false);

        mSkillIQLeaderList = view.findViewById(R.id.skillIqRecyclerView);
        mSkillIQLeaders = new ArrayList<>();

        mSkillIQLeaderList.setLayoutManager(new LinearLayoutManager(getContext()));
        mSkillIQLeaderList.setHasFixedSize(true);
        mAdapter = new SkillIQLeadersAdapter(mSkillIQLeaders, mContext);


        fetchSkillIQLeaders();
        return view;
    }

    private void fetchSkillIQLeaders() {
        Utilities
                .GadsApiUtility
                .fetchSkillIQLeaders()
                .enqueue(new Callback<List<SkillIQLeaders>>() {
                    @Override
                    public void onResponse(Call<List<SkillIQLeaders>> call, Response<List<SkillIQLeaders>> response) {
                        if (!response.isSuccessful()) {
                            new AlertDialog.Builder(mContext)
                                    .setTitle(R.string.error)
                                    .setMessage(response.message() + "\n" + response.code())
                                    .create()
                                    .show()
                            ;
                        }

                        List<SkillIQLeaders> skillIQLeaders = response.body();
                        assert skillIQLeaders != null;
                        mSkillIQLeaders.addAll(skillIQLeaders);

                        mAdapter.notifyDataSetChanged();
                        mSkillIQLeaderList.setAdapter(mAdapter);
                    }

                    @Override
                    public void onFailure(Call<List<SkillIQLeaders>> call, Throwable t) {
                        new AlertDialog.Builder(mContext)
                                .setTitle(R.string.error)
                                .setMessage(t.getMessage())
                                .create()
                                .show()
                        ;
                    }
                })
        ;
    }

}