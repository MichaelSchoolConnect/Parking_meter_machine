package com.example.parkingmetermachine;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import org.junit.Rule;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class TestMainActivity {

    @Rule
    public ActivityScenarioRule<MainActivity> activityActivityScenarioRule =
            new ActivityScenarioRule<>(MainActivity.class);

    @org.junit.Test
    public void listGoesOverTheFold() {
        onView(withText("Enter amount:")).check(matches(isDisplayed()));
        onView(withId(R.id.e_amount)).perform(typeText("100"));
        onView(withId(R.id.e_cost)).perform(typeText("35"));
        onView(withId(R.id.button)).perform(click());
    }

}
