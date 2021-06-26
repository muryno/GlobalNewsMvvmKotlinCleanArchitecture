package com.ubn.globalnewsmvvmarchitecture

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebViewClient
import androidx.navigation.fragment.navArgs
import com.ubn.globalnewsmvvmarchitecture.databinding.FragmentInfoBinding
import com.ubn.globalnewsmvvmarchitecture.presentation.viewmodel.NewsViewModel


class InfoFragment : Fragment() {
    private lateinit var fragmentInfoBinding: FragmentInfoBinding

    private lateinit var viewModel : NewsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_info, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel=(activity as MainActivity).viewModel


        fragmentInfoBinding = FragmentInfoBinding.bind(view)


        fragmentInfoBinding = FragmentInfoBinding.bind(view)
        val args : InfoFragmentArgs by navArgs()
        val article = args.selectedArticle
        fragmentInfoBinding.wvInfo.apply {
            webViewClient = WebViewClient()
            if(article.url!="") {
                loadUrl(article.url.toString())
            }
        }

        fragmentInfoBinding.fabSave.setOnClickListener {
            viewModel.saveArticle(article)
        }

    }
}

