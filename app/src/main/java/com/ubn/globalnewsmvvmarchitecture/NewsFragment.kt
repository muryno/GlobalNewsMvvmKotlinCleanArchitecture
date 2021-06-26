package com.ubn.globalnewsmvvmarchitecture

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.ubn.globalnewsmvvmarchitecture.data.util.Resource
import com.ubn.globalnewsmvvmarchitecture.databinding.FragmentNewsHeadlineBinding
import com.ubn.globalnewsmvvmarchitecture.presentation.adapter.NewsAdapter
import com.ubn.globalnewsmvvmarchitecture.presentation.viewmodel.NewsViewModel
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class NewsFragment : Fragment() {
    private  lateinit var viewModel: NewsViewModel
    private lateinit var newsAdapter: NewsAdapter
    private lateinit var fragmentNewsBinding: FragmentNewsHeadlineBinding
    private var country = "ng"
    private var page = 1
    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_news_headline, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fragmentNewsBinding = FragmentNewsHeadlineBinding.bind(view)
        viewModel= (activity as MainActivity).viewModel
        newsAdapter = (activity as MainActivity).newsAdapter
        newsAdapter.setOnItemClickListener {


            val bundle = Bundle().apply {
                putSerializable("selected_article",it)
            }

            findNavController().navigate(R.id.action_newsHeadlineFragment_to_infoFragment,bundle)
        }
        initRecyclerView()
        viewNewsList()
        setSearchView()
    }

    private fun viewNewsList() {

        viewModel.getNewsHeadLines(country,page)
        viewModel.newsHeadLines.observe(viewLifecycleOwner,{response->
            when(response){
                is Resource.Success->{

                    hideProgressBar()
                    response.data?.let {
                        Log.i("MYTAG","came here ${it.articles.toList().size}")
                        newsAdapter.differ.submitList(it.articles.toList())
                    }
                }
                is Resource.Error->{
                    hideProgressBar()
                    response.message?.let {
                        Toast.makeText(activity,"An error occurred : $it", Toast.LENGTH_LONG).show()
                    }
                }

                is Resource.Loading->{
                    showProgressBar()
                }

            }
        })
    }

    private fun initRecyclerView() {

        fragmentNewsBinding.rvNews.apply {
            adapter = newsAdapter
            layoutManager = LinearLayoutManager(activity)
        }
    }

    private fun showProgressBar(){
        fragmentNewsBinding.progressBar.visibility = View.VISIBLE
    }

    private fun hideProgressBar(){
        fragmentNewsBinding.progressBar.visibility = View.INVISIBLE
    }

    private fun setSearchView(){
        fragmentNewsBinding.svNews.setOnQueryTextListener(
            object : SearchView.OnQueryTextListener{
                override fun onQueryTextSubmit(p0: String?): Boolean {
                    viewModel.getSearchNewsHeadLines(p0.toString(),"us",page)
                    viewNewsList()
                    return false
                }

                override fun onQueryTextChange(p0: String?): Boolean {
                    MainScope().launch {
                        delay(2000)
                        viewModel.getSearchNewsHeadLines(p0.toString(),"us",page)
                        viewNewsList()
                    }
                    return false
                }

            })

        fragmentNewsBinding.svNews.setOnCloseListener {
            initRecyclerView()
            viewNewsList()
            false
        }
    }
}