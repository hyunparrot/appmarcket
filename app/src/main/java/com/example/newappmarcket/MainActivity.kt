package com.example.newappmarcket

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Intent
import android.media.AudioAttributes
import android.media.RingtoneManager
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.animation.AlphaAnimation
import androidx.activity.result.ActivityResultLauncher
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.newappmarcket.databinding.ActivityMainBinding



class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val dataList = mutableListOf<Sell>()
    lateinit var activityResultLauncher: ActivityResultLauncher<Intent>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        dataList.add(Sell.Date("1일전"))
        dataList.add(
            Sell(
                R.drawable.sample1,
                " \n" + " \t\n" + "산진 한달된 선풍기 팝니다",
                "서울 서대문구 창천동\n",
                1_000,
                "이사가서 필요가 없어졌어요 급하게 내놓습니다",
                "대현동",
                25,
                13,
                false
            )
        )
        dataList.add(
            Sell(
                R.drawable.sample2,
                "김치냉장고",
                "인천 계양구 귤현동",
                20_000,
                "이사로인해 내놔요",
                "안마담",
                28,
                8,
                false
            )
        )
        dataList.add(
            Sell(
                R.drawable.sample3,
                " \n" + " \t\n" + "샤넬 카드지갑",
                " \n" + " \t\n" + "수성구 범어동",
                10_000,
                "고퀄지갑이구요\\n사용감이 있어서 싸게 내어둡니다",
                "코코유",
                5,
                23,
                false

            )
        )
        dataList.add(
            Sell(
                R.drawable.sample4,
                "금고",
                " \n" + " \t\n" + "해운대구 우제2동",
                10_000,
                " \n" +
                        " \t\n" +
                        "금고\\n떼서 가져가야함\\n대우월드마크센텀\\n미국이주관계로 싸게 팝니다",
                "Nicole",
                17,
                14,
                false
            )
        )

//        dataList.add(Sell.Date("2일전"))

        dataList.add(
            Sell(
                R.drawable.sample5,
                "갤럭시Z플립3 팝니다\n",
                " \n" + " \t\n" + "연제구 연산제8동",
                150_000,
                "갤럭시 Z플립3 그린 팝니다\\n항시 케이스 씌워서 썻고 필름 한장챙겨드립니다\\n화면에 살짝 스크래치난거 말고 크게 이상은없습니다!",
                "절명",
                9,
                22,
                false
            )
        )
        dataList.add(
            Sell(
                R.drawable.sample6,
                " \n" + " \t\n" + "프라다 복조리백\n",
                " \n" + " \t\n" + "수원시 영통구 원천동",
                50_000,
                " \n" +
                        " \t\n" +
                        "까임 오염없고 상태 깨끗합니다\\n정품여부모름",
                "미니멀하게",
                16,
                25,
                false
            )
        )
        dataList.add(
            Sell(
                R.drawable.sample7,
                " \n" + " \t\n" + "울산 동해오션뷰 60평 복층 펜트하우스 1일 숙박권 펜션 힐링 숙소 별장",
                " \n" + " \t\n" + "남구 옥동",
                150_000,
                " \n" +
                        " \t\n" +
                        "울산 동해바다뷰 60평 복층 펜트하우스 1일 숙박권\\n(에어컨이 없기에 낮은 가격으로 변경했으며 8월 초 가장 더운날 다녀가신 분 경우 시원했다고 잘 지내다 가셨습니다)\\n1. 인원: 6명 기준입니다. 1인 10,000원 추가요금\\n2. 장소: 북구 블루마시티, 32-33층\\n3. 취사도구, 침구류, 세면도구, 드라이기 2개, 선풍기 4대 구비\\n4. 예약방법: 예약금 50,000원 하시면 저희는 명함을 드리며 입실 오전 잔금 입금하시면 저희는 동.호수를 알려드리며 고객님은 예약자분 신분증 앞면 주민번호 뒷자리 가리시거나 지우시고 문자로 보내주시면 저희는 카드키를 우편함에 놓아 둡니다.\\n5. 33층 옥상 야외 테라스 있음, 가스버너 있음\\n6. 고기 굽기 가능\\n7. 입실 오후 3시, 오전 11시 퇴실, 정리, 정돈 , 밸브 잠금 부탁드립니다.\\n8. 층간소음 주의 부탁드립니다.\\n9. 방3개, 화장실3개, 비데 3개\\n10. 저희 집안이 쓰는 별장입니다.",
                "굿리치",
                54,
                142,
                false
            )
        )
        dataList.add(
            Sell(
                R.drawable.sample8,
                " \n" + " \t\n" + "샤넬 탑핸들 가방",
                " \n" + " \t\n" + "동래구 온천제2동",
                180_000,
                " \n" +
                        " \t\n" +
                        "샤넬 트랜디 CC 탑핸들 스몰 램스킨 블랙 금장 플랩백 !\\n + \"\\n\" + \"색상 : 블랙\\n\" + \"사이즈 : 25.5cm * 17.5cm * 8cm\\n\" + \"구성 : 본품더스트\\n\" + \"\\n\" + \"급하게 돈이 필요해서 팝니다 ㅠ ㅠ",
                "난쉽",
                7,
                31,
                false
            )
        )
        dataList.add(
            Sell(
                R.drawable.sample9,
                " \n" + " \t\n" + "4행정 엔진분무기 판매합니다.",
                " \n" + " \t\n" + "원주시 명륜2동",
                30_000,
                "3년전에 사서 한번 사용하고 그대로 둔 상태입니다. 요즘 사용은 안해봤습니다. 그래서 저렴하게 내 놓습니다. 중고라 반품은 어렵습니다.\\n",
                "알뜰한",
                28,
                7,
                false
            )
        )
        dataList.add(
            Sell(
                R.drawable.sample10,
                " \n" + " \t\n" + "셀린느 버킷 가방",
                " \n" + " \t\n" + "중구 동화동",
                190_000,
                "22년 신세계 대전 구매입니당\\n + \"셀린느 버킷백\\n\" + \"구매해서 몇번사용했어요\\n\" + \"까짐 스크래치 없습니다.\\n\" + \"타지역에서 보내는거라 택배로 진행합니당!\"",
                "똑태현",
                6,
                40,
                false
            )
        )


        val adapter = ItemAdapter(dataList)
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(this)

        adapter.itemClick = object : ItemAdapter.ItemClick {
            override fun onClick(view: View, position: Int) {
                val intent = Intent(this@MainActivity, DetailActivity::class.java)
                intent.putExtra(Constants.ITEM_INDEX, position);
                intent.putExtra(Constants.ITEM_OBJECT, dataList[position]);
                activityResultLauncher.launch(intent)
            }
        }

//        adapter.itemLongClick = object : MyAdapter.ItemLongClick {
//            override fun onLongClick(view: View, position: Int) {
//                val ad = AlertDialog.Builder(this@com.example.newappmarcket.MainActivity)
//                ad.setIcon(R.drawable.img_chat)
//                ad.setTitle("상품삭제")
//                ad.setMessage("상품을 정말로 삭제하시겠습니까?")
//        선택과제 마지막꺼


//            }
//        }

        binding.imageAr.setOnClickListener {
            notification()
            //종 누르면  notification()
        }
        val celsiusTemperature = 39.3
        val fahrenheitTemperature = (celsiusTemperature * 9/5) + 32

        val fadeIn = AlphaAnimation(0f, 1f).apply { duration = 500 }
        val fadeout = AlphaAnimation(1f, 0f).apply { duration = 500 }
        var isTop = true
//        애니메이션 주는거
    }
        override fun onBackPressed() {
            val ad = AlertDialog.Builder(this)
            ad.setIcon(R.drawable.sample1)
            ad.setTitle("종료")
            ad.setMessage("정말 종료하시겠습니까?")

            ad.setPositiveButton("확인") { dialog, _ ->
                finish()
            }
            ad.setNegativeButton("취소") { dialog,_ ->
//                onClick 대신 람다식
                dialog.dismiss()
            }
            ad.show()
            //알림창 뜨는거

        }

        fun notification() {
            val manager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager

            val builder: NotificationCompat.Builder
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                val channelId = "one=channel"
                val channelName = "My Channel One"
                val channel = NotificationChannel(
                    channelId,
                    channelName,
                    NotificationManager.IMPORTANCE_DEFAULT
                ).apply {

                    description = "My Channel One Description"
                    setShowBadge(true)
                    val uri: Uri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)
                    val audioAttributes = AudioAttributes.Builder()
                        .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                        .setUsage(AudioAttributes.USAGE_ALARM)
                        .build()
                    setSound(uri, audioAttributes)
                    enableVibration(true)
                }
                manager.createNotificationChannel(channel)

                builder = NotificationCompat.Builder(this, channelId)

            } else {
                builder = NotificationCompat.Builder(this)
            }

            builder.run {
                setSmallIcon(R.mipmap.ic_launcher)
                setWhen(System.currentTimeMillis())
                setContentTitle("키워드 알림")
                setContentText("설정한 키워드에 대한 알림이 도착했습니다!!")
            }
            manager.notify(11, builder.build())
        }

}

//
//
//        private lateinit var binding:ActivityMainBinding
//
//
//        override fun onCreate(savedInstanceState: Bundle?) {
//            super.onCreate(savedInstanceState)
//            binding = ActivityMainBinding.inflate(layoutInflater)
//            setContentView(binding.root)
//
//
//
//            // 데이터 원본 준비
//        val dataList = mutableListOf(
//            Sell.Date("1일전"),
//            Sell.Item(
//                R.drawable.sample1,
//                " \n" + " \t\n" + "산진 한달된 선풍기 팝니다",
//                "서울 서대문구 창천동\n",
//                1_000
//
//            ),
//            Sell.Item(
//                R.drawable.sample2,
//                "김치냉장고",
//                "인천 계양구 귤현동",
//                20_000
//            ),
//            Sell.Item(
//                R.drawable.sample3,
//                " \n" + " \t\n" + "샤넬 카드지갑",
//                " \n" + " \t\n" + "수성구 범어동",
//                10_000
//            ),
//            Sell.Item(
//                R.drawable.sample4,
//                "금고",
//                " \n" + " \t\n" + "해운대구 우제2동",
//                10_000
//            ),
//            Sell.Date("2일전"),
//            Sell.Item(
//                R.drawable.sample5,
//                "갤럭시Z플립3 팝니다\n",
//                " \n" + " \t\n" + "연제구 연산제8동",
//                150_000
//            ),
//            Sell.Item(
//                R.drawable.sample6,
//                " \n" + " \t\n" + "프라다 복조리백\n",
//                " \n" + " \t\n" + "수원시 영통구 원천동",
//                50_000
//            ),
//            Sell.Item(
//                R.drawable.sample7,
//                " \n" + " \t\n" + "울산 동해오션뷰 60평 복층 펜트하우스 1일 숙박권 펜션 힐링 숙소 별장",
//                " \n" + " \t\n" + "남구 옥동",
//                150_000
//            ),
//            Sell.Item(
//                R.drawable.sample8,
//                " \n" + " \t\n" + "샤넬 탑핸들 가방",
//                " \n" + " \t\n" + "동래구 온천제2동",
//                180_000
//            ),
//            Sell.Item(
//                R.drawable.sample9,
//                " \n" + " \t\n" + "4행정 엔진분무기 판매합니다.",
//                " \n" + " \t\n" + "원주시 명륜2동",
//                30_000
//            ),
//            Sell.Item(
//                R.drawable.sample10,
//                " \n" + " \t\n" + "셀린느 버킷 가방",
//                " \n" + " \t\n" + "중구 동화동",
//                190_000
//            )
//        )
//
//            val adapter = MyAdapter(dataList)
//            binding.recyclerView.adapter = adapter
//            binding.recyclerView.layoutManager = LinearLayoutManager(this)
//
//            adapter.itemClick = object : MyAdapter.ItemClick {
//                override fun onClick(view: View, position: Int) {
//                    val name: String = (dataList[position] as Sell.Item).itemName
//                    Toast.makeText(this@com.example.newappmarcket.MainActivity," $name 선택!", Toast.LENGTH_SHORT).show()
//                }
//            }
//        }
//    }
//
//









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
//                Toast.makeText(this@com.example.newappmarcket.MainActivity, " $name 선택!", Toast.LENGTH_SHORT).show()
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
