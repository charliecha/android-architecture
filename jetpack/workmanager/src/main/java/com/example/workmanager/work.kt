package com.example.workmanager

import android.content.Context
import android.util.Log
import androidx.work.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext

class CoroutineDownloadWork(context: Context, params : WorkerParameters)
    : CoroutineWorker(context, params) {
    override suspend fun doWork(): Result {
        withContext(Dispatchers.IO) {
            downloadSync()
        }
        return Result.success()
    }
}

suspend fun downloadSync() {
    Log.i("work", "begin downloadSync ${Thread.currentThread().name}")
    delay(3000L)
    Log.i("work", "end downloadSync ${Thread.currentThread().name}")
}

class UploadWorker(appContext: Context, workerParams: WorkerParameters):
    Worker(appContext, workerParams) {
    override fun doWork(): Result {

        // Do the work here--in this case, upload the images.
        uploadImages()

        // Indicate whether the work finished successfully with the Result
        return Result.success()
    }
}

fun uploadImages() {
    Log.i("work", "begin ${Thread.currentThread().name}")
//    Thread.sleep(3000)
    Log.i("work", "end ")
}

val uploadWorkRequest: WorkRequest =
    OneTimeWorkRequestBuilder<UploadWorker>()
        .build()

val downloadWorkRequest: WorkRequest =
    OneTimeWorkRequestBuilder<CoroutineDownloadWork>()
        .build()

fun work(myContext : Context) {
//    WorkManager
//        .getInstance(myContext)
//        .enqueue(uploadWorkRequest)

    WorkManager.getInstance(myContext).enqueue(downloadWorkRequest)
}

