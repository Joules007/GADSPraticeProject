package ng.com.ajsprojects.gadspraticeproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.material.tabs.TabLayout;

import ng.com.ajsprojects.gadspraticeproject.Adapters.ViewPagerAdapter;
import ng.com.ajsprojects.gadspraticeproject.Fragments.LearningLeadersFragment;
import ng.com.ajsprojects.gadspraticeproject.Fragments.SkillIQLeadersFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setSupportActionBar((Toolbar) findViewById(R.id.main_toolbar));

        ViewPager viewPager = findViewById(R.id.main_viewpager);
        TabLayout tabLayout = findViewById(R.id.main_tabLayout);

        tabLayout.setupWithViewPager(viewPager);

        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(), 0);
        viewPagerAdapter.addFragments(new LearningLeadersFragment(this), "Learning Leaders");
        viewPagerAdapter.addFragments(new SkillIQLeadersFragment(this), "Skill IQ Leaders");

        viewPager.setAdapter(viewPagerAdapter);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.action_submit) {
            startActivity(new Intent(this, SubmitActivity.class));
        }
        return super.onOptionsItemSelected(item);
    }
}
