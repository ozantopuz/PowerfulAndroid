package com.ozantopuz.powerfulAndroid

import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import com.ozantopuz.powerfulAndroid.scene.dashboard.view.DashboardActivity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class DashboardActivityTest {

    @get:Rule
    val mActivityRule: ActivityTestRule<DashboardActivity> = ActivityTestRule(DashboardActivity::class.java)

    @Test
    fun clickRecyclerViewItems() {
        //onView(withId(R.id.movieRecyclerView)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, ViewActions.click()))
    }
}