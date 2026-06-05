package org.subham.data.datasource

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import org.subham.data.model.SignInResponse
import org.subham.data.model.TravelListingDto
import org.subham.data.model.TravelListingResponse
import org.subham.data.model.request.RegisterRequest
import org.subham.data.model.request.SignInRequest

class RemoteDataSource(
    private val httpClient: HttpClient,
    private val baseUrl: String
) {


    private val SIGN_IN_ENDPOINT = "${baseUrl}/auth/login"
    private val SIGN_UP_ENDPOINT = "${baseUrl}/auth/register"
    private val TRAVEL_LISTING_ENDPOINT = "${baseUrl}/listings"
    private val LISTING_ENDPOINT = "${baseUrl}/listings"

    private val getListingByIdEndpoint = { id: String -> "$LISTING_ENDPOINT/$id" }
    suspend fun signIn(request: SignInRequest): Result<SignInResponse> {
        return try {
            val response = httpClient.post(urlString = SIGN_IN_ENDPOINT) {
                setBody(request)
            }
            Result.success(response.body())
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    suspend fun register(request: RegisterRequest): Result<SignInResponse> {
        return try {
            val response = httpClient.post(urlString = SIGN_UP_ENDPOINT) {
                setBody(request)
            }
            Result.success(response.body())
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    suspend fun getAllListings(): Result<TravelListingResponse> {
        return try {
            val response = httpClient.get(urlString = TRAVEL_LISTING_ENDPOINT)
            Result.success(response.body())
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    suspend fun getListingById(id: String): Result<TravelListingDto> {
        return try {

            val response = httpClient.get(urlString = getListingByIdEndpoint(id))
            Result.success(response.body())
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}