package org.foi.mmatijevi.air.virtualmarketplacetest

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.fragment.app.Fragment

class RegisterTypeFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_register_type, container, false)

        val buyerRadioButton = view.findViewById<RadioButton>(R.id.rbBuyer)
        val sellerRadioButton = view.findViewById<RadioButton>(R.id.rbSeller)
        val radioButtonGroup = view.findViewById<RadioGroup>(R.id.rbGroup)
        val nextButton = view.findViewById<Button>(R.id.btnNext)

        radioButtonGroup.setOnCheckedChangeListener { _, _ -> nextButton.isEnabled = true  }

        nextButton.setOnClickListener {
            var userType : String? = null

            if (buyerRadioButton.isChecked) {
                userType = "BUYER"
            } else if (sellerRadioButton.isChecked) {
                userType = "SELLER"
            }

            if (userType != null) {
                Toast.makeText(context, "You are a ${userType.lowercase()}!", Toast.LENGTH_SHORT).show()
            }
        }

        return view
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            RegisterTypeFragment().apply {
                arguments = Bundle().apply { }
            }
    }
}