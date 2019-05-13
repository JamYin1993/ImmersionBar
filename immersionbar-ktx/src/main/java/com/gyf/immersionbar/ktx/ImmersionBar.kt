package com.gyf.immersionbar.ktx

import android.app.Activity
import android.app.Dialog
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import android.view.View
import com.gyf.immersionbar.ImmersionBar

/**
 * @author geyifeng
 * @date 2019/3/27 5:45 PM
 */

// 初始化ImmersionBar
inline fun Activity.immersionBar(block: ImmersionBar.() -> Unit) = ImmersionBar.with(this).apply { block(this) }.init()

inline fun androidx.fragment.app.Fragment.immersionBar(block: ImmersionBar.() -> Unit) = ImmersionBar.with(this).apply { block(this) }.init()

inline fun androidx.fragment.app.DialogFragment.immersionBar(block: ImmersionBar.() -> Unit) = ImmersionBar.with(this).apply { block(this) }.init()

inline fun Dialog.immersionBar(activity: Activity, block: ImmersionBar.() -> Unit) = ImmersionBar.with(activity, this).apply { block(this) }.init()

inline fun Activity.immersionBar(dialog: Dialog, block: ImmersionBar.() -> Unit) = ImmersionBar.with(this, dialog).apply { block(this) }.init()

inline fun androidx.fragment.app.Fragment.immersionBar(dialog: Dialog, block: ImmersionBar.() -> Unit) = activity?.run { ImmersionBar.with(this, dialog).apply { block(this) }.init() }
        ?: Unit

fun Activity.immersionBar() = immersionBar { }

fun androidx.fragment.app.Fragment.immersionBar() = immersionBar { }

fun androidx.fragment.app.DialogFragment.immersionBar() = immersionBar { }

fun Dialog.immersionBar(activity: Activity) = immersionBar(activity) {}

fun Activity.immersionBar(dialog: Dialog) = immersionBar(dialog) {}

fun androidx.fragment.app.Fragment.immersionBar(dialog: Dialog) = immersionBar(dialog) {}

fun Activity.destroyImmersionBar(dialog: Dialog) = ImmersionBar.destroy(this, dialog)

fun androidx.fragment.app.Fragment.destroyImmersionBar(dialog: Dialog) = activity?.run { ImmersionBar.destroy(this, dialog) }
        ?: Unit

// 状态栏扩展
val Activity.statusBarHeight get() = ImmersionBar.getStatusBarHeight(this)

val androidx.fragment.app.Fragment.statusBarHeight get() = activity?.run { ImmersionBar.getStatusBarHeight(this) } ?: 0

// 导航栏扩展
val Activity.navigationBarHeight get() = ImmersionBar.getNavigationBarHeight(this)

val androidx.fragment.app.Fragment.navigationBarHeight
    get() = activity?.run { ImmersionBar.getNavigationBarHeight(this) } ?: 0

val Activity.navigationBarWidth get() = ImmersionBar.getNavigationBarWidth(this)

val androidx.fragment.app.Fragment.navigationBarWidth
    get() = activity?.run { ImmersionBar.getNavigationBarWidth(this) } ?: 0

// ActionBar扩展
val Activity.actionBarHeight get() = ImmersionBar.getActionBarHeight(this)

val androidx.fragment.app.Fragment.actionBarHeight get() = activity?.run { ImmersionBar.getActionBarHeight(this) } ?: 0

// 是否有导航栏
val Activity.hasNavigationBar get() = ImmersionBar.hasNavigationBar(this)

val androidx.fragment.app.Fragment.hasNavigationBar get() = activity?.run { ImmersionBar.hasNavigationBar(this) } ?: false

// 是否有刘海屏
val Activity.hasNotchScreen get() = ImmersionBar.hasNotchScreen(this)

val androidx.fragment.app.Fragment.hasNotchScreen get() = activity?.run { ImmersionBar.hasNotchScreen(this) } ?: false

val View.hasNotchScreen get() = ImmersionBar.hasNotchScreen(this)

// 是否支持状态栏字体变色
val isSupportStatusBarDarkFont get() = ImmersionBar.isSupportStatusBarDarkFont()

// 师傅支持导航栏图标
val isSupportNavigationIconDark get() = ImmersionBar.isSupportNavigationIconDark()

// 检查view是否使用了fitsSystemWindows
val View.checkFitsSystemWindows get() = ImmersionBar.checkFitsSystemWindows(this)

// 导航栏是否在底部
val Activity.isNavigationAtBottom get() = ImmersionBar.isNavigationAtBottom(this)
val androidx.fragment.app.Fragment.isNavigationAtBottom
    get() = activity?.run { ImmersionBar.isNavigationAtBottom(this) } ?: false

// statusBarView扩展
fun Activity.fitsStatusBarView(view: View) = ImmersionBar.setStatusBarView(this, view)

fun androidx.fragment.app.Fragment.fitsStatusBarView(view: View) = activity?.run { ImmersionBar.setTitleBarMarginTop(this, view) }
        ?: Unit

// titleBar扩展
fun Activity.fitsTitleBar(view: View) = ImmersionBar.setTitleBar(this, view)

fun androidx.fragment.app.Fragment.fitsTitleBar(view: View) {
    activity?.apply { ImmersionBar.setTitleBar(this, view) }
}

fun Activity.fitsTitleBarMarginTop(view: View) = ImmersionBar.setTitleBarMarginTop(this, view)

fun androidx.fragment.app.Fragment.fitsTitleBarMarginTop(view: View) = activity?.run { ImmersionBar.setTitleBarMarginTop(this, view) }
        ?: Unit

// 隐藏状态栏
fun Activity.hideStatusBar() = ImmersionBar.hideStatusBar(window)

fun androidx.fragment.app.Fragment.hideStatusBar() {
    activity?.apply {
        ImmersionBar.hideStatusBar(window)
    }
}

// 显示状态栏
fun Activity.showStatusBar() = ImmersionBar.showStatusBar(window)

fun androidx.fragment.app.Fragment.showStatusBar() {
    activity?.apply {
        ImmersionBar.showStatusBar(window)
    }
}

// 解决顶部与布局重叠问题，不可逆
fun Activity.setFitsSystemWindows() = ImmersionBar.setFitsSystemWindows(this)

fun androidx.fragment.app.Fragment.setFitsSystemWindows() {
    activity?.apply {
        ImmersionBar.setFitsSystemWindows(this)
    }
}




