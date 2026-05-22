package org.subham.travenor.di

import androidx.datastore.core.FileStorage
import androidx.datastore.core.Storage
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.PreferencesFileSerializer
import androidx.datastore.preferences.core.PreferencesSerializer
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import org.subham.data.datasource.dataStoreFileName
import java.io.File

actual fun platformModule() = module {
    single<String> { "http://10.0.2.2:8080" }


    single<Storage<Preferences>> {
        FileStorage(
            serializer = PreferencesFileSerializer,
            produceFile = {
                androidContext().filesDir.resolve(dataStoreFileName)
            }
        )
    }


}


