package com.example.newappmarcket

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.newapplemarcket.MyAdapter
import com.example.newappmarcket.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {


        private lateinit var binding:ActivityMainBinding


        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            binding = ActivityMainBinding.inflate(layoutInflater)
            setContentView(binding.root)



            // 데이터 원본 준비
        val dataList = mutableListOf(
            Sell.Date("1일전"),
            Sell.Item(
                R.drawable.sample1,
                " \n" + " \t\n" + "산진 한달된 선풍기 팝니다",
                "서울 서대문구 창천동\n",
                1_000

            ),
            Sell.Item(
                R.drawable.sample2,
                "김치냉장고",
                "인천 계양구 귤현동",
                20_000
            ),
            Sell.Item(
                R.drawable.sample3,
                " \n" + " \t\n" + "샤넬 카드지갑",
                " \n" + " \t\n" + "수성구 범어동",
                10_000
            ),
            Sell.Item(
                R.drawable.sample4,
                "금고",
                " \n" + " \t\n" + "해운대구 우제2동",
                10_000
            ),
            Sell.Date("2일전"),
            Sell.Item(
                R.drawable.sample5,
                "갤럭시Z플립3 팝니다\n",
                " \n" + " \t\n" + "연제구 연산제8동",
                150_000
            ),
            Sell.Item(
                R.drawable.sample6,
                " \n" + " \t\n" + "프라다 복조리백\n",
                " \n" + " \t\n" + "수원시 영통구 원천동",
                50_000
            ),
            Sell.Item(
                R.drawable.sample7,
                " \n" + " \t\n" + "울산 동해오션뷰 60평 복층 펜트하우스 1일 숙박권 펜션 힐링 숙소 별장",
                " \n" + " \t\n" + "남구 옥동",
                150_000
            ),
            Sell.Item(
                R.drawable.sample8,
                " \n" + " \t\n" + "샤넬 탑핸들 가방",
                " \n" + " \t\n" + "동래구 온천제2동",
                180_000
            ),
            Sell.Item(
                R.drawable.sample9,
                " \n" + " \t\n" + "4행정 엔진분무기 판매합니다.",
                " \n" + " \t\n" + "원주시 명륜2동",
                30_000
            ),
            Sell.Item(
                R.drawable.sample10,
                " \n" + " \t\n" + "셀린느 버킷 가방",
                " \n" + " \t\n" + "중구 동화동",
                190_000
            )
        )

            val adapter = MyAdapter(dataList)
            binding.recyclerView.adapter = adapter
            binding.recyclerView.layoutManager = LinearLayoutManager(this)

            adapter.itemClick = object : MyAdapter.ItemClick {
                override fun onClick(view: View, position: Int) {
                    val name: String = (dataList[position] as Sell.Item).itemName
                    Toast.makeText(this@MainActivity," $name 선택!", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }











//
//    private lateinit var binding: ActivityMainBinding
//    private lateinit var myAdapter: MyAdapter
//    private lateinit var dataList: MutableList<Sell>
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        binding = ActivityMainBinding.inflate(layoutInflater)
//        setContentView(binding.root)
//
//        myAdapter = MyAdapter(dataList.toMutableList())
//        setupRecyclerView()
//        dataList = createDummyData()
////        val dataList = mutableListOf(
////            Sell.Date("1일전"),
////            Sell.Item(
////                R.drawable.sample1,
////                " \n" + " \t\n" + "산진 한달된 선풍기 팝니다",
////                "서울 서대문구 창천동\n",
////                1_000
////
////            ),
////            Sell.Item(
////                R.drawable.sample2,
////                "김치냉장고",
////                "인천 계양구 귤현동",
////                20_000
////            ),
////            Sell.Item(
////                R.drawable.sample3,
////                " \n" + " \t\n" + "샤넬 카드지갑",
////                " \n" + " \t\n" + "수성구 범어동",
////                10_000
////            ),
////            Sell.Item(
////                R.drawable.sample4,
////                "금고",
////                " \n" + " \t\n" + "해운대구 우제2동",
////                10_000
////            ),
////            Sell.Date("2일전"),
////            Sell.Item(
////                R.drawable.sample5,
////                "갤럭시Z플립3 팝니다\n",
////                " \n" + " \t\n" + "연제구 연산제8동",
////                150_000
////            ),
////            Sell.Item(
////                R.drawable.sample6,
////                " \n" + " \t\n" + "프라다 복조리백\n",
////                " \n" + " \t\n" + "수원시 영통구 원천동",
////                50_000
////            ),
////            Sell.Item(
////                R.drawable.sample7,
////                " \n" + " \t\n" + "울산 동해오션뷰 60평 복층 펜트하우스 1일 숙박권 펜션 힐링 숙소 별장",
////                " \n" + " \t\n" + "남구 옥동",
////                150_000
////            ),
////            Sell.Item(
////                R.drawable.sample8,
////                " \n" + " \t\n" + "샤넬 탑핸들 가방",
////                " \n" + " \t\n" + "동래구 온천제2동",
////                180_000
////            ),
////            Sell.Item(
////                R.drawable.sample9,
////                " \n" + " \t\n" + "4행정 엔진분무기 판매합니다.",
////                " \n" + " \t\n" + "원주시 명륜2동",
////                30_000
////            ),
////            Sell.Item(
////                R.drawable.sample10,
////                " \n" + " \t\n" + "셀린느 버킷 가방",
////                " \n" + " \t\n" + "중구 동화동",
////                190_000
////            )
////        )
//
//
//        val adapter = MyAdapter(dataList)
//        adapter.itemClick = object : MyAdapter.ItemClick {
//            override fun onClick(view: View, position: Int) {
//                val name: String = (dataList[position] as Sell.Item).itemName
//                Toast.makeText(this@MainActivity, " $name 선택!", Toast.LENGTH_SHORT).show()
//            }
//        }
//    }
//
//    private fun setupRecyclerView() {
//
//        binding.recyclerView.layoutManager = LinearLayoutManager(this)
//        binding.recyclerView.adapter = myAdapter
//
//    }
//
//
//    private fun createDummyData(): MutableList<Sell> {
//        val dataList = mutableListOf<Sell>()
//
//        dataList.add(Sell.Date("1일전"))
//        dataList.add(
//            Sell.Item(
//                R.drawable.sample1,
//                " \n" + " \t\n" + "산진 한달된 선풍기 팝니다",
//                "서울 서대문구 창천동\n",
//                1_000
//
//        )
//        dataList.add(
//            Sell.Item(
//                R.drawable.sample2,
//                "김치냉장고",
//                "인천 계양구 귤현동",
//                20_000
//            )
//        )
//        dataList.add(
//            Sell.Item(
//                R.drawable.sample3,
//                " \n" + " \t\n" + "샤넬 카드지갑",
//                " \n" + " \t\n" + "수성구 범어동",
//                10_000
//            )
//        )
//        dataList.add(
//            Sell.Item(
//                R.drawable.sample4,
//                "금고",
//                " \n" + " \t\n" + "해운대구 우제2동",
//                10_000
//            )
//        )
//        dataList.add(Sell.Date("2일전"))
//        dataList.add(
//            Sell.Item(
//                R.drawable.sample5,
//                "갤럭시Z플립3 팝니다\n",
//                " \n" + " \t\n" + "연제구 연산제8동",
//                150_000
//            )
//        )
//        dataList.add(
//            Sell.Item(
//                R.drawable.sample6,
//                " \n" + " \t\n" + "프라다 복조리백\n",
//                " \n" + " \t\n" + "수원시 영통구 원천동",
//                50_000
//            )
//        )
//        dataList.add(
//            Sell.Item(
//                R.drawable.sample7,
//                " \n" + " \t\n" + "울산 동해오션뷰 60평 복층 펜트하우스 1일 숙박권 펜션 힐링 숙소 별장",
//                " \n" + " \t\n" + "남구 옥동",
//                150_000
//            )
//        )
//        dataList.add(
//            Sell.Item(
//                R.drawable.sample8,
//                " \n" + " \t\n" + "샤넬 탑핸들 가방",
//                " \n" + " \t\n" + "동래구 온천제2동",
//                180_000
//            )
//        )
//        dataList.add(
//            Sell.Item(
//                R.drawable.sample9,
//                " \n" + " \t\n" + "4행정 엔진분무기 판매합니다.",
//                " \n" + " \t\n" + "원주시 명륜2동",
//                30_000
//            )
//        )
//        dataList.add(
//            Sell.Item(
//                R.drawable.sample10,
//                " \n" + " \t\n" + "셀린느 버킷 가방",
//                " \n" + " \t\n" + "중구 동화동",
//                190_000
//            )
//        )
//
//        return
//    }
//
//}
//
//
//
//
//
//
////    private fun createUpdatedDummyData(): List<Sell> {
////        val newDummyData = createUpdatedDummyData()
////        val updatedDummyData = mutableListOf<Sell>()
////        myAdapter.updateData(newDummyData)
////        // 업데이트에 필요한 작업 수행 수정 필요
////
////        return updatedDummyData
////    }
