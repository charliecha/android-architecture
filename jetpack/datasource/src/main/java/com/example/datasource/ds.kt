package com.example.datasource

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import java.util.prefs.Preferences

// At the top level of your kotlin file:
//val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "settings")
//
//fun initDs() {
//    val EXAMPLE_COUNTER = intPreferencesKey("example_counter")
//    val exampleCounterFlow: Flow<Int> = context.dataStore.data
//        .map { preferences ->
//            // No type safety.
//            preferences[EXAMPLE_COUNTER] ?: 0
//        }
//}
