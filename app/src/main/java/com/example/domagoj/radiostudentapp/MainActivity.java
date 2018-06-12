package com.example.domagoj.radiostudentapp;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
// Kad extendiram metodu onda se povuku sav sadržaj, Object inheritance,

    @Override // metoda on create je definirana u nasljeđenoj klasi , al kad je override onda ne koristi metodu iz nasljeđene
    // extendirane klase nego se koristi ova koja je tu definirana ispod
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); // suoer je oznaka za nasljedjenu ekstendiranu metodu
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT); // orjentacija ekrana
        setContentView(R.layout.activity_main);

        ViewPager mViewPager = findViewById(R.id.container); // ovo je container koji je definiran negdje
        setupViewPager(mViewPager); // u ovom aktivitiju postavi view pager, spajanje, MVC programiranje model view controler

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);
    }
// definicija view pagera - MODEL- napravimo adapter, dodamo fragmente,
    //stvorili smo neki adapter, gurnuli ga u viewpager, a taj viewpager smo onda gurnuli u Layout
    private void setupViewPager(ViewPager viewPager) {
        SectionsPageAdapter adapter = new SectionsPageAdapter(getSupportFragmentManager()); //definiranje novog objekta
        adapter.addFragment(new ProgramFragment(), getString(R.string.program)); //0
        adapter.addFragment(new PlayerFragment(), getString(R.string.player)); // 1
        adapter.addFragment(new ArhivaFragment(), getString(R.string.arhiva)); //2
        viewPager.setAdapter(adapter);
        viewPager.setCurrentItem(1 /* Player */); //da se prvo prikaze player
    }

}
