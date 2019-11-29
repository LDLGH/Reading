package com.ldl.reading.widget

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import com.ldl.reading.R


/**
 * 作者：LDL 创建时间：2019/9/16
 * 类说明：
 */
class MainMenuView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr), View.OnClickListener {

    companion object {

        const val MENU_FIND = 0

        const val MENU_BOOKSHELF = 1

        const val MENU_STORY = 2

        const val MENU_MINE = 3

    }

    private lateinit var mTvFind: TextView
    private lateinit var mTvBookshelf: TextView
    private lateinit var mTvStory: TextView
    private lateinit var mTvMine: TextView

    init {
        initView(context)
    }

    private fun initView(context: Context) {
        val inflater: LayoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        inflater.inflate(R.layout.view_main_menu, this)
        mTvFind = findViewById(R.id.tv_find)
        mTvBookshelf = findViewById(R.id.tv_bookshelf)
        mTvStory = findViewById(R.id.tv_story)
        mTvMine = findViewById(R.id.tv_mine)
        mTvFind.setOnClickListener(this)
        mTvBookshelf.setOnClickListener(this)
        mTvStory.setOnClickListener(this)
        mTvMine.setOnClickListener(this)
        mTvFind.isSelected = true
    }

    override fun onClick(p0: View?) {
        p0?.let {
            when (it.id) {
                R.id.tv_find -> {
                    menuAction(MENU_FIND)
                }
                R.id.tv_bookshelf -> {
                    menuAction(MENU_BOOKSHELF)
                }
                R.id.tv_story -> {
                    menuAction(MENU_STORY)
                }
                R.id.tv_mine -> {
                    menuAction(MENU_MINE)
                }
                else -> {
                    menuAction(MENU_FIND)
                }
            }
        }
    }

    private fun menuAction(menu: Int) {
        mTvFind.isSelected = menu == MENU_FIND
        mTvBookshelf.isSelected = menu == MENU_BOOKSHELF
        mTvStory.isSelected = menu == MENU_STORY
        mTvMine.isSelected = menu == MENU_MINE
        menuListener.onMenuListener(menu)
    }

    interface MenuListener {
        fun onMenuListener(menu: Int)
    }

    private lateinit var menuListener: MenuListener

    fun setMenuListener(menuListener: MenuListener) {
        this.menuListener = menuListener
    }

}