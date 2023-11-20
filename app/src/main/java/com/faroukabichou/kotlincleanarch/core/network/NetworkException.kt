package com.faroukabichou.kotlincleanarch.core.network

open class NetworkException(message: String? = null, cause: Throwable? = null) : Exception(message, cause)

class UnauthorizedException(cause: Throwable? = null) : NetworkException(message = "Unauthorized", cause = cause)
class ServerErrorException(code: Int) : NetworkException(message = "Server error")
class BadRequestException(code: Int) : NetworkException(message = "Bad request")
class DataConversionException(cause: Throwable? = null) :
    NetworkException(message = "Data conversion error", cause = cause)
class UnknownNetworkException(cause: Throwable? = null) :
    NetworkException(message = "Unknown network error", cause = cause)