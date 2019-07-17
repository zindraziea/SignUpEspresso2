package com.sourcey.materiallogindemo.utility

import android.view.WindowManager
import android.support.test.espresso.Root
import org.hamcrest.Description;
import org.hamcrest.TypeSafeMatcher;
class ToastMatcher : TypeSafeMatcher<Root>() {

    override fun describeTo(description: Description) {
        description.appendText("is toast")
    }

    override fun matchesSafely(root: Root): Boolean {
        val type = root.getWindowLayoutParams().get().type
        if (type == WindowManager.LayoutParams.TYPE_TOAST) {
            val windowToken = root.getDecorView().getWindowToken()
            val appToken = root.getDecorView().getApplicationWindowToken()
            if (windowToken === appToken) {
                return true
            }
        }
        return false
    }
}