package com.android.developer.expert.presentation.favorite

import androidx.navigation.navGraphViewModels
import com.DetailActivity
import com.android.developer.expert.R
import com.android.developer.expert.databinding.ItemDiscoverBinding
import id.xxx.the.movie.db.domain.model.ItemModel
import id.xxx.the.movie.db.domain.model.Type
import id.xxx.the.movie.db.domain.model.putType
import com.android.developer.expert.presentation.MainFragment
import com.android.developer.expert.presentation.detail.DetailActivity.Companion.DATA_EXTRA
import id.xxx.base.presentation.extension.openActivity

open class FavoriteMovieFragment : MainFragment() {

    protected val viewModel: FavoriteViewModel by navGraphViewModels(R.id.nav_graph_main) {
        (parentFragment as FavoriteFragment).viewModelFactory
    }

    override fun getData() = viewModel.movieFav

    override fun getStatScroll() = viewModel.statScroll

    override fun saveStatScroll(scrollPosition: Int, key: String) {
        viewModel.statScroll[key] = scrollPosition
    }

    override fun onItemClick(viewBinding: ItemDiscoverBinding, model: ItemModel) {
        openActivity<DetailActivity> {
            putType(getType(model.id))
            putExtra(DATA_EXTRA, true)
        }
    }

    override fun getType(id: Int): Type<Int> = Type.Movie(id)
}