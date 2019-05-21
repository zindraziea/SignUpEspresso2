package com.sourcey.materiallogindemo.Page

/**
 * Created by JirathEak on 17/3/2018 AD.
 */

import android.content.ContentValues
import android.util.Log
import android.view.View
import android.support.test.espresso.Espresso
import android.support.test.espresso.UiController
import android.support.test.espresso.ViewAction
import android.support.test.espresso.ViewInteraction
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers
import android.support.test.espresso.matcher.ViewMatchers.isDisplayed
import android.support.test.espresso.util.TreeIterables
import org.hamcrest.Matcher
import java.util.concurrent.CountDownLatch

private val TIMEOUT_MILLISECONDS = 5000
private val SLEEP_MILLISECONDS = 100
private var time = 0
private var wasDisplayed = false

@Throws(InterruptedException::class)
fun isVisible(interaction: ViewInteraction, millis: Long=TIMEOUT_MILLISECONDS.toLong()): Boolean? {
    interaction.withFailureHandler({ error, viewMatcher -> wasDisplayed = false })
    if (wasDisplayed) {
        return true
    }
    if (time >= millis) {
        return false
    }

    //set it to true if failing handle should set it to false again.
    wasDisplayed = true
    Thread.sleep(SLEEP_MILLISECONDS.toLong())
    time += SLEEP_MILLISECONDS

    interaction.check(matches(isDisplayed()))
    Log.i("ViewChecker", "sleeping")
    return isVisible(interaction)
}

@Throws(InterruptedException::class)
fun isVisible(viewMatcher: Matcher<View>, millis: Long=TIMEOUT_MILLISECONDS.toLong()): Boolean? {
    val found = arrayOfNulls<Boolean>(1)

    val latch = CountDownLatch(1)
    val action = object : ViewAction {
        override fun getConstraints(): Matcher<View> {
            return ViewMatchers.isRoot()
        }

        override fun getDescription(): String {
            return "wait for a specific view with id <$viewMatcher> during $millis millis."
        }

        override fun perform(uiController: UiController, view: View) {
            uiController.loopMainThreadUntilIdle()
            val startTime = System.currentTimeMillis()
            val endTime = startTime + millis


            do {
                for (child in TreeIterables.breadthFirstViewTraversal(view)) {

                    if (viewMatcher.matches(child)) {
                        Log.d(ContentValues.TAG, "perform: found match")
                        found[0] = true
                        latch.countDown()
                        return
                    }
                }

                uiController.loopMainThreadForAtLeast(SLEEP_MILLISECONDS.toLong())
            } while (System.currentTimeMillis() < endTime)

            found[0] = false
            latch.countDown()
        }
    }
    Espresso.onView(ViewMatchers.isRoot()).perform(action)

    latch.await()
    return found[0]
}

open class BasePage{}