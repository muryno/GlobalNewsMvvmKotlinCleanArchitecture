package com.ubn.globalnewsmvvmarchitecture

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.ubn.globalnewsmvvmarchitecture.data.util.Resource
import com.ubn.globalnewsmvvmarchitecture.databinding.FragmentNewsHeadlineBinding
import com.ubn.globalnewsmvvmarchitecture.presentation.adapter.NewsAdapter
import com.ubn.globalnewsmvvmarchitecture.presentation.viewmodel.NewsViewModel

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
        initRecyclerView()
        viewNewsList()
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
        newsAdapter = NewsAdapter()
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
}