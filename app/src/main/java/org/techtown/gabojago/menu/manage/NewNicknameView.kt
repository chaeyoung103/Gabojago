package org.techtown.gabojago.menu.manage

interface NewNicknameView {
    fun onModifyNicknameSuccess(newNickname: String)
    fun onModifyNicknameFailure(code: Int, message: String)
}