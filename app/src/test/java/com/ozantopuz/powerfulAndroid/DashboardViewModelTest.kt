package com.ozantopuz.powerfulAndroid

import com.ozantopuz.powerfulAndroid.core.utils.Constants
import com.ozantopuz.powerfulAndroid.data.entity.Movie
import com.ozantopuz.powerfulAndroid.data.repository.MovieRepository
import com.ozantopuz.powerfulAndroid.scene.dashboard.viewmodel.DashboardViewModel
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.observers.TestObserver
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class DashboardViewModelTest {

    @Mock
    private lateinit var movieRepository: MovieRepository

    private lateinit var dashboardViewModel: DashboardViewModel

    /*@Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        dashboardViewModel = DashboardViewModel(movieRepository)
    }

    @Test
    fun showDataFromApi() {
        Mockito.`when`(movieRepository.getMovies(Constants.LANGUAGE, Constants.PAGE)).thenReturn(Observable.just(List<Movie>(Movie())))

        val testObserver = TestObserver<List<Movie>>()

        dashboardViewModel.movies()
            .subscribe(testObserver)

        testObserver.assertNoErrors()
        testObserver.assertValue { it[0].id.equals(1) }
    }*/
}
