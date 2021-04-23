package com.example.appstartup

import android.content.Context
import androidx.startup.AppInitializer
import androidx.startup.Initializer
import androidx.work.Configuration
import androidx.work.WorkManager

fun init(context: Context) {
    AppInitializer.getInstance(context)
        .initializeComponent(ExampleLoggerInitializer::class.java).log()
}

// Initializes WorkManager.
class WorkManagerInitializer : Initializer<WorkManager> {
    override fun create(context: Context): WorkManager {
        val configuration = Configuration.Builder().build()
        WorkManager.initialize(context, configuration)
        return WorkManager.getInstance(context)
    }
    override fun dependencies(): List<Class<out Initializer<*>>> {
        // No dependencies on other libraries.
        return emptyList()
    }
}

// Initializes ExampleLogger.
class ExampleLoggerInitializer : Initializer<ExampleLogger> {
    override fun create(context: Context): ExampleLogger {
        // WorkManager.getInstance() is non-null only after
        // WorkManager is initialized.
        return ExampleLogger(WorkManager.getInstance(context))
    }

    override fun dependencies(): List<Class<out Initializer<*>>> {
        // Defines a dependency on WorkManagerInitializer so it can be
        // initialized after WorkManager is initialized.
        return listOf(WorkManagerInitializer::class.java)
    }
}

class ExampleLogger(val workManager: WorkManager) {
    fun log() {

    }
}