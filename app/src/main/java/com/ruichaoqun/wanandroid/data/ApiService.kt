package com.ruichaoqun.wanandroid.data

import retrofit2.http.*

/**
 *
 * @Author:         芮超群
 * @CreateDate:     2021/3/26 14:06
 * @Description:    ApiService
 * @Version:        1.0
 */
interface ApiService {
    @GET("/article/list/{page}/json")
    suspend fun getHomeList(@Path("page") page:Int,@Query("cid") cid:String ?= null,@Query("author") author:String ?= null):BaseResponse<HomeListResponse.Data>

    @GET("/banner/json")
    suspend fun getBanner():BaseResponse<MutableList<BannerBean>>

    @POST("/user/login")
    @FormUrlEncoded
    suspend fun login(@Field("username") username:String,@Field("password") password:String):BaseResponse<Any>

    @POST("/user/register")
    @FormUrlEncoded
    suspend fun register(@Field("username") username:String,@Field("password") password:String,@Field("repassword") repassword:String):BaseResponse<Any>

    @GET("/tree/json")
    suspend fun getSystemTree():BaseResponse<MutableList<SystemTreeBean>>
}