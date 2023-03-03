package com.example.kakeibo

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.fragment.app.DialogFragment.STYLE_NORMAL
import com.example.kakeibo.databinding.FragmentAddHistoryMainBinding
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialogFragment


class AddHistoryMainFragment : BottomSheetDialogFragment() {
    private lateinit var viewBinding: FragmentAddHistoryMainBinding
    var icLiving = false
    var icFood = false
    var icCafe = false
    var icTransportation = false
    var icFashion = false
    var icCommunication = false
    var icHealth = false
    var icLearn = false
    var icCulture = false
    var icBeauty = false
    var icPet = false
    var icGift = false

    var recyclerSum = 0

    //dialog 높이 지정
    override fun onStart() {
        super.onStart()
        view?.viewTreeObserver?.addOnGlobalLayoutListener {
            val behavior = BottomSheetBehavior.from(requireView().parent as View)
            behavior.peekHeight = 1700
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewBinding = FragmentAddHistoryMainBinding.inflate(inflater, container, false)

        //아이콘 단일선택 클릭 구현한 부분
        viewBinding.icUnselectedLiving.setOnClickListener {
            icLiving = radioButton(
                viewBinding.icUnselectedLiving,
                icLiving,
                R.drawable.ic_selected_living
            )
        }
        viewBinding.icUnselectedFood.setOnClickListener {
            icFood = radioButton(
                viewBinding.icUnselectedFood,
                icFood,
                R.drawable.ic_selected_food
            )
        }
        viewBinding.icUnselectedCafe.setOnClickListener {
            icCafe = radioButton(
                viewBinding.icUnselectedCafe,
                icCafe,
                R.drawable.ic_selected_cafe
            )
        }
        viewBinding.icUnselectedTransportation.setOnClickListener {
            icTransportation = radioButton(
                viewBinding.icUnselectedTransportation,
                icTransportation,
                R.drawable.ic_selected_transportation
            )
        }
        viewBinding.icUnselectedFashion.setOnClickListener {
            icFashion = radioButton(
                viewBinding.icUnselectedFashion,
                icFashion,
                R.drawable.ic_selected_fashion
            )
        }
        viewBinding.icUnselectedCommunication.setOnClickListener {
            icCommunication = radioButton(
                viewBinding.icUnselectedCommunication,
                icCommunication,
                R.drawable.ic_selected_communication
            )
        }
        viewBinding.icUnselectedHealth.setOnClickListener {
            icHealth = radioButton(
                viewBinding.icUnselectedHealth,
                icHealth,
                R.drawable.ic_selected_health
            )
        }
        viewBinding.icUnselectedLearn.setOnClickListener {
            icLearn = radioButton(
                viewBinding.icUnselectedLearn,
                icLearn,
                R.drawable.ic_selected_learn
            )
        }
        viewBinding.icUnselectedCulture.setOnClickListener {
            icCulture = radioButton(
                viewBinding.icUnselectedCulture,
                icCulture,
                R.drawable.ic_selected_culture
            )
        }
        viewBinding.icUnselectedBeauty.setOnClickListener {
            icBeauty = radioButton(
                viewBinding.icUnselectedBeauty,
                icBeauty,
                R.drawable.ic_selected_beauty
            )
        }
        viewBinding.icUnselectedPet.setOnClickListener {
            icPet = radioButton(
                viewBinding.icUnselectedPet,
                icPet,
                R.drawable.ic_selected_pet
            )
        }
        viewBinding.icUnselectedGift.setOnClickListener {
            icGift = radioButton(
                viewBinding.icUnselectedGift,
                icGift,
                R.drawable.ic_selected_gift
            )
        }

        val bundle = Bundle()

        //'취소' 버튼 눌렀을 때 dialog dismiss 되도록 구현한 부분
        viewBinding.btnAddHistoryMainCancel.setOnClickListener {
//            Toast.makeText(context, "취소", Toast.LENGTH_SHORT).show()
            dismiss()

            //EditText 부분 init
            viewBinding.tvAddHistoryMainContentBox.setText("") //내용
            viewBinding.tvAddHistoryMainMoneyBox.setText("") //금액 입력
            viewBinding.tvAddHistoryMainMemoBox.setText("") //한 줄 메모
        }

        //우측 상단 '완료' 버튼 눌렀을 때 실행되는 부분
        viewBinding.btnAddHistoryMainDone.setOnClickListener {
//            Toast.makeText(context, "완료", Toast.LENGTH_SHORT).show()
            bundle.putInt("dataIcn", resultRadio())
            bundle.putString(
                "dataContent",
                viewBinding.tvAddHistoryMainContentBox.text.toString()
            ) //내용
            bundle.putString(
                "dataMoney",
                viewBinding.tvAddHistoryMainMoneyBox.text.toString()
            ) //금액 입력
            bundle.putString(
                "dataMemo",
                viewBinding.tvAddHistoryMainMemoBox.text.toString()
            ) //한 줄 메모
            ((activity as MainActivity).supportFragmentManager
                .findFragmentById(R.id.fragment) as HomeFragment).arguments = bundle
            ((activity as MainActivity).supportFragmentManager
                .findFragmentById(R.id.fragment) as HomeFragment).initAddData()

            //프로그레스 바 높이 설정
            ((activity as MainActivity).supportFragmentManager
                .findFragmentById(R.id.fragment) as HomeFragment).setProgressBarHeight(
                progressBarHeight(viewBinding.tvAddHistoryMainMoneyBox.text.toString())
            )

            dismiss()

            //EditText 부분 init
            viewBinding.tvAddHistoryMainContentBox.setText("") //내용
            viewBinding.tvAddHistoryMainMoneyBox.setText("") //금액 입력
            viewBinding.tvAddHistoryMainMemoBox.setText("") //한 줄 메모
        }

        //중앙 하단 '완료' 버튼 눌렀을 때 실행되는 부분
        viewBinding.btnAddHistoryMainBigDone.setOnClickListener {
//            Toast.makeText(context, "완료", Toast.LENGTH_SHORT).show()
            bundle.putInt("dataIcn", resultRadio())
            bundle.putString(
                "dataContent",
                viewBinding.tvAddHistoryMainContentBox.text.toString()
            ) //내용
            bundle.putString(
                "dataMoney",
                viewBinding.tvAddHistoryMainMoneyBox.text.toString()
            ) //금액 입력
            bundle.putString(
                "dataMemo",
                viewBinding.tvAddHistoryMainMemoBox.text.toString()
            ) //한 줄 메모
            ((activity as MainActivity).supportFragmentManager
                .findFragmentById(R.id.fragment) as HomeFragment).arguments = bundle
            ((activity as MainActivity).supportFragmentManager
                .findFragmentById(R.id.fragment) as HomeFragment).initAddData()

            //프로그레스 바 높이 설정
            ((activity as MainActivity).supportFragmentManager
                .findFragmentById(R.id.fragment) as HomeFragment).setProgressBarHeight(
                progressBarHeight(viewBinding.tvAddHistoryMainMoneyBox.text.toString())
            )

            dismiss()

            //EditText 부분 init
            viewBinding.tvAddHistoryMainContentBox.setText("") //내용
            viewBinding.tvAddHistoryMainMoneyBox.setText("") //금액 입력
            viewBinding.tvAddHistoryMainMemoBox.setText("") //한 줄 메모
        }
        return viewBinding.root
    }

    //아이콘들이 radioButton(단일선택)처럼 작동하게 하는 함수
    fun radioButton(
        iconId: ImageButton,
        checkNum: Boolean,
        selectedImg: Int
    ): Boolean {
        return if (checkNum) { //selected -> unselected
            initRadioBox()
            false
        } else { //unselected -> selected
            initRadioBox()
            iconId.setImageResource(selectedImg)
            true
        }
    }

    //모든 아이콘의 이미지를 unselected, Boolean 변수를 false로 init하는 함수
    fun initRadioBox() {
        viewBinding.icUnselectedLiving.setImageResource(R.drawable.ic_unselected_living)
        viewBinding.icUnselectedFood.setImageResource(R.drawable.ic_unselected_food)
        viewBinding.icUnselectedCafe.setImageResource(R.drawable.ic_unselected_cafe)
        viewBinding.icUnselectedTransportation.setImageResource(R.drawable.ic_unselected_transportation)
        viewBinding.icUnselectedFashion.setImageResource(R.drawable.ic_unselected_fashion)
        viewBinding.icUnselectedCommunication.setImageResource(R.drawable.ic_unselected_communication)

        viewBinding.icUnselectedHealth.setImageResource(R.drawable.ic_unselected_health)
        viewBinding.icUnselectedLearn.setImageResource(R.drawable.ic_unselected_learn)
        viewBinding.icUnselectedCulture.setImageResource(R.drawable.ic_unselected_culture)
        viewBinding.icUnselectedBeauty.setImageResource(R.drawable.ic_unselected_beauty)
        viewBinding.icUnselectedPet.setImageResource(R.drawable.ic_unselected_pet)
        viewBinding.icUnselectedGift.setImageResource(R.drawable.ic_unselected_gift)

        icLiving = false
        icFood = false
        icCafe = false
        icTransportation = false
        icFashion = false
        icCommunication = false
        icHealth = false
        icLearn = false
        icCulture = false
        icBeauty = false
        icPet = false
        icGift = false
    }

    //Boolean값이 true인 아이콘(사용자가 최종으로 선택한 아이콘)의 halfselected 이미지를 return하는 함수
    fun resultRadio(): Int {
        if (icLiving)
            return R.drawable.ic_halfselected_living
        if (icFood)
            return R.drawable.ic_halfselected_food
        if (icCafe)
            return R.drawable.ic_halfselected_cafe
        if (icTransportation)
            return R.drawable.ic_halfselected_transportation
        if (icFashion)
            return R.drawable.ic_halfselected_fashion
        if (icCommunication)
            return R.drawable.ic_halfselected_communication
        if (icHealth)
            return R.drawable.ic_halfselected_health
        if (icLearn)
            return R.drawable.ic_halfselected_learn
        if (icCulture)
            return R.drawable.ic_halfselected_culture
        if (icBeauty)
            return R.drawable.ic_halfselected_beauty
        if (icPet)
            return R.drawable.ic_halfselected_pet
        if (icGift)
            return R.drawable.ic_halfselected_gift

        return 0
    }

    //프로그레스바 높이 return하는 함수
    @SuppressLint("ResourceType")
    fun progressBarHeight(recyclerNowInput: String): Int {
        val recyclerNow: Int = recyclerNowInput.toInt() //리사이클러뷰로 입력된 금액 하나

        //HomeFragment의 오늘 소비 가능 금액
        val todaySpend = ((activity as MainActivity).supportFragmentManager
            .findFragmentById(R.id.fragment) as HomeFragment).fixedTodayAvailable

//        //고정된 오늘 소비 가능 금액
//        val fixedTodaySpend = ((activity as MainActivity).supportFragmentManager
//            .findFragmentById(R.id.fragment) as HomeFragment).todayAvailable

        recyclerSum += recyclerNow //리사이클러뷰로 입력된 총 금액

//        Toast.makeText(context, "입력된 금액 하나 = $recyclerNow", Toast.LENGTH_SHORT).show()
//        Toast.makeText(context, "오늘 소비 가능 = $todaySpend", Toast.LENGTH_SHORT).show()
//        Toast.makeText(context, "리클 총금액 = $recyclerSum", Toast.LENGTH_SHORT).show()
//        val result = (recyclerSum * 100) / todaySpend
//        Toast.makeText(context, "높이 = $result", Toast.LENGTH_SHORT).show()

        //'오늘 소비 가능 금액' 계산
        if ((todaySpend - recyclerSum) > 0) {

            ((activity as MainActivity).supportFragmentManager
                .findFragmentById(R.id.fragment) as HomeFragment).setTodayAvailable(todaySpend - recyclerSum)
        } else {
            //'오늘 소비 가능 금액' 우선 0으로 만들어두기
            ((activity as MainActivity).supportFragmentManager
                .findFragmentById(R.id.fragment) as HomeFragment).setTodayAvailable(0)

            //초과 소비 dialog 띄우기
            val bottomSheetDialogFragment = HomeFragmentExcessDialog()
            bottomSheetDialogFragment.show(parentFragmentManager, bottomSheetDialogFragment.tag)
        }

        //프로그레스바 높이 = 리사이클러뷰로 입력된 총 금액 / 오늘 소비 가능 금액 * 100
        return (recyclerSum * 100) / todaySpend
    }
}