package com.faroukabichou.kotlincleanarch.core.network.helper

import com.faroukabichou.kotlincleanarch.core.network.*
import io.ktor.client.call.body
import io.ktor.client.statement.HttpResponse
import io.ktor.utils.io.errors.IOException
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

suspend inline fun <reified T> handleErrors(
    crossinline response: suspend () -> HttpResponse
): T = withContext(Dispatchers.IO) {
    val response = try {
        response()
    } catch(e: UnauthorizedException) {
        throw e
    } catch (e: Exception) {
        throw UnknownNetworkException(e)
    }

    when(response.status.value) {
        in 200..299 -> Unit
        401 -> throw UnauthorizedException()
        in 400..499 -> throw BadRequestException(code = response.status.value)
        in 500..599 -> throw ServerErrorException(code = response.status.value)
        else -> throw UnknownNetworkException()
    }

    return@withContext try {
        response.body<T>()
    } catch(e: Exception) {
        e.printStackTrace()
        throw DataConversionException(e)
    }
}

suspend inline fun handleErrorsSimple(
    crossinline response: suspend () -> HttpResponse
) = withContext(Dispatchers.IO) {
    val response = try {
        response()
    } catch(e: IOException) {
        throw UnknownNetworkException(e)
    }

    when(response.status.value) {
        in 200..299 -> Unit
        401 -> throw UnauthorizedException()
        in 400..499 -> throw BadRequestException(code = response.status.value)
        in 500..599 -> throw ServerErrorException(code = response.status.value)
        else -> throw UnknownNetworkException()
    }
}
