package com.hiepdt.vpstest.ui.main

import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatDelegate
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.fragment.app.Fragment
import com.hiepdt.vpstest.R
import com.hiepdt.vpstest.base.BaseActivity
import com.hiepdt.vpstest.models.TabPagerModel
import com.hiepdt.vpstest.ui.TempFragment
import com.hiepdt.vpstest.ui.home.HomeFragment
import kotlinx.android.synthetic.main.activity_main.*
import net.lucode.hackware.magicindicator.ViewPagerHelper
import net.lucode.hackware.magicindicator.buildins.UIUtil
import net.lucode.hackware.magicindicator.buildins.commonnavigator.CommonNavigator
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.CommonNavigatorAdapter
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerIndicator
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerTitleView
import net.lucode.hackware.magicindicator.buildins.commonnavigator.indicators.LinePagerIndicator
import net.lucode.hackware.magicindicator.buildins.commonnavigator.indicators.WrapPagerIndicator
import net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.CommonPagerTitleView
import net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.CommonPagerTitleView.OnPagerTitleChangeListener

class MainActivity : BaseActivity() {
    private var pagerAdapter: MainPagerAdapter? = null
    private var homeFragment: HomeFragment? = null
    private var tempFragment1: TempFragment? = null
    private var tempFragment2: TempFragment? = null
    private var tempFragment3: TempFragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

        initViews()
        initActions()
    }

    private fun initViews() {
        homeFragment = HomeFragment.newInstance()
        tempFragment1 = TempFragment.newInstance()
        tempFragment2 = TempFragment.newInstance()
        tempFragment3 = TempFragment.newInstance()

        val mListFragment = ArrayList<Fragment>()
        homeFragment?.let { mListFragment.add(it) }
        tempFragment1?.let { mListFragment.add(it) }
        tempFragment2?.let { mListFragment.add(it) }
        tempFragment3?.let { mListFragment.add(it) }

        pagerAdapter = MainPagerAdapter(supportFragmentManager, mListFragment)
        mViewPager?.adapter = pagerAdapter
        mViewPager?.offscreenPageLimit = mListFragment.size

        val dataList = ArrayList<TabPagerModel>()
        dataList.add(TabPagerModel(0, R.drawable.ic_home, "Trang chủ"))
        dataList.add(TabPagerModel(1, R.drawable.ic_bar_chart, "Biểu đồ"))
        dataList.add(TabPagerModel(2, R.drawable.ic_saving, "Tiết kiệm"))
        dataList.add(TabPagerModel(3, R.drawable.ic_cash, "Thanh toán"))
        val commonNavigator = CommonNavigator(this)
        commonNavigator.isAdjustMode = true
        commonNavigator.adapter = object : CommonNavigatorAdapter() {
            override fun getCount(): Int {
                return dataList.size
            }

            override fun getTitleView(context: Context, index: Int): IPagerTitleView {
                val commonPagerTitleView = CommonPagerTitleView(context)

                // load custom layout
                val customLayout: View = LayoutInflater.from(context).inflate(R.layout.layout_tab_layout_item, null)
                val titleImg = customLayout.findViewById<AppCompatImageView>(R.id.imgIcon) as ImageView
                val titleText = customLayout.findViewById<AppCompatTextView>(R.id.tvTabName) as TextView
                dataList[index].icon?.let { titleImg.setImageResource(it) }
                titleText.text = dataList[index].title ?: ""
                if (index == 0) titleText.visibility = View.VISIBLE
                commonPagerTitleView.setContentView(customLayout)
                commonPagerTitleView.onPagerTitleChangeListener = object : OnPagerTitleChangeListener {
                    override fun onSelected(index: Int, totalCount: Int) {
                        titleText.visibility = View.VISIBLE
                    }

                    override fun onDeselected(index: Int, totalCount: Int) {
                        titleText.visibility = View.GONE
                    }

                    override fun onLeave(index: Int, totalCount: Int, leavePercent: Float, leftToRight: Boolean) {
                        titleText.visibility = View.GONE
                    }

                    override fun onEnter(index: Int, totalCount: Int, enterPercent: Float, leftToRight: Boolean) {
                        titleText.visibility = View.VISIBLE
                    }
                }
                commonPagerTitleView.setOnClickListener { mViewPager.currentItem = index }
                return commonPagerTitleView
            }

            override fun getIndicator(context: Context): IPagerIndicator {
                val indicator = LinePagerIndicator(context)
                val navigatorHeight = context.resources.getDimension(R.dimen._30sdp)
                val borderWidth = UIUtil.dip2px(context, 1.0).toFloat()
                val lineHeight = navigatorHeight - 2 * borderWidth
                indicator.lineHeight = lineHeight
                indicator.roundRadius = lineHeight / 2
                indicator.yOffset = borderWidth
                indicator.mode = LinePagerIndicator.MODE_WRAP_CONTENT
                indicator.setColors(Color.parseColor("#F6F6F6"))
                return indicator
//
//                val indicator = WrapPagerIndicator(context)
//                indicator.horizontalPadding = context.resources.getDimensionPixelOffset(R.dimen._4sdp)
//                indicator.fillColor = Color.parseColor("#F6F6F6")
//                return indicator
            }
        }
        magicIndicator.navigator = commonNavigator
        commonNavigator.leftPadding = resources.getDimensionPixelOffset(R.dimen._4sdp)
        commonNavigator.rightPadding = resources.getDimensionPixelOffset(R.dimen._4sdp)
        ViewPagerHelper.bind(magicIndicator, mViewPager)
    }

    private fun initActions() {

    }
}