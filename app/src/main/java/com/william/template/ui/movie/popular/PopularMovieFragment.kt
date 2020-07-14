package com.william.template.ui.movie.popular

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.william.template.R
import com.william.template.databinding.FragmentPopularMovieBinding
import com.william.template.model.domain.Movie
import com.william.template.ui.base.DataBindingViewHolder
import com.william.template.ui.themeinfo.ThemeInfoBottomSheet
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PopularMovieFragment : Fragment() {

    private val popularMovieViewModel by viewModels<PopularMovieViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentPopularMovieBinding.inflate(inflater).apply {
            lifecycleOwner = viewLifecycleOwner
        }

        val adapter = PopularMovieAdapter().apply {
            onItemClickListener = object : DataBindingViewHolder.OnItemClickListener<Movie> {
                override fun onItemClicked(item: Movie, position: Int) {
                    Toast.makeText(context, item.title, Toast.LENGTH_SHORT).show()
                }
            }
        }

        binding.movieList.adapter = adapter
//        PagerSnapHelper().attachToRecyclerView(binding.movieList)

        popularMovieViewModel.popularMovieList.observe(viewLifecycleOwner, Observer {
            adapter.submitList(it)
        })

        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.theme_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menu_theme -> {
                ThemeInfoBottomSheet().show(
                    childFragmentManager,
                    ThemeInfoBottomSheet::class.simpleName
                )
            }
        }
        return true
    }
}