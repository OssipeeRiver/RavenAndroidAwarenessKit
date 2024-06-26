package com.ossipeeriver.ravenandroidawarenesskit.ui.location

import android.util.Log
import androidx.annotation.WorkerThread
import com.ossipeeriver.ravenandroidawarenesskit.location_db.SavedLocation
import com.ossipeeriver.ravenandroidawarenesskit.location_db.SavedLocationDao
import kotlinx.coroutines.flow.Flow

class LocationRepository(private val locationDao: SavedLocationDao) {
    // Room executes all queries on a separate thread
    // Observed Flow will notify the observer when the data has changed
    val allLocations: Flow<List<SavedLocation>> = locationDao.getSavedLocationById()
    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insert(location: SavedLocation) {
        locationDao.insertLocation(location)
        Log.d("LOCATION REPOSITORY", "upserting location to database")
    }
}