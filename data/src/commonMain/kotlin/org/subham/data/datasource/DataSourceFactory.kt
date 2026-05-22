package org.subham.data.datasource

import androidx.datastore.core.DataStore
import androidx.datastore.core.DataStoreFactory
import androidx.datastore.core.Storage
import androidx.datastore.preferences.core.PreferenceDataStoreFactory
import androidx.datastore.preferences.core.Preferences
import okio.Path.Companion.toPath


fun createDataStore(
    storage: Storage<Preferences>
): DataStore<Preferences> = DataStoreFactory.create(storage = storage)

const val dataStoreFileName = "travenor.datastore.preferences_pd"