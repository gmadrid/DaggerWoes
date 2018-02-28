package com.scrawlsoft.daggerwoes

import android.app.Application
import dagger.Component
import dagger.Module
import dagger.Provides
import javax.inject.Named
import javax.inject.Singleton

@Module
class AppModule(private val app: Application) {
    @Provides
    @Named("someStringWithAName")
    fun provideSomeStringWithAName(): String = "THESTRINGWITHANAME"

    @Provides
    @Named("someStringOrNull")
    fun provideSomeStringOrNull(): String? = "STRING OR NULL"
}

@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {
    fun inject(target: MainActivity)
}

class DaggerWoesApp : Application() {
    lateinit var appComponent: AppComponent

    private fun createAppComponent() = DaggerAppComponent.builder()
            .appModule(AppModule(this))
            .build()

    override fun onCreate() {
        super.onCreate()
        appComponent = createAppComponent()
    }
}