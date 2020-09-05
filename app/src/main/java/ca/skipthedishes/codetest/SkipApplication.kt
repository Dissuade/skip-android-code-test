package ca.skipthedishes.codetest

import android.app.Application
import com.facebook.drawee.backends.pipeline.Fresco

class SkipApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        Fresco.initialize(this)
    }
}