@file:Suppress("DEPRECATION")

package com.app.cv

import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.fragment_references.*
import java.util.jar.Manifest

class References : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
//        val intent = Intent(Intent.ACTION_DIAL)
//        intent.data = Uri.parse("tel:123 456789")
//        startActivity(intent)

        val view: View = inflater.inflate(R.layout.fragment_references, container, false)
        return view
    }
    
}

//    private fun call() {
//        if (ContextCompat.checkSelfPermission(
//                requireContext(),
//                android.Manifest.permission.CALL_PHONE
//            ) == PackageManager.PERMISSION_GRANTED
//        ) {
//            val callIntent = Intent(Intent.ACTION_CALL)
//            callIntent.data = Uri.parse("tel:" + "123")
//            requireActivity().startActivity(callIntent)
//        } else {
//            ActivityCompat.requestPermissions(
//                requireActivity(), arrayOf(android.Manifest.permission.CALL_PHONE),
//                References.CALL_PERMISSION_REQUEST_CODE
//            )
//        }
//    }
//    override fun onRequestPermissionsResult(
//        requestCode: Int,
//        permissions: Array<String>,
//        grantResults: IntArray
//    ) {
//        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
//        if (requestCode == CALL_PERMISSION_REQUEST_CODE && grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
//            Toast.makeText(context, "Permission Granted", Toast.LENGTH_SHORT).show()
//        }
//    }
//
//    companion object {
//        private const val CALL_PERMISSION_REQUEST_CODE = 1234
//    }


