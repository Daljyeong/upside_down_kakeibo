package com.example.kakeibo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.kakeibo.databinding.FragmentAddHistoryMainBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment


class AddHistoryMainFragment : BottomSheetDialogFragment() {
    private lateinit var viewBinding: FragmentAddHistoryMainBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewBinding = FragmentAddHistoryMainBinding.inflate(layoutInflater)

        //'완료', '취소' 버튼 눌렀을 때 dialog dismiss 되도록 구현한 부분
        viewBinding.btnAddHistoryMainDone.setOnClickListener {
            Toast.makeText(context, "완료", Toast.LENGTH_SHORT).show()
            dismiss()
        }
        viewBinding.btnAddHistoryMainCancel.setOnClickListener {
            Toast.makeText(context, "취소", Toast.LENGTH_SHORT).show()
            dismiss()
        }
        viewBinding.btnAddHistoryMainBigDone.setOnClickListener {
            Toast.makeText(context, "완료", Toast.LENGTH_SHORT).show()
            dismiss()
        }

        return viewBinding.root
    }
}