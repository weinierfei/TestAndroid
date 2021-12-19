package com.example.testandroid

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder

/**
 * Description:
 * @author: guoyongping
 * @date:  2021/12/18 11:57
 */
class CoordinatorAdapter : BaseQuickAdapter<String, BaseViewHolder>(R.layout.item_test) {
    override fun convert(holder: BaseViewHolder, item: String) {
        holder.setText(R.id.tv_item, item)
    }
}