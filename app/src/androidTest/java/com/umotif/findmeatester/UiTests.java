package com.umotif.findmeatester;

import android.content.Context;
import android.os.SystemClock;
import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.ViewInteraction;
import android.support.test.runner.AndroidJUnit4;
import android.support.test.rule.ActivityTestRule;

import com.umotif.findmeatester.requestmultiplication.ui.activity.MultiplicationActivity;

import org.junit.Assert;
import org.junit.Test;
import org.junit.Rule;
import org.junit.runner.RunWith;


import static android.support.test.espresso.matcher.RootMatchers.withDecorView;
import static android.support.test.espresso.matcher.ViewMatchers.hasFocus;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.*;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;


import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;


/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class UiTests {
    @Rule
    public ActivityTestRule<MultiplicationActivity> mActivityRule =
            new ActivityTestRule<>(MultiplicationActivity.class);

    @Test
    public void useAppContext() throws Exception {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("com.umotif.findmeatester", appContext.getPackageName());
    }
    @Test
    // Check that the input fields are displayed on the screen
    public void checkInputFieldsDisplayed() throws Exception {
        onView(withId(R.id.first_input_edit_text)).check(matches(isDisplayed()));
        onView(withId(R.id.second_input_edit_text)).check(matches(isDisplayed()));
    }
    @Test
    // Check that the REQUEST button is displayed on the screen
    public void checkRequestButtonDisplayed() throws Exception {
        onView(withId(R.id.make_request_button)).check(matches(isDisplayed()));
    }
    @Test
    //Check that the input fields become focussed when the user clicks on them
    public void clickToFocus() throws Exception {
        onView(withId(R.id.first_input_edit_text)).perform(click());
        onView(withId(R.id.first_input_edit_text)).check(matches((hasFocus())));
        //do the same thing for the second input field
        onView(withId(R.id.second_input_edit_text)).perform(click());
        onView(withId(R.id.second_input_edit_text)).check(matches((hasFocus())));
    }
    @Test
    // Checck that the user can enter text into the first input field
    public void enterTextField1() throws Exception {
        onView(withId(R.id.first_input_edit_text)).perform(typeText("42"));
        onView(withId(R.id.first_input_edit_text)).check(matches(withText("42")));
    }
    @Test
    // Check that the user can enter text into the second input field
    public void enterTextField2() throws Exception {
        onView(withId(R.id.second_input_edit_text)).perform(typeText("1001"));
        onView(withId(R.id.second_input_edit_text)).check(matches(withText("1001")));
    }
    @Test
    // Check that a valid input gives the correct result
    public void verifyCorrectResultValidInput() throws Exception {
        onView(withId(R.id.first_input_edit_text)).perform(typeText("3"));
        onView(withId(R.id.second_input_edit_text)).perform(typeText("4"));
        onView(withId(R.id.make_request_button)).perform(click());
        // check to see if a toast message is displayed
        onView(withText("12.0"))
                .inRoot(withDecorView(not(mActivityRule.getActivity().getWindow().getDecorView())))
                .check(matches(isDisplayed()));
    }
    @Test
    // Check that an invalid input gives the correct result
    public void verifyCorrectResultInvalidInput() throws Exception {
        onView(withId(R.id.first_input_edit_text)).perform(typeText("3"));
        onView(withId(R.id.second_input_edit_text)).perform(typeText("Jeff"));
        onView(withId(R.id.make_request_button)).perform(click());
        // check to see if a toast message is displayed
        onView(withText("NaN"))
                .inRoot(withDecorView(not(mActivityRule.getActivity().getWindow().getDecorView())))
                .check(matches(isDisplayed()));
    }

}
