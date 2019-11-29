package com.ldl.reading.core

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModelProviders

/**
 * 作者：LDL 创建时间：2019/9/16
 * 类说明：
 */
abstract class BaseActivity<out P : BaseViewModel> : AppCompatActivity(), IBaseViewModelEventObserver, IBaseView<P> {

    private var mViewModel: P? = null

    protected fun getViewModel() = mViewModel!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutId())
        initView()
        initViewModelEvent()
    }

    override fun initViewModel(): BaseViewModel? {
        val clazz = registerViewModel()
        val constructor = clazz.getConstructor()
        mViewModel = constructor.newInstance()
        return mViewModel
    }

    override fun getLContext(): Context = this

    override fun getLifecycleOwner(): LifecycleOwner = this

    override fun showLoading(msg: String) {

    }

    override fun dismissLoading() {

    }

    override fun finishView() {
        finish()
    }

    override fun pop() {

    }

    fun <T : BaseViewModel> getViewModel(clazz: Class<T>) =
        ViewModelProviders.of(this).get(clazz)

}

abstract class BaseFragment<out P : BaseViewModel> : Fragment(), IBaseViewModelEventObserver, IBaseView<P> {

    private var mViewModel: P? = null

    protected fun getViewModel() = mViewModel!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(getLayoutId(), container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        initViewModelEvent()
    }

    override fun initViewModel(): BaseViewModel? {
        val clazz = registerViewModel()
        val constructor = clazz.getConstructor()
        mViewModel = constructor.newInstance()
        return mViewModel
    }

    override fun getLContext(): Context = this.context!!

    override fun getLifecycleOwner(): LifecycleOwner = this

    override fun showLoading(msg: String) {

    }

    override fun dismissLoading() {

    }

    override fun finishView() {
        activity?.finish()
    }

    override fun pop() {

    }

    fun <T : BaseViewModel> getViewModel(clazz: Class<T>) =
        ViewModelProviders.of(this).get(clazz)

}