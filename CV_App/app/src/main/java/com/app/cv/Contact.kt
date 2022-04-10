package com.app.cv

import android.app.AlertDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.add_new_skill_layout.view.*
import kotlinx.android.synthetic.main.fragment_contact.view.*
import kotlinx.android.synthetic.main.fragment_skills.view.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Contact.newInstance] factory method to
 * create an instance of this fragment.
 */
class Contact : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        setHasOptionsMenu(true)
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view: View = inflater.inflate(R.layout.fragment_contact, container, false)

        view.website.setOnClickListener {
            var webView: WebView = view.findViewById(R.id.web)
            
            webView.loadUrl("http://www.google.com");

            webView.getSettings().setJavaScriptEnabled(true);

            webView.webViewClient = WebViewClient()

        }


        return view
    }

}