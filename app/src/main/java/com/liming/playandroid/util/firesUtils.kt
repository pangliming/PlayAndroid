package com.liming.playandroid.util

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.liveData
import com.liming.playandroid.base.BaseModel
import java.lang.Exception

/**
 * @author pangliming
 *
 */

fun <T> fires(block: suspend () -> BaseModel<T>) =
    liveData {
        val result = try {
            val baseModel = block()
            if (baseModel.errorCode == 0) {
                Result.success(baseModel.data)
            } else {
                Log.e("firesUtils", "fire: 请求数据失败 ")
            }
        } catch (e: Exception) {

        }
        emit(result)
    }

fun <T> fire(block: suspend () -> Result<T>) =
    liveData {
        val result = try {
            block()
        } catch (e: Exception) {
            Log.e("firesUtils", "fire: ${e.message}" )
            Result.failure(e)
        }
        emit(result)
    }
