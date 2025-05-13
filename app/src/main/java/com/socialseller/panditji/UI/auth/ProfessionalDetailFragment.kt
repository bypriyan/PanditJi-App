package com.socialseller.panditji.UI.auth

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.view.setPadding
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import com.socialseller.panditji.R

class ProfessionalDetailFragment : Fragment() {

    private lateinit var pujaTypeEditText: EditText
    private lateinit var pujaContainer: LinearLayout
    private lateinit var submitButton: Button
    private val pujaTypes = arrayOf("Puja", "Kundali", "Vastu", "Horoscope")
    private val selectedItems = mutableListOf<String>()
    private val checkedItems = BooleanArray(pujaTypes.size)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_professional_detail, container, false)

        pujaTypeEditText = view.findViewById(R.id.pujaTypeEditText)
        pujaContainer = view.findViewById(R.id.pujaContainer)
        submitButton = view.findViewById(R.id.submitButton)
        pujaTypeEditText.setOnClickListener {
            showPujaTypeDialog()
        }

        return view
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
            submitButton.setOnClickListener {
                findNavController().navigate(R.id.action_professionalDetailsFragment_to_BioFragment)

        }
    }

    private fun showPujaTypeDialog() {
        AlertDialog.Builder(requireContext())
            .setTitle("Select Puja Types")
            .setMultiChoiceItems(pujaTypes, checkedItems) { _, which, isChecked ->
                if (isChecked) {
                    selectedItems.add(pujaTypes[which])
                } else {
                    selectedItems.remove(pujaTypes[which])
                }
            }
            .setPositiveButton("OK") { _, _ ->
                pujaTypeEditText.setText(selectedItems.joinToString(", "))
                displaySelectedPujas()
            }
            .setNegativeButton("Cancel", null)
            .show()
    }

    private fun displaySelectedPujas() {
        pujaContainer.removeAllViews()

        for (puja in selectedItems) {
            // Puja Title
            val pujaTitle = TextView(requireContext()).apply {
                text = puja
                textSize = 14f
                setPadding(12)
            }
            pujaContainer.addView(pujaTitle)

            // Chat Rate Field
            pujaContainer.addView(createCustomStyledEditText("Chat Rate"))

            // Call Rate Field
            pujaContainer.addView(createCustomStyledEditText("Call Rate"))
        }
    }

    private fun createCustomStyledEditText(hint: String): View {
        val context = requireContext()

        // Container layout
        val container = LinearLayout(context).apply {
            layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            ).apply {
                setMargins(0, 12, 0, 0)
            }
            orientation = LinearLayout.VERTICAL
        }

        // TextInputLayout (no outline style, just container)
        val textInputLayout = TextInputLayout(context).apply {
            layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            ).apply {
                setMargins(0, 12, 0, 0)
            }
            isHintEnabled = false
        }

        // Custom EditText
        val editText = TextInputEditText(context).apply {
            layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            ).apply {
                setPadding(48)
                setTextSize(16F)
            }
            setBackgroundResource(R.drawable.white_bg_greay_outline_background)
            this.hint = hint
            setTextColor(resources.getColor(R.color.black, null))
            setHintTextColor(resources.getColor(R.color.greay, null))
        }

        textInputLayout.addView(editText)
        container.addView(textInputLayout)
        return container
    }


}
