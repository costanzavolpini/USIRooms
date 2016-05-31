package com.usirooms.usirooms;

import android.os.Build;
import android.os.Bundle;
import android.view.Window;

import com.chyrta.onboarder.OnboarderActivity;
import com.chyrta.onboarder.OnboarderPage;

import java.util.ArrayList;
import java.util.List;

public class OnBoarding extends OnboarderActivity {

    List<OnboarderPage> onboarderPages;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        onboarderPages = new ArrayList<>();

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            setTheme(R.style.OnBoard);
          //  window.setNavigationBarColor(getResources().getColor(R.color.on_board));
            //window.setStatusBarColor(getResources().getColor(R.color.black_transparent));
        }

        // Each page of the tutorial is created here
        OnboarderPage onboarderPage1 = new OnboarderPage(R.string.name_app, R.string.subtitle,R.mipmap.logo);
        OnboarderPage onboarderPage2 = new OnboarderPage(R.string.free_rooms, R.string.free_rooms_sub, R.drawable.ic_free_rooms);
        OnboarderPage onboarderPage3 = new OnboarderPage(R.string.by_event, R.string.by_event_sub, R.drawable.ic_by_event);
        OnboarderPage onboarderPage4 = new OnboarderPage(R.string.by_room, R.string.by_room_sub, R.drawable.ic_by_room);
        OnboarderPage onboarderPage5 = new OnboarderPage(R.string.nav_explain, R.string.nav_explain_sub,R.mipmap.logo);

        // Onboarder 1: settings
        onboarderPage1.setTitleColor(R.color.white);
        setTheme(R.style.onBoardGreen);
        onboarderPage1.setDescriptionColor(R.color.white);
        onboarderPage1.setBackgroundColor(R.color.on_board_green_dark);
        onboarderPage1.setTitleTextSize(30);
        onboarderPage1.setDescriptionTextSize(19);

        // Onboarder 2: settings
        onboarderPage2.setTitleColor(R.color.white);
        setTheme(R.style.OnBoardYellow);
        onboarderPage2.setDescriptionColor(R.color.white);
        onboarderPage2.setBackgroundColor(R.color.OnBoardYellow);
        onboarderPage2.setTitleTextSize(30);
        onboarderPage2.setDescriptionTextSize(19);

        // Onboarder 3: settings
        onboarderPage3.setTitleColor(R.color.white);
        onboarderPage3.setDescriptionColor(R.color.white);
        setTheme(R.style.OnBoardRed);
        onboarderPage3.setBackgroundColor(R.color.onBoardRed);
        onboarderPage3.setTitleTextSize(30);
        onboarderPage3.setDescriptionTextSize(19);

        // Onboarder 4: settings
        onboarderPage4.setTitleColor(R.color.white);
        setTheme(R.style.VioletOnBoard);
        onboarderPage4.setDescriptionColor(R.color.white);
        onboarderPage4.setBackgroundColor(R.color.VioletOnBoard);
        onboarderPage4.setTitleTextSize(30);
        onboarderPage4.setDescriptionTextSize(19);

        // Onboarder 5: settings
        onboarderPage5.setTitleColor(R.color.white);
        onboarderPage5.setDescriptionColor(R.color.white);
        onboarderPage5.setBackgroundColor(R.color.theme_status_blu);
        onboarderPage5.setTitleTextSize(30);
        onboarderPage5.setDescriptionTextSize(19);

        // Each page is added to an ArrayList of pages.
        onboarderPages.add(onboarderPage1);
       // onboarderPages.add(onboarderPage5 );
        onboarderPages.add(onboarderPage2);
        onboarderPages.add(onboarderPage3);
        onboarderPages.add(onboarderPage4);

        setOnboardPagesReady(onboarderPages);
    }

    @Override
    public void onSkipButtonPressed() {
        // Optional: by default it skips onboarder to the end
        super.onSkipButtonPressed();
        dismiss();
    }

    @Override
    public void onFinishButtonPressed() {
        dismiss();
    }

    private void dismiss() {
//        Intent resultIntent = new Intent();
//        setResult(RESULT_OK, resultIntent);
        finish();
    }
}