package com.moringaschool.wishabook;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
@LargeTest

public class LoginActivityInstrumentationTest {
    @Rule
    public ActivityTestRule<LoginActivity> activityTestRule =
            new ActivityTestRule<>(LoginActivity.class);

    @Test
    public void validateEditTextEmail(){
        onView(withId(R.id.userEmail)).perform(typeText("hamso@mail.com"))
                .check(matches(withText("hamso@mail.com")));
    }

    @Test
    public void validateEditTextPassword(){
        String email = "hamso@mail.com";
        onView(withId(R.id.userEmail)).perform(typeText(email)).perform(closeSoftKeyboard());
        try{
            Thread.sleep(250);
        }catch (InterruptedException e){
            System.out.println("not working");
        }
        onView(withId(R.id.userPassword)).perform(typeText("mypassword"))
                .check(matches(withText("mypassword")));
        try{
            Thread.sleep(250);
        }catch (InterruptedException e){
            System.out.println("not working");
        }
        onView(withId(R.id.btnLogin)).perform(click());
    }
}
