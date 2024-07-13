package com.example.moviedevappimport android.os.Bundleimport androidx.activity.ComponentActivityimport androidx.activity.compose.setContentimport com.example.feature.movies.di.DaggerMoviesComponentimport com.example.feature.movies.presentation.ui.MoviesScreenimport com.example.moviedevapp.moviesapp.MoviesApplicationimport com.example.moviedevapp.ui.theme.MovieDevAppThemeimport com.example.network.di.DaggerNetworkComponentclass MainActivity : ComponentActivity() {    override fun onCreate(savedInstanceState: Bundle?) {        super.onCreate(savedInstanceState)        val appComponent = (applicationContext as MoviesApplication).appComponent        val networkComponent = DaggerNetworkComponent.create()        val moviesComponent = DaggerMoviesComponent            .factory()            .createNetworkApi(networkComponent)        appComponent.inject(this)        setContent {            MovieDevAppTheme {                MoviesScreen(store = moviesComponent.getMoviesStore())            }        }    }}